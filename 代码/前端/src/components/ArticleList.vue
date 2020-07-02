<template>
    <div id="ArticleList">
        <el-card class="box-card">
            <div slot="header" class="clearfix">
                <span>卡片名称</span>
                <el-button style="float: right; padding: 3px 0" type="text">操作按钮</el-button>
            </div>
            <div class="text item">
                {{'列表内容 ' + o }}
            </div>
            <div class="text item">
                {{'列表内容 ' + o }}
            </div>
        </el-card>
    </div>
</template>

<script>
    export default {
        name: "ArticleList",
        data(){
            return {
                articleList:[
                    {id: 111, title: "xxx", author: "ysa", content: "sssss", time: "timeee",tag:"ss",description:"ddd"},
                    {id: 222, title: "bbb", author: "ysa", content: "sssss", time: "timeee",tag:"ss",description:"ddd"},
                    {id: 333, title: "ccc", author: "ysa", content: "sssss", time: "timeee",tag:"ss",description:"ddd"}
                ]


            }
        }
    }
</script>

<style scoped>
    .text {
        font-size: 14px;
    }

    .item {
        margin-bottom: 18px;
    }

    .clearfix:before,
    .clearfix:after {
        display: table;
        content: "";
    }
    .clearfix:after {
        clear: both
    }

    .box-card {
        width: 480px;
    }
</style>