import {NEKONOTE} from '../types'
import axios from 'axios'

const {ACTION, MUTATION} = NEKONOTE

export const nekonote = {
  state: {
    status: false,
    user: '',
    users: []
  },
  getters: {
    status: (state) => state.status,
    user: (state) => state.user,
    users: (state) => state.users
  },
  mutations: {
    [MUTATION.TOGGLE_STATUS]: (state) => {
      state.status = !state.status
    }
  },
  actions: {
    [ACTION.GET_DATA]: ({commit, state, dispatch}, payload) => {
      return new Promise((resolve, reject) => {
        axios({
          method: 'get',
          url: 'http://localhost:3000',
          params: {data: payload},
          responseType: 'json'
        }).then(e => resolve(e))
      })
    }
  }
}
