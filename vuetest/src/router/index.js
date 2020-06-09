import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Book from "../views/Book";
import PageOne from "../views/PageOne";
import PageTwo from "../views/PageTwo";
import PageThree from "../views/PageThree";
import PageFour from "../views/PageFour";
import App from "../App";
import Index from "../views/Index.vue";
import fa from "element-ui/src/locale/lang/fa";

Vue.use(VueRouter)

  const routes = [
    {
      path: '/',
      name: '图书管理',
      component: Index,
      show: true,
      redirect: "/BookManage",
      children: [
        {
          path: '/BookManage',
          name: '查询',
          component: PageOne
        },
        {
          path: '/pageTwo',
          name: '添加',
          component: PageTwo
        },
      ]
    },
    // {
    //   path: "/update",
    //   name: "修改",
    //   component: PageThree
    // },

    {
      path: '/navigation',
      name: '导航2',
      component: Index,
      show: false,
      children: [
        {
          path: '/update',
          name: '页面3',
          component: PageThree
        },
        {
          path: '/pageFour',
          name: '页面4',
          component: PageFour
        },
      ]
    },

    {
      path: '/book',
      name: "书",
      component: Book,
      show: false
    },


]

const router = new VueRouter({
  routes
})

export default router
