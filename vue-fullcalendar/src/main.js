// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue';
import FullCalendar from 'vue-full-calendar';

import App from './App';

import axios from 'axios';

Vue.config.productionTip = false;
Vue.use(FullCalendar);

/* eslint-disable no-new */
new Vue({
  el: '#app',
  template: '<App/>',
  components: { App },
});