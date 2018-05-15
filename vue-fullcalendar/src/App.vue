<template>
  <div id="app">
    <button @click="refreshEvents">Refresh</button>
    <button v-if="selected._id" @click="removeEvent">Remove</button>
    <pre>{{ selected }}</pre>
    <input type="text" v-model="title" @change=""/>
    <datepicker v-model="date"></datepicker>
    <button v-on:click="postPost">add event</button>
    <p>{{title}} {{date}}</p>
    <full-calendar ref="calendar" :event-sources="eventSources" :events="events" @event-selected="eventSelected"
                   @event-created="eventCreated"
                   :config="config"></full-calendar>
  </div>
</template>

<script>
  import moment from 'moment';
  import * as $ from "babel-register";
  import datepicker from 'vue-date';
  import VueButton from 'vue-button';


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
        title: "",
        date: '2018-05-15',
        postBody: {},
        //ˇpotential problemˇ
        id: 0,
        start: "",

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

    components: {datepicker, VueButton},

    methods: {

      // // Pushes posts to the server when called.
      // postPost() {
      //   console.log('I was clicked');
      //   axios.post(url, {
      //     // postBody: this.postBody
      //     postBody: {
      //       "id": "4",
      //       "title": "The LocalHosters",
      //       "start": "Tue May 11 2018 13:00:00 GMT+0300 (FLE Daylight Time)",
      //       "end": "Tue May 11 2018 16:00:00 GMT+0300 (FLE Daylight Time)"
      //     }
      //
      //   })
      //     .then(response => {
      //     })
      //     .catch(error => {
      //       this.errors.push(error)
      //     })

        // async / await version (postPost() becomes async postPost())
        //
        // try {
        //   await axios.post(`http://jsonplaceholder.typicode.com/posts`, {
        //     body: this.postBody
        //   })
        // } catch (e) {
        //   this.errors.push(e)
        // }
      // },

      // postRequest() {
      //   console.log('I was clicked');
      //   //this.id++;
      //   postPost();

        // this.postBody.id = this.id;
        // this.postBody.title = this.title;
        // this.postBody.start = this.date + " " + " time here";
        // this.postBody.end = this.end;
        // var jsonString = JSON.stringify(postBody);
        // console.log(postBody);

        // and concantenate this to the string
        //"room": {
          //       "id": "2",
          //       "roomName": "Tore ruum"
          //     }

      // }

          refreshEvents()
        {
          this.$refs.calendar.$emit('refetch-events');
        }
      ,

        removeEvent()
        {
          this.$refs.calendar.$emit('remove-event', this.selected);
          this.selected = {};
        }
      ,

        eventSelected(event)
        {
          this.selected = event;
        }
      ,

        eventCreated(...test)
        {
          console.log(test);
        }
      ,
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
