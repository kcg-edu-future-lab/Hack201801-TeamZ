<template lang="pug">
  b-container.Nekonote
    h1 body
    b-input-group
      p {{result}}
      input(v-model="query")
      b-button(@click="getData") test
      b-button(@click="sendPinch" variant="warning") Pinch Test
      b-button(@click="sendBored" variant="primary") Bored Test
</template>

<script>
import {NEKONOTE} from '../vuex/types'
// コミュニケーション
// 備品と連動
const {ACTION} = NEKONOTE

export default {
  name: 'Nekonote',
  data() {
    return {
      query: '',
      result: ''
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
    sendPinch: function () {
      this.$socket.emit('sPinch', '田辺')
    },
    sendBored: function () {
      this.$socket.emit('sBored', '田辺')
    }
  },
  sockets: {
    connect: function () {
      console.log('connected')
    },
    rPinch: function (user) {
      this.$notify({
        title: 'やばい',
        message: `${user} がやばい！！！！！`,
        type: 'warning'
      })
    },
    rBored: function (user) {
      this.$notify({
        title: '暇',
        message: `${user} 暇です`,
        type: 'info'
      })
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style lang="sass" scoped>
</style>
