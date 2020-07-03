<template>
  <div id="app">
    <router-view></router-view>
  </div>
</template>

<script>
// import HelloWorld from './components/HelloWorld.vue'

export default {
  name: 'app',
  components: {
    // HelloWorld
  },
  data () {
    return {
      radio: '1',
      show:1,

    };
  },
  mounted(){
    this.$router.push({path:'/login'})
  },
  methods: {

    test () {
      this.$axios
              .post('/user/update_user_info', {
                id: 1,
                avatar:'777777',
                description: '7777777788',
              })
              .then(successResponse => {
                if (successResponse.data.code === 200) {
                  //console.log("success")
                }
              })
      // .catch(failResponse => {
      // })
    },
    login() {

      this.$router.push({path:'/login'})
    },
    hello(){
      this.$router.push('/hello')
    }
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
