import Vue from 'vue'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import App from './App.vue'
import ArticleList from "@/components/ArticleList";
import {routes} from './router/router.js'
import VueRouter from "vue-router";
let axios = require('axios')
axios.defaults.baseURL = 'http://localhost:8080'
Vue.prototype.$axios = axios
Vue.use(ElementUI)
Vue.use(VueRouter)

const router = new VueRouter({
  routes:routes,
  mode: 'history',
});
Vue.component('my-article-list',ArticleList)
new Vue({
  el: '#app',
  router,
    data(){
        return{
            user_id:-1,
        }
    },
  render: h => h(App)
})

