<template lang="pug">
  div.header-bar
    b-row
      b-col(sm="9")
        span header
      b-col(sm="3")
        toggle-button(:labels="{checked: 'やばい', unchecked: 'やばくない'}" v-bind:value="status" v-bind:sync="true"  v-bind:width=80 v-on:change="statusChanged")
</template>

<script>
import {mapGetters} from 'vuex'
import {NEKONOTE} from '../../vuex/types'

const {MUTATION} = NEKONOTE

export default {
  name: 'header-bar',
  data() {
    return {
    }
  },
  computed: {
    ...mapGetters(['status'])
  },
  methods: {
    statusChanged: function () {
      this.$store.commit(MUTATION.TOGGLE_STATUS)
      console.log(this.status)
    }
  }
}
</script>

<style lang="sass" scoped>
</style>
