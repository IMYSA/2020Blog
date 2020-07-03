
// 配置路由相关的信息

import Login from "@/view/Login";
import HelloWorld from "@/components/HelloWorld";
import main from "@/view/main";
import Register from "@/view/Register";
import Editor from "@/view/Editor";
import Article from "@/view/Article";
import UpdateArticle from "@/view/UpdateArticle";
import FriendMain from "@/view/FriendMain";
import AdminMain from "@/view/AdminMain";

// 2.创建VueRouter对象
export const routes = [


    {
        path: '/hello',
        component: HelloWorld
    },
    {
        path: '/login',
        component: Login
    },
    {
        path: '/main',
        component: main
    },
    {
        path: '/register',
        component: Register
    },
    {
        path: '/editor',
        component:Editor
    },
    {
        path: '/article',
        component: Article
    },
    {
        path: '/update_article',
        component: UpdateArticle
    },
    {
        path: '/friend_main',
        component: FriendMain
    },
    {
        path: '/admin_main',
        component: AdminMain
    }
]

