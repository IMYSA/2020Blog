<template>
    <div>
        <router-view></router-view>
        <el-container>
            <el-header>
                <div class="info">
                    <img class="image1" :src="avatar"/>
                    <div class="textInfo">
                        <span class="info-text">用户名：{{username}}</span>
                        <span class="info-text" style="margin-top: 10px">个人介绍：{{description}}</span>
                    </div>
                </div>
                <el-button style="margin-left: 1000px;width: 200px" type="info" plain @click="follow_friend" v-show="!isFollowed" :key="load1">关注</el-button>
                <el-button style="margin-left: 1000px;width: 200px" type="info" plain @click="cancle_friend" v-show="isFollowed" :key="load2">取消关注</el-button>
                <hr  style="width: 95%;margin-top: 30px"/>
            </el-header>
            <el-main class="main">
                <el-menu
                        default-active="2"
                        class="el-menu-vertical-demo menu"
                >
                    <el-menu-item index="2" @click="menu2">
                        <i class="el-icon-menu"></i>
                        <span slot="title">他的文章</span>
                    </el-menu-item>

                </el-menu>
                <div class="area" style="display: flex">
                    <div v-if="menuIndex == 2">
                        <div v-for="item in articles" v-bind:key="item.id">
                            <div id="ArticleList">
                                <el-card class="box-card">
                                    <div slot="header" class="clearfix">
                                        <span class="article-title">{{item.title}}</span>
                                        <el-button style="float: right; padding: 3px 0" type="text" @click="click_article(item.id)" >查看</el-button>
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
                friend_id: this.$route.query.friend_id,
                friend_name: this.$route.query.friend_name,
                username:"xxx",
                description:"sssssssssss",
                menuIndex: 2,
                articles:'',
                avatar:'',
                labelPosition: 'right',
                isFollowed:true,
                load1:1,
                load2:0,
            }
        },
        mounted: function(){
            this.$axios
                .post('/user/get_user_info', {
                    id:this.friend_id
                })
                .then(successResponse => {
                    this.username = successResponse.data.name
                    this.description = successResponse.data.description
                    this.avatar = successResponse.data.avatar

                })
            // .catch(failResponse => {
            // })
            this.$axios
                .post('/get_articles', {
                    id:this.friend_id
                })
                .then(successResponse => {
                    this.articles=successResponse.data
                    console.log(successResponse)

                })
            // .catch(failResponse => {
            // })
            this.$axios
                .post('/search_follow', {
                    user_id:this.$root.user_id,
                    friend_id:this.friend_id
                })
                .then(successResponse => {
                    console.log(successResponse.data.id)
                    if(typeof(successResponse.data.id) == "undefined"){
                        this.isFollowed = false
                    }
                    else {
                        this.isFollowed = true
                    }

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

            click_article(id){
                this.$router.push({path: '/article',
                    query: {
                        article_id: id,
                        author_id: this.friend_id,
                        is_admin:0
                    }
                })
            },
            follow_friend(){
                this.$axios
                    .post('/add_follow', {
                        user_id:this.$root.user_id,
                        friend_id: this.friend_id,
                        friend_name: this.friend_name,
                    })
                    .then(successResponse => {
                        console.log(successResponse)
                        this.isFollowed = true
                        this.load1++
                        this.load2--

                    })
                // .catch(failResponse => {
                // })
            },
            cancle_friend(){
                this.$axios
                    .post('/delete_follow', {
                        user_id:this.$root.user_id,
                        friend_id: this.friend_id,

                    })
                    .then(successResponse => {
                        console.log(successResponse)
                        this.isFollowed = false
                        this.load1++
                        this.load2--
                    })
                // .catch(failResponse => {
                // })
            }
        },


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