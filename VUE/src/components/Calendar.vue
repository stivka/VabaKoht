<template>
  <div id="calendar">
    <h1>My Calendar</h1>
    <calendar-view :eventsA="demoEvents"
      :show-date="showDate"
      @show-date-change="setShowDate"
      class="holiday-us-traditional holiday-us-official"
    />
  </div>
</template>
<script>
  import CalendarView from "vue-simple-calendar"
  require("vue-simple-calendar/dist/static/css/default.css")
  require("vue-simple-calendar/dist/static/css/holidays-us.css")

  const ul = document.getElementById('events');
  const url = 'http://localhost:8080/rooms/1/events/';
  var eventsA;

  fetch(url)
    .then(
      function (response) {
        if (response.status !== 200) {
          console.log('Looks like there was a problem. Status Code: ' +
            response.status);
          return;
        }

        // Examine the text in the response
        response.json().then(function(data) {
          console.log(data);
          eventsA = data;
          console.log(eventsA);
        });
      }
    )
    .catch(function(err) {
      console.log('Fetch Error :-S', err);
    });

  export default {
    name: 'app',
    data: function() {
      return {
        showDate: new Date(),
        demoEvents: [{
          date: '2018/04/10', // Required
          title: 'Foo' // Required
        }, {
          date: '2016/12/15',
          title: 'Bar',
          desc: 'description',
          customClass: 'disabled highlight' // Custom classes to an calendar cell
        }]
      }
    },
    components: {
      CalendarView
    },
    methods: {
      setShowDate(d) {
        this.showDate = d;
      },

    }
  }
</script>
<style>
  #app {
    font-family: 'Avenir', Helvetica, Arial, sans-serif;
    color: #2c3e50;
    height: 67vh;
    width: 90vw;
    margin-left: auto;
    margin-right: auto;
  }
</style>
