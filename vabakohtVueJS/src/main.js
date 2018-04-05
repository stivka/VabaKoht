import Vue from 'vue'
import App from './App.vue'
import calender from './calender.vue'

Vue.component('calender',calender)

new Vue({
  el: '#app',
  render: h => h(App)
})
