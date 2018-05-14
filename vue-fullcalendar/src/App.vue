<template>
  <div id="app">
    <button @click="refreshEvents">Refresh</button>
    <button v-if="selected._id" @click="removeEvent">Remove</button>
    <pre>{{ selected }}</pre>
    <full-calendar ref="calendar" :event-sources="eventSources" :events="events" @event-selected="eventSelected"
                   @event-created="eventCreated"
                   :config="config"></full-calendar>
  </div>
</template>

<script>
  import moment from 'moment';
  import * as $ from "babel-register";


  const ul = document.getElementById('events');
  const url = 'http://localhost:8080/rooms/2/events/';


  // events = [
  //   {
  //     "id": "3",
  //     "title": "The LocalHosters",
  //     "start": "Tue May 10 2018 13:00:00 GMT+0300 (FLE Daylight Time)",
  //     "end": "Tue May 10 2018 16:00:00 GMT+0300 (FLE Daylight Time)",
  //     "room": {
  //       "id": "2",
  //       "roomName": "Tore ruum"
  //     }
  //   }
  // ];

  export default {
    name: 'app',
    data() {
      return {
        events: [],

        config: {
          eventClick: (event) => {
            this.selected = event;
          },
        },
        selected: {},
      };
    },

    mounted() {
      axios.get(url).then(response => {
        this.events = response.data
      })
    },

    methods: {

      refreshEvents() {
        this.$refs.calendar.$emit('refetch-events');
      },

      removeEvent() {
        this.$refs.calendar.$emit('remove-event', this.selected);
        this.selected = {};
      },

      eventSelected(event) {
        this.selected = event;
      },

      eventCreated(...test) {
        console.log(test);
      },
    },

    computed: {
      eventSources() {
        const self = this;

      },
    },
  };

</script>

<style>
  @import '~fullcalendar/dist/fullcalendar.css';

  #app {
    font-family: 'Avenir', Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #2c3e50;
    margin-top: 60px;
  }
</style>
