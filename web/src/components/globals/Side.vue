<template lang="pug">
  div.side
    h1 Side
    ul
      li(v-for="user in Array.from([...Array(20)].keys()).map(e => 'user')") {{user}}
</template>

<script>
export default {
  name: 'side',
  data () {
    return {
    }
  },
  methods: {
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
