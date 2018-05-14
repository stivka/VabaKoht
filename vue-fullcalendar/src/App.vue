<template>
  <div id="app">
    <button @click="refreshEvents">Refresh</button>
    <button v-if="selected._id" @click="removeEvent">Remove</button>
    <pre>{{ selected }}</pre>
    <input type="text" v-model="postBody" @change="postPost()"/>
    <datepicker v-model="date"></datepicker>
    <full-calendar ref="calendar" :event-sources="eventSources" :events="events" @event-selected="eventSelected"
                   @event-created="eventCreated"
                   :config="config"></full-calendar>
  </div>
</template>

<script>
  import moment from 'moment';
  import * as $ from "babel-register";
  import datepicker from 'vue-date';



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
        date: '2018-05-15',

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

    // Pushes posts to the server when called.
    postPost() {
      axios.post(url, {
        body: this.postBody
      })
        .then(response => {
        })
        .catch(e => {
          this.errors.push(e)
        })

      // async / await version (postPost() becomes async postPost())
      //
      // try {
      //   await axios.post(`http://jsonplaceholder.typicode.com/posts`, {
      //     body: this.postBody
      //   })
      // } catch (e) {
      //   this.errors.push(e)
      // }
    },

    components: {datepicker},

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
