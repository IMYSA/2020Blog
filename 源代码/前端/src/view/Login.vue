<template>
    <div id="Login">
        <router-view></router-view>
        <el-form class="login-container" label-position="left"
                 label-width="0px">
            <h3 class="login_title">系统登录</h3>
            <el-form-item>
                <el-input type="text" v-model="username"
                          auto-complete="off" placeholder="账号"></el-input>
            </el-form-item>
            <el-form-item>
                <el-input type="password" v-model="password"
                          auto-complete="off" placeholder="密码"></el-input>
            </el-form-item>
            <el-form-item style="width: 100%">
                <el-button type="primary" style="width: 100%;background: #505458;border: none" v-on:click="login">登录</el-button>
                <el-button type="primary" style="width: 100%;background: #505458;border: none; margin-left: 0px" v-on:click="register">注册</el-button>
            </el-form-item>
        </el-form>

    </div>
</template>

<script>
    export default {
        name: 'Login',
        data () {
            return{
                username: "test",
                password: "123456",

            }
        },
        methods: {
            login(){
                this.$axios
                    .post('/user/login', {
                        name: this.username,
                        password: this.password,
                        id:"",
                        identity:0,
                    })
                    .then(successResponse => {
                        console.log(successResponse.data)
                        if(successResponse.data < 0){
                            alert("用户名或密码错误");
                        }
                        else {
                            alert("登录成功");
                            console.log(successResponse.data);
                            this.id = successResponse.data
                            this.$root.user_id = this.id
                            console.log(this.$root.user_id)

                            this.$axios
                                .post('/user/get_user_info', {
                                    id:this.id
                                })
                                .then(successResponse => {
                                    console.log(successResponse.data)
                                    this.identity = successResponse.data.is_admin;
                                    if(this.identity == 0){
                                        this.$router.push({path: '/main',
                                            query: {
                                                id: this.id
                                            }
                                        })
                                    }else{
                                        this.$router.push({path: '/admin_main',
                                            query: {
                                                id: this.id
                                            }
                                        })
                                    }
                                })
                            // .catch(failResponse => {
                            // })



                        }

                    })
                // .catch(failResponse => {
                // })
                //
            },
            register(){
                this.$router.push('/register'
                )
            },
            test(){
                this.$router.push('/editor')
            },


        }
    }
</script>
<style>
    body{
        margin: 0px;
    }
    .login-container {
        border-radius: 15px;
        background-clip: padding-box;
        margin: 90px auto;
        width: 350px;
        padding: 35px 35px 15px 35px;
        background: #fff;
        border: 1px solid #eaeaea;
        box-shadow: 0 0 25px #cac6c6;
    }
    .login_title {
        margin: 0px auto 40px auto;
        text-align: center;
        color: #505458;
    }
</style>
