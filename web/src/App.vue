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
        el-container
          el-header
           h3 task4
        el-main
          ul#list
            li(style="list-style: none")
              task(title="プロジェクトA" date="2018-1-28 15:40")
              task(title="会議" date="2018-1-28 15:40")
        el-footer
          el-button(@click="addTask" icon="el-icon-circle-plus" style="border: none")
    div
      task(title="カメラ" date="")
      task(title="会議室" date="")
    modal(name="task")
      b-form(@submit="onSubmit" style="margin: 20px")
        el-select(v-model="value" placeholder="Select")
           el-option(v-for="item in options" v-bind:key="item.value" v-bind:label="item.label" v-bind:value="item.value")
        b-form-group(description="日付")
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
      this.$modal.hide('task')
      axios.post('http://192.168.100.110/hackathon/insert.php', {
        tableName: 'schedule',
        sdate: this.form.input1,
        edate: this.form.input1,
        number: this.value,
        free: this.form.neko
      })
    },
    addTask: function () {
      this.$store.commit(NEKONOTE.MUTATION.ADD_TASK, {})
    },
    yabai: function () {
      this.$notify({
        title: `やばい！`,
        message: `田辺 さんがやばい！！！！`,
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
