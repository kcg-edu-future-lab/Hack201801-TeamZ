<template lang="pug">
  el-card(draggable="true").task
    p task
    p 22:00 ~ 24:00
</template>

<script>
export default {
  name: 'task',
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
</style>
