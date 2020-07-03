<template>
    <div id="Main">
        <router-view></router-view>
        <el-container>
            <el-header>
                <div class="info">
                    <img class="image1" :src="faceBase64" :key="imageKey"/>
                    <div class="textInfo">
                        <span class="info-text">用户名：{{username}}</span>
                        <span class="info-text" style="margin-top: 10px">个人介绍：{{description}}</span>
                    </div>
                </div>
                <el-button style="margin-left: 1000px;width: 200px" type="info" plain @click="write">写文章</el-button>
                <hr  style="width: 95%;margin-top: 30px"/>
            </el-header>
            <el-main class="main">
                <el-menu
                        default-active="2"
                        class="el-menu-vertical-demo menu"
                        >
                    <el-menu-item index="1" @click="menu1">
                        <i class="el-icon-edit"></i>
                        <span slot="title">修改信息</span>
                    </el-menu-item>
                    <el-menu-item index="2" @click="menu2">
                        <i class="el-icon-document"></i>
                        <span slot="title">我的文章</span>
                    </el-menu-item>
                    <el-menu-item index="3" @click="menu3">
                        <i class="el-icon-star-on"></i>
                        <span slot="title">我的收藏</span>
                    </el-menu-item>

                </el-menu>
                <div class="area" style="display: flex">
                    <div v-if="menuIndex == 1" style="width: 750px">
                        <el-form :label-position="labelPosition" label-width="80px" :model="formLabelAlign" style="padding-right: 200px" >
                            <el-form-item label="用户名">
                                <el-input v-model="formLabelAlign.name" :placeholder="username" :value="username"></el-input>
                            </el-form-item>
                            <el-form-item label="个人介绍">
                                <el-input v-model="formLabelAlign.description" :placeholder="description" :value="description"></el-input>
                            </el-form-item>
                            <el-form-item>
                                <input type="file" id="id" name="image" class="getImgUrl_file" @change="shangc($event)" accept="image/jpg,image/jpeg,image/png">
                                <el-button type="primary" @click="baocun">保存</el-button>
                            </el-form-item>
                        </el-form>

                    </div>
                    <div v-if="menuIndex == 2" style="width: 750px">
                        <div v-for="item in articles" v-bind:key="item.id" >
                            <div id="ArticleList">
                                <el-card class="box-card">
                                    <div slot="header" class="clearfix">
                                        <span class="article-title">{{item.title}}</span>
                                        <el-button style="float: right; padding: 3px 0" type="text" @click="click_article(item.id,item.author)" >查看</el-button>
                                    </div>
                                    <div class="text item " style="text-align: left">
                                        作者：{{username}}
                                    </div>
                                    <div class="text item" style="text-align: left">
                                        文章介绍：{{item.description}}
                                    </div>
                                </el-card>
                            </div>
                        </div>
                    </div>
                    <div v-if="menuIndex == 3" style="width: 750px">
                        <div v-for="item in favorites" v-bind:key="item.id">
                            <div id="ArticleList">
                                <el-card class="box-card">
                                    <div slot="header" class="clearfix">
                                        <span class="article-title">{{item.title}}</span>
                                        <el-button style="float: right; padding: 3px 0" type="text" @click="click_article(item.id,item.author)" >查看</el-button>
                                    </div>
                                    <div class="text item " style="text-align: left">
                                        作者：{{item.author_name}}
                                    </div>
                                    <div class="text item" style="text-align: left">
                                        文章介绍：{{item.description}}
                                    </div>
                                </el-card>
                            </div>
                        </div>

                    </div>
                    <div style="height: 1000px;margin-left: 30px;" >

                        <div style="margin-top: 15px;margin-left: 10px">
                            <el-input placeholder="请输入用户名" v-model="search_user_name" class="input-with-select">
                                <el-button slot="append" icon="el-icon-search" @click="search_user"></el-button>
                            </el-input>
                        </div>

                        <el-dropdown placement="bottom-start" style="margin-left: 200px;margin-top: 20px" >
                            <el-button type="primary">
                                我关注的人<i class="el-icon-arrow-down el-icon--right"></i>
                            </el-button>
                            <el-dropdown-menu slot="dropdown">
                                <div v-for="item in person_interested" @click="look_friend(item.friend_id,item.friend_name)" v-bind:key="'friend'+item.id">
                                    <el-dropdown-item >{{item.friend_name}}</el-dropdown-item>
                                </div>

                            </el-dropdown-menu>
                        </el-dropdown>
                    </div>

                </div>
            </el-main>
        </el-container>
    </div>

</template>

