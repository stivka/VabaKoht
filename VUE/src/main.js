// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'


Vue.config.productionTip = false

var myTask = Vue.component('my-task',{
  template : '#task-template',
  data : function(){
    return this.tasks; //Notice: in components data should return an object. For example "return { someProp: 1 }"
  },
  props : ['task']
});

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'


});
