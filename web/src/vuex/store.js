import Vuex from 'vuex'
import {nekonote} from './modules/nekonote'

const store = new Vuex.Store({
  modules: {nekonote}
})

export default store
