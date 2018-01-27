import Vue from 'vue'
import Router from 'vue-router'
import Nekonote from '@/components/Nekonote'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Nekonote',
      component: Nekonote
    }
  ]
})