<script>
    export default {
        name: "main",
        data(){
            return{
                faceBase64:'',
                id: this.$route.query.id,
                username:"xxx",
                description:"sssssssssss",
                menuIndex: 2,
                articles:'',
                favorites:'',
                imageKey:0,
                labelPosition: 'right',
                //blob:'',
                formLabelAlign: {
                    name: this.username,
                    description: this.description,
                    type: ''
                },
                person_interested:[
                    {name: 'we', id: '2'},
                    {name: 'sssd', id: '21'},
                    {name: 'ssss', id: '11'},
                ],
                search_user_name:'',
            }
        },
        mounted: function(){
            this.$axios
                .post('/user/get_user_info', {
                    id:this.id
                })
                .then(successResponse => {
                    this.username = successResponse.data.name
                    this.description = successResponse.data.description
                    this.faceBase64 = successResponse.data.avatar

                })
            // .catch(failResponse => {
            // })
            this.$axios
                .post('/get_articles', {
                    id:this.id
                })
                .then(successResponse => {
                    this.articles=successResponse.data

                })
            // .catch(failResponse => {
            // })

            this.$axios
                .post('/get_follows', {
                    user_id:this.id
                })
                .then(successResponse => {
                    this.person_interested=successResponse.data

                })
            // .catch(failResponse => {
            // })
            this.$axios
                .post('/get_favorites', {
                    user_id:this.id
                })
                .then(successResponse => {
                    this.favorites=successResponse.data

                })
            // .catch(failResponse => {
            // })

        },
        methods:{
            menu1(){
                this.menuIndex=1
                console.log(this.id)
            },
            menu2(){
                this.menuIndex=2
            },
            menu3(){
                this.menuIndex=3
            },
            baocun(){
                console.log(this.formLabelAlign.name)
                if(!this.formLabelAlign.name){
                    alert("请输入用户名");
                }
                else{

                    this.$axios
                        .post('/search_user', {
                            name: this.formLabelAlign.name,
                        })
                        .then(successResponse => {
                            if(typeof(successResponse.data.id) == "undefined" || this.username == this.formLabelAlign.name){
                                this.username = this.formLabelAlign.name;
                                this.description = this.formLabelAlign.description;
                                this.$axios
                                    .post('/user/update_user_info', {
                                        id:this.id,
                                        name: this.formLabelAlign.name,
                                        description:this.formLabelAlign.description,
                                        avatar:this.faceBase64
                                    })
                                    .then(successResponse1 => {
                                        console.log(successResponse1)
                                        this.$axios
                                            .post('/get_articles', {
                                                id:this.id
                                            })
                                            .then(successResponse2 => {
                                                this.articles=successResponse2.data

                                            })
                                        // .catch(failResponse => {
                                        // })

                                        this.$axios
                                            .post('/get_favorites', {
                                                user_id:this.id
                                            })
                                            .then(successResponse3 => {
                                                this.favorites=successResponse3.data

                                            })
                                        // .catch(failResponse => {
                                        // })
                                    })
                                // .catch(failResponse => {
                                // })
                            }
                            else{
                                console.log(successResponse.data.id)
                                alert("用户名已被使用");
                            }
                        })
                    // .catch(failResponse => {
                    // })




                }

            },
            write(){
                this.$router.push({path: '/editor',
                    query: {
                        author_id: this.id
                    }
                })
            },
            click_article(id1,id2){
                this.$router.push({path: '/article',
                    query: {
                        article_id: id1,
                        author_id:id2,
                        is_admin:0,
                    }
                })
            },
            search_user(){
                this.$axios
                    .post('/search_user', {
                        name: this.search_user_name,
                    })
                    .then(successResponse => {
                        if(typeof(successResponse.data.id) == "undefined"){
                            alert("未找到该用户");
                        }
                        else{
                            console.log(successResponse.data.id)
                            this.$router.push({path: '/friend_main',
                                query: {
                                    friend_id: successResponse.data.id,
                                    friend_name: this.search_user_name
                                }
                            })
                        }
                    })
                // .catch(failResponse => {
                // })
            },
            look_friend(id,name){
                console.log("DD")
                this.$router.push({path: '/friend_main',
                    query: {
                        friend_id: id,
                        friend_name:name
                    }
                })
            },
            shangc(e){
                console.log(e)
                let files = document.getElementById('id').files[0]
                let name = document.getElementById('id').files[0].name
                let arr = name.split('.')
                console.log(arr);
                let fileSize = 0;
                let fileMaxSize = 10240;//1M
                if(files){
                    fileSize =files.size;
                    if (fileSize > 1*1024*fileMaxSize) {
                        alert("文件大小不能大于1M！");
                        files.value = "";
                        return false;
                    }else if (fileSize <= 0) {
                        alert("文件大小不能为0M！");
                        files.value = "";
                        return false;
                    }
                }else{
                    return false;
                }

                //转码base64
                let reader = new FileReader();
                let imgFile
                // let that = this
                reader.readAsDataURL(files)
                reader.onload = e => {
                    imgFile = e.target.result;
                    // let arr = imgFile.split(',')
                    // this.faceBase64 = arr[1]
                    //
                    // console.log(imgFile)
                    this.faceBase64 = imgFile
                    this.imageKey++
                    console.log(this.faceBase64)
                    // this.blob = reader.readAsText(this.dataURLtoBlob(imgFile))
                    // //console.log(reader.readAsText(this.dataURLtoBlob(imgFile)))


                }

            },
             // dataURLtoBlob(dataurl) {
             //    let arr = dataurl.split(','),
             //    mime = arr[0].match(/:(.*?);/)[1],
             //    bstr = atob(arr[1]),
             //    n = bstr.length,
             //    u8arr = new Uint8Array(n);
             //    while (n--) {
             //        u8arr[n] = bstr.charCodeAt(n);
             //    }
             //    return new Blob([u8arr], { type: mime });
             // }
        }

    }
</script>

<style scoped>
    .image1{
        width:100px;
        height:100px;
        border-radius:100px;
    }
    .info{
        width: 650px;
        display: flex;
        justify-content: space-around;
    }
    .textInfo{
        width: 400px;
        margin-top: 30px;
        display: flex;
        flex-direction: column;
        align-items: flex-start;

    }
    .info-text{
        font-size: 22px;
        font-family: "Microsoft YaHei";
    }
    .main{
        margin-top: 100px;
        margin-left: 30px;
        display: flex;
        justify-content: space-between;
    }
    .area{
        width: 1200px;
    }
    .box-card{
        width: 750px;
    }
    .article-title{
        float: left;
    }
    .article-info{
        margin-right: 500px;
    }
    .text {
        font-size: 14px;
    }

    .item {
        padding: 18px 0;
        margin-left: 0px;

    }
    .clearfix:before,
    .clearfix:after {
        display: table;
        content: "";
    }
    .clearfix:after {
        clear: both
    }


</style>