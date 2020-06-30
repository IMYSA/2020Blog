<template>
    <div id="Register">
        <router-view></router-view>
        <el-form class="login-container" label-position="left"
                 label-width="0px">
            <h3 class="login_title">注册</h3>
            <el-form-item>
                <el-input type="text" v-model="username"
                          auto-complete="off" placeholder="账号"></el-input>
            </el-form-item>
            <el-form-item>
                <el-input type="password" v-model="password"
                          auto-complete="off" placeholder="密码"></el-input>
            </el-form-item>
            <el-form-item>
                <el-input type="password" v-model="r_password"
                          auto-complete="off" placeholder="确认密码"></el-input>
            </el-form-item>
            <el-form-item style="width: 100%">
                <el-button type="primary" style="width: 100%;background: #505458;border: none" v-on:click="register">注册</el-button>
            </el-form-item>
        </el-form>

    </div>
</template>

<script>
    export default {
        name: 'Login',
        data () {
            return{
                username: "xxx",
                password: "123456",
                r_password: "123456"
            }
        },
        methods: {
            register(){
                if(this.password == this.r_password){
                    this.$axios
                        .post('/user/update_user_info', {
                            username: this.username,
                            password: this.password,
                        })
                        .then(successResponse => {
                            if (successResponse.data.code === 200) {
                                // if(){ 用户名不重复
                                //
                                //     this.$router.push('/main')
                                // }
                                // else 用户名重复
                            }
                        })
                    // .catch(failResponse => {
                    // })

                }
                else{
                    alert("密码不一致")
                }


            }
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