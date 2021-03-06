// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import Vuex from 'vuex'
import App from './App'
import Element from 'element-ui'
import locale from 'element-ui/lib/locale/lang/ja'
import 'element-ui/lib/theme-chalk/index.css'
import router from './router'
import bootstrapVue from 'bootstrap-vue'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'
import socket from 'vue-socket.io'
import ToggleButton from 'vue-js-toggle-button'
import VModal from 'vue-js-modal'

Vue.config.productionTip = false

Vue.use(Element, {locale})
Vue.use(bootstrapVue)
Vue.use(Vuex)
Vue.use(socket, 'http://localhost:9000')
Vue.use(ToggleButton)
Vue.use(VModal)

const store = require('./vuex/store').default

/* eslint-disable no-new */
new Vue({
  el: '#app',
  store: store,
  router,
  components: {App},
  template: '<App/>'
})
