<template>
    <div>
        <router-view></router-view>
        <el-form :label-position="labelPosition" label-width="80px" :model="formLabelAlign" style="width: 50%">
            <el-form-item label="标题">
                <el-input v-model="formLabelAlign.title"></el-input>
            </el-form-item>
            <el-form-item label="简介">
                <el-input v-model="formLabelAlign.description"></el-input>
            </el-form-item>
        </el-form>
        <mavon-editor
                v-model="content"
                ref="md"
                @change="change"
                style="min-height: 600px"
        />

        <el-button type="info" plain @click="submit" style="margin-top: 20px;width: 20%">提交</el-button>
    </div>
</template>



<script>
    import { mavonEditor } from 'mavon-editor'
    import 'mavon-editor/dist/css/index.css'

    export default {
        // 注册
        components: {
            mavonEditor,
        },
        data() {
            return {
                content:'', // 输入的markdown
                html:'',    // 及时转的html
                article_id:this.$route.query.article_id,//作者id
                labelPosition: 'right',
                formLabelAlign: {
                    title: '',
                    description: '',
                }

            }
        },
        methods: {
            // 所有操作都会被解析重新渲染
            change(value, render){
                // render 为 markdown 解析后的结果[html]
                this.html = render;
            },
            // 提交
            submit(){
                this.$axios
                    .post('/update_article', {
                        id: this.$route.query.article_id,
                        content_md:this.content,
                        content_html:this.html,
                        title: this.formLabelAlign.title,
                        description: this.formLabelAlign.description,
                    })
                    .then(successResponse => {
                        console.log(successResponse);
                        this.$router.go(-1);
                    })
                // .catch(failResponse => {
                // })
            }
        },
        mounted() {
            this.$axios
                .post('/get_article', {
                    id:this.$route.query.article_id,

                })
                .then(successResponse => {
                    console.log(successResponse);
                    this.content = successResponse.data.content_md;
                    this.formLabelAlign.title = successResponse.data.title;
                    this.formLabelAlign.description = successResponse.data.description
                })
            // .catch(failResponse => {
            // })
        }
    }
</script>