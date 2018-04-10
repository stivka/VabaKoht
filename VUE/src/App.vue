<template>
  <div id="app">

    <calendar-view></calendar-view>
    <eventsView></eventsView>

    <router-view/>
  </div>
</template>

<script>
  import Calendar from './components/Calendar'
  import EventsView from './components/EventsView'

export default {
  name: 'App',
  components: {
    Calendar,
    EventsView
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
