<template>
  <div id="eventsView">
    <h1>Events</h1>
    <ul id="events"></ul>

  </div>
</template>

<script>
  const ul = document.getElementById('events');
  const url = 'http://localhost:8080/rooms/1/events/';

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


</script>

<style scoped>

</style>
