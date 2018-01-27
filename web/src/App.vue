<template lang="pug">
  div#id
    el-container
      el-aside
        side
      el-container
        el-header
          header-bar
        el-main
          router-view
</template>

<script>
import HeaderBar from './components/globals/HeaderBar'
import Side from './components/globals/Side'

export default {
  name: 'App',
  components: {HeaderBar, Side}
}
</script>

<style lang="sass">
#app
  font-family: 'Avenir', Helvetica, Arial, sans-serif
  -webkit-font-smoothing: antialiased
  -moz-osx-font-smoothing: grayscale
  /*text-align: center;*/
  color: #2c3e50
  margin-top: 100px

.el-side
  background-color: darkseagreen
  overflow: scroll
.el-header
  background-color: rgb(238, 241, 246)
.el-main
  background-color: antiquewhite
  overflow: scroll
</style>
