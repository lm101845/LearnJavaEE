/**
 * @Author liming
 * @Date 2023/9/28 17:21
 **/
import {createRouter, createWebHistory} from "vue-router";
import index from './components/index.vue'
import login from './components/login.vue'

const router = createRouter({
    history: createWebHistory(),
    routes: [
        {path: '/', name: 'index', component: index},
        {path: '/login', name: 'goods', component: login},
    ]
})

export default router
