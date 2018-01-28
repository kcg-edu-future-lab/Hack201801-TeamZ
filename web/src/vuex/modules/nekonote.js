import {NEKONOTE} from '../types'
import axios from 'axios'

const {ACTION, MUTATION} = NEKONOTE

export const nekonote = {
  state: {
    status: false,
    tasks: [{task1: [{title: 'title', date: 'day'}]}, {task2: [{title: 'title', date: 'date'}]}, {task2: [{title: 'title', date: 'date'}]}],
    user: '',
    users: []
  },
  getters: {
    tasks: (state) => state.tasks,
    status: (state) => state.status,
    user: (state) => state.user,
    users: (state) => state.users
  },
  mutations: {
    [MUTATION.TOGGLE_STATUS]: (state) => {
      state.status = !state.status
    },
    [MUTATION.ADD_TASK]: (state, payload) => {
      state.tasks.push(payload)
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
