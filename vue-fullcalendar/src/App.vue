<template>
  <div id="app">
    <button @click="refreshEvents">Refresh</button>
    <button v-if="selected._id" @click="removeEvent">Remove</button>
    <pre>{{ selected }}</pre>
    <full-calendar ref="calendar" :events="events" @event-selected="eventSelected" @event-created="eventCreated"
                   :config="config"></full-calendar>
  </div>
</template>

<script>
  import moment from 'moment';

  // const ul = document.getElementById('events');
  // const url = 'http://localhost:8080/rooms/1/events/';
  // let events = [];
  //
  // fetch(url)
  //   .then(
  //     function (response) {
  //       if (response.status !== 200) {
  //         console.log('Looks like there was a problem. Status Code: ' +
  //           response.status);
  //         return;
  //       }
  //
  //       // Examine the text in the response
  //       response.text().then(function (data) {
  //         console.log(data);
  //         events = data;
  //       });
  //     }
  //   )
  //   .catch(function (err) {
  //     console.log('Fetch Error :-S', err);
  //   });
  //
  // console.log(events);

  let events = [
    {
      "id": "3",
      "title": "The LocalHosters",
      "start": "Tue Apr 10 2018 13:00:00 GMT+0300 (FLE Daylight Time)",
      "end": "Tue Apr 10 2018 16:00:00 GMT+0300 (FLE Daylight Time)",
      "room": {
        "id": "1",
        "roomName": "Trummituba"
      }
    },
    {
      id: 2,
      title: 'Koristuspäev',
      start: moment().add(-1, 'days'),
      end: moment().add(1, 'days'),
      allDay: true,
    },
    {
      id: 4,
      title: 'Uued: Madis & Mürgel',
      start: '2018-04-11T13:00:00',
      end: '2018-04-11T16:00:00',
      allDay: false,
    },
    {"id":"4","title":"Failed Request","start":"Tue Apr 10 2018 16:00:00 GMT+0300 (FLE Daylight Time)","end":"Tue Apr 10 2018 19:00:00 GMT+0300 (FLE Daylight Time)","room":{"id":"1","roomName":"Trummituba"}}
  ];

  // console.log(typeof events);
  // Array.from(events);
  // console.log(typeof Array.from(events));

  export default {
    name: 'app',
    data() {
      return {
        events,

        config: {
          eventClick: (event) => {
            this.selected = event;
          },
        },
        selected: {},
      };
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
        return [
          {
            events(start, end, timezone, callback) {
              setTimeout(() => {
                callback(self.events.filter(() => Math.random() > 0.5));
              }, 1000);
            },
          },
        ];
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
