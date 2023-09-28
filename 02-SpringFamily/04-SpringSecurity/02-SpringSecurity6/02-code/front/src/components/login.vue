<!--
 * @Author liming
 * @Date 2023/9/28 17:23
-->
<script setup lang="ts">
import axios from "axios";
import {ref} from 'vue'
import router from "../router";

const username = ref('')
const password = ref('')

//TODO:现在Vue3可以写箭头函数了吗？？
const login = async () => {
  let res = await axios.post('http://localhost:8080/login', {
    username: username.value,
    password: password.value
  }, {
    headers: {'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'}
  })
  console.log(res,'打印结果')
  if(res.data === 'loginOK'){
    router.push('/')
  }else{
    alert('账户或密码错误')
  }
}
</script>

<template>
  <h1 style="background-color: pink">欢迎登录</h1>
  用户名：<input type="text" v-model="username">
  密码：<input type="text" v-model="password">
  <button @click="login">登录</button>
</template>

<style scoped>

</style>
