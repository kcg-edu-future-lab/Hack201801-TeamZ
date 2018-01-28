<template lang="pug">
  el-card(draggable="true").task
    p {{title}}
    p {{date}}
</template>

<script>
export default {
  name: 'task',
  props: ['title', 'date'],
  data() {
    return {
      name: ''
    }
  }
}
</script>

<style lang="sass" scoped>
.task
  width: 200px
  p
    font-size: 0.8em
</style>
