<template lang="pug">
  div.side
    h1 Side
    el-collapse(v-model="activeName" accordion v-on:change="activeNameChanged")
      el-collapse-item(title="タイトル" name="1")
        ul
          li(v-for="user in users")
            div
              img(:src="require('../../assets/icon.png')" style="width: 30px; margin-right: 5px")
              span {{Object.values(user).join('')}}
      el-collapse-item(title="タイトル2" name="2")
        ul
          li(v-for="user in users")
            div
              img(:src="require('../../assets/icon.png')" style="width: 30px; margin-right: 5px")
              span {{Object.values(user).join('')}}
</template>

<script>
import {NEKONOTE} from '../../vuex/types'

const {ACTION} = NEKONOTE
export default {
  name: 'side',
  data() {
    return {
      users: [],
      activeName: ''
    }
  },
  created: function () {
    this.$store.dispatch(ACTION.GET_DATA, this.query)
      .then(e => {
        this.users = e.data
      })
  },
  methods: {
    activeNameChanged: function () {
      console.log(this.activeName)
    }
  }
}
</script>

<style lang="sass" scoped>
  .side
    height: 100%
    background-color: darkseagreen
    overflow: scroll
  li
    list-style-type: none
</style>
