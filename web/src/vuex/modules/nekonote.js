import {NEKONOTE} from '../types'
import axios from 'axios'

const {ACTION} = NEKONOTE

export const nekonote = {
  state: {},
  getters: {},
  mutations: {},
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
