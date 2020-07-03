<template>
    <div>
        <router-view></router-view>
        <div>
            <el-button   style="width: 10%;margin-left: 1200px" @click="add_favorite" v-show="!isFavorite && !(is_admin ==1)" :key="favorite1">收藏</el-button>
            <el-button   style="width: 10%;margin-left: 1200px" @click="cancel_favorite" v-show="isFavorite &&!(is_admin ==1)" :key="favorite2">取消收藏</el-button>
            <el-button   style="width: 10%;margin-left: 1200px" @click="ban" v-show="is_admin == 1 &&!is_banned" :key="'ban1' + ban_key ">封禁</el-button>
            <el-button   style="width: 10%;margin-left: 1200px"  @click="cancel_ban" v-show="is_admin == 1 &&is_banned" :key="'ban2' + ban_key ">取消封禁</el-button>
        </div>

        <div style="margin-left: 40px;margin-bottom: 50px;font-weight: bold">
            <div style="text-align: left; font-size: 30px; margin-bottom: 20px">{{title}}</div>
            <div style="text-align: left; font-size: 20px">{{description}}</div>
        </div>

        <div style="margin-left: 50px">
            <span v-html="content_html" style="text-align: left; "></span>
        </div>
        <div>
            <el-button @click="update"  style="width: 10%" v-if="author_id == this.$root.user_id">修改</el-button>
            <el-popover
                    ref="popover5"
                    placement="top"
                    width="160"
                    v-model="visible2">
                <p>确定要删除这篇文章吗？</p>
                <div style="text-align: right; margin: 0">
                    <el-button size="mini" type="text" @click="visible2 = false">取消</el-button>
                    <el-button type="primary" size="mini" @click="delete_article">确定</el-button>
                </div>
            </el-popover>
            <el-button  type="warning" plain  style="width: 10%" v-popover:popover5 v-if="author_id == this.$root.user_id">删除</el-button>
        </div>

        <div>
            <el-input
                    style="width: 40%;margin-top: 50px"
                    type="textarea"
                    :autosize="{ minRows: 2, maxRows: 4}"
                    placeholder="请输入内容"
                    v-model="comment">
            </el-input>
        </div>

        <el-button style="width: 10%;margin-left: 460px;margin-top: 30px" @click="add_comment">发表</el-button>

        <div style="margin-left: 460px;margin-top: 30px">
            <div v-for="item in comment_list" v-bind:key="item.id">
                <el-card class="box-card" style="text-align: left">
                    <div class="text item">
                        {{item.author_name}}
                    </div>
                    <div class="text item">
                        {{item.content}}
                    </div>
                </el-card>
            </div>

        </div>
    </div>
</template>

<script>

    export default {
        name: "Article",
        data(){
            return{
                title:"",
                description:"",
                content_html:"",
                article_id: this.$route.query.article_id,
                author_id: this.$route.query.author_id,
                comment: '',
                visible2: false,
                isFavorite:true,
                favorite1:1,
                favorite2:0,
                comment_list:'',
                comment_key:0,
                is_admin:this.$route.query.is_admin,
                is_banned:0,
                ban_key:0,

            }

        },
        mounted(){
            this.$axios
                .post('/get_article', {
                    id: this.$route.query.article_id,

                })
                .then(successResponse => {
                    console.log(successResponse.data)
                    this.content_html = successResponse.data.content_html
                    this.title = successResponse.data.title
                    this.description = successResponse.data.description
                    this.author_id = successResponse.data.author
                    this.is_banned = successResponse.data.is_banned
                    console.log(this.is_banned)
                    this.ban_key++

                })
             .catch(failResponse => {
                 console.log(failResponse)
             }),

            this.$axios
                .post('/search_favorite', {
                    user_id:this.$root.user_id,
                    article_id:this.article_id
                })
                .then(successResponse => {
                    console.log(successResponse.data.id)
                    if(typeof(successResponse.data.id) == "undefined"){
                        this.isFavorite = false
                    }
                    else {
                        this.isFavorite = true
                    }

                })
            // .catch(failResponse => {
            // })

            this.$axios
                .post('/get_comments', {
                    article_id:this.article_id
                })
                .then(successResponse => {
                    this.comment_list = successResponse.data
                    console.log(successResponse.data)

                })
            // .catch(failResponse => {
            // })
        },
        methods:{
            update(){
                this.$router.push({path: '/update_article',
                    query: {
                        article_id: this.article_id
                    }
                })
            },
            delete_article(){
                this.$axios
                    .post('/delete_article', {
                        id: this.$route.query.article_id,
                    })
                    .then(successResponse => {
                        console.log((successResponse))
                        this.$router.go(-1);
                    })
                    .catch(failResponse => {
                        console.log(failResponse)
                    })
            },
            add_favorite(){
                this.$axios
                    .post('/add_favorite', {
                        user_id: this.$root.user_id,
                        article_id:this.article_id,
                    })
                    .then(successResponse => {
                        console.log((successResponse))
                        this.isFavorite = true
                        this.favorite1++
                    })
                    .catch(failResponse => {
                        console.log(failResponse)
                    })
            },
            cancel_favorite(){
                this.$axios
                    .post('/delete_favorite', {
                        user_id: this.$root.user_id,
                        article_id:this.article_id,
                    })
                    .then(successResponse => {
                        console.log((successResponse))
                        this.isFavorite = false
                        this.favorite2--
                    })
                    .catch(failResponse => {
                        console.log(failResponse)
                    })
            },
            add_comment(){

                this.$axios
                    .post('/add_comment', {
                        author_id: this.$root.user_id,
                        article_id:this.article_id,
                        content: this.comment,
                    })
                    .then(successResponse => {
                        console.log((successResponse))
                        this.$axios
                            .post('/get_comments', {
                                id:this.article_id
                            })
                            .then(successResponse1 => {
                                console.log(successResponse1.data)

                                console.log(successResponse1.data[successResponse1.data.length - 1])
                                this.comment_list.splice(this.comment_list.length,0,successResponse1.data[successResponse1.data.length - 1])
                                console.log(this.comment_list)
                            })
                        // .catch(failResponse => {
                        // })
                    })
                    .catch(failResponse => {
                        console.log(failResponse)
                    })


            },
            ban(){
                this.$axios
                    .post('/set_ban', {
                        is_banned:1,
                        id:this.article_id,
                    })
                    .then(successResponse => {
                        console.log((successResponse))
                        this.is_banned = true
                        this.ban_key++
                    })
                    .catch(failResponse => {
                        console.log(failResponse)
                    })
            },
            cancel_ban(){
                this.$axios
                    .post('/set_ban', {
                        id:this.article_id,
                        is_banned:0
                    })
                    .then(successResponse => {
                        console.log((successResponse))
                        this.is_banned = false
                        this.ban_key++
                    })
                    .catch(failResponse => {
                        console.log(failResponse)
                    })
            }
        }

    }
</script>

<style>
    .text {
        font-size: 14px;
    }

    .item {
        padding: 18px 0;
    }

    .box-card {
        width: 600px;
    }
</style>