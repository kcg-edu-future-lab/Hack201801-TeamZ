<template lang="pug">
  div#app
    b-button(variant="warning" v-on:click="yabai") やばい！
    b-button(variant="info") 今空いてます
    b-row(style="height: 100%")
      b-col(:sm="3").task
        nekonote(val="task1")
      b-col(:sm="3").task
        nekonote(val="task2")
      b-col(:sm="3").task
        nekonote(val="task3")
      b-col(:sm="3").task
        nekonote(val="task4")
    div(style="border: 1px solid light-gray; position: flex")
      task
    modal(name="task")
      b-form(@submit="onSubmit" style="margin: 20px")
        el-select(v-model="value" placeholder="Select")
          el-option(v-for="item in options" v-bind:key="item.value" v-bind:label="item.label" v-bind:value="item.value")
        b-form-group
          b-form-input(v-model="form.input")
        toggle-button(toggle-button :value="form.neko" v-bind:labels="{checked: 'ねこの手', unchecked: 'no'}" style="width: 80px")
        el-button(@click="onSubmit" icon="el-ico -circle-plus" style="border: none") 追加
</template>

<script>
import nekonote from './components/Nekonote'
import {NEKONOTE} from './vuex/types'
import task from './components/Task'
import {mapGetters} from 'vuex'
import axios from 'axios'

export default {
  name: 'App',
  data() {
    return {
      options: [
        {
          value: 'task1',
          label: 'task1'
        },
        {
          value: 'task2',
          label: 'task2'
        },
        {
          value: 'task3',
          label: 'task3'
        }
      ],
      value: 'task1',
      form: {
        input1: '',
        neko: false
      }
    }
  },
  computed: {
    ...mapGetters([
      'tasks'
    ])
  },
  methods: {
    onSubmit: function (ev) {
      ev.preventDefault()
      axios.post('http://', {
        title: this.value,
        date: this.form.input1
      })
    },
    addTask: function () {
      this.$store.commit(NEKONOTE.MUTATION.ADD_TASK, {})
    },
    yabai: function () {
      this.$notify({
        title: `やばい！`,
        text: `田辺 さんがやばい！！！！`,
        type: 'warning',
        duration: 4000,
        speed: 1500
      })
    }
  },
  components: {nekonote, task}
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
    height: 600px

    .task
      border-right: 1px solid #ccc
      height: 100%
</style>
