<template>
	<div id="app">
		
		<calendar-view
			:show-date="showDate"
			@show-date-change="setShowDate"
            disablePast ="false"
            enableDragDrop = "true"
            showEventTimes = "true"
            displayPeriodUom ="month"
		
			
		>

	<!--<span slot="dayHeader">
<div class="day dow0">E</div><div class="day dow1">E</div><div class="day dow2">T</div><div class="day dow3">K</div><div class="day dow4">N</div><div class="day dow5">R</div><div class="day dow6">L</div></span>

	-->
		</calendar-view>

	</div>
</template>
<script>
	import CalendarView from "vue-simple-calendar"
	require("vue-simple-calendar/dist/static/css/default.css")

	export default {
		name: 'app',
		data: function() {
			return { showDate: new Date() }
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