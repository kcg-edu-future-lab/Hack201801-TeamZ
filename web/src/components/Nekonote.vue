<template lang="pug">
  el-container
    el-header
      h3 {{title}}
    el-main
      ul
        li
          task
    el-footer
      el-button(@click="addTask" icon="el-icon-circle-plus" style="border: none")
</template>

<script>
import {NEKONOTE} from '../vuex/types'
import ElFooter from 'element-ui/packages/footer/src/main'
import Task from './Task'

const {ACTION} = NEKONOTE

export default {
  components: {ElFooter, Task},
  props: ['val'],
  name: 'Nekonote',
  data() {
    return {
      title: this.val
    }
  },
  methods: {
    getData: function () {
      this.$store.dispatch(ACTION.GET_DATA, this.query)
        .then(e => {
          console.log(e.data)
          this.result = `response: ${e.data}`
        })
    },
    addTask: function () {
      this.$modal.show('task', {title: this.title})
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style lang="sass" scoped>
ul
  padding: 0
li
  list-style: none
</style>
