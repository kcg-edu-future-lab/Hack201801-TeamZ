<template lang="pug">
  b-container.Nekonote
    h1 body
    img(:src="require('../assets/icon.png')")
    img(:src="require('../assets/icon.png')")
    img(:src="require('../assets/icon.png')")
    img(:src="require('../assets/icon.png')")
    img(:src="require('../assets/icon.png')")
    img(:src="require('../assets/icon.png')")
    p {{result}}
    input(v-model="query")
    b-button(@click="getData") test
</template>

<script>
import {NEKONOTE} from '../vuex/types'

const {ACTION} = NEKONOTE

export default {
  name: 'Nekonote',
  data () {
    return {
      query: '',
      result: ''
    }
  },
  methods: {
    getData: function () {
      this.$store.dispatch(ACTION.GET_DATA, this.query)
        .then(e => {
          this.result = `response: ${e.data}`
        })
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style lang="sass" scoped>
</style>
