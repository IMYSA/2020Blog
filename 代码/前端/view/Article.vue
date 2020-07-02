<template>
    <div>
        <router-view></router-view>
        <div style="margin-left: 50px">
            <span v-html="content_html" style="text-align: left; "></span>
        </div>

    </div>
</template>

<script>
    export default {
        name: "Article",
        data(){
            return{
                content_html:"",
                article_id: this.$route.query.article_id
            }

        },
        mounted(){
            this.$axios
                .post('/get_article', {
                    id: this.$route.query.article_id,
                })
                .then(successResponse => {
                    this.content_html = successResponse.data.content_html
                })
            // .catch(failResponse => {
            // })
        }
    }
</script>

<style>

</style>