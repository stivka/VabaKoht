var body = document.getElementsByTagName('body')[0],
    div = document.createElement('div'),
	curMonth = 3;
	lastDay = new Date(2018, curMonth + 1, 0).getDate(),
	firstDay = new Date(2018, curMonth, 0),
	counterNow = - firstDay.getDay();
	counterPrev = new Date(2018, curMonth, 0).getDate() - firstDay.getDay();
	counterNext = new Date(2018, curMonth + 1, 1).getDate();
	console.log(counterNext);
	console.log(firstDay.getDay() + 1);

function drawTable() {
    var tableString = "<table><tr><th>Monday</th><th>Tuesday</th>\n" +
        "    <th>Wednesday</th><th>Thursday</th><th>Friday</th><th>Saturday</th><th>Sunday</th></tr>";
for (row = 1; row < 7; row += 1) {
    tableString += "<tr>";
    for (col = 0; col < 7; col += 1) {
    	counterNow += 1;
    	counterPrev += 1;
		if (counterNow <= lastDay && counterNow > 0) {
            tableString += "<td id='cell" + counterNow +"' onclick='createTextSpace(\"cell" + counterNow +"\")'>" +
				counterNow + "</td>";
		} if (counterNow <= 0) {
            tableString += "<td id='cell" + counterPrev +"' onclick='createTextSpace(\"cell" + counterPrev +"\")'>" +
                counterPrev + "</td>";
		} if (counterNow > lastDay) {
            tableString += "<td id='cell" + counterNext +"' onclick='createTextSpace(\"cell" + counterNext +"\")'>" +
                counterNext + "</td>";
            counterNext += 1;
		}
    }
    tableString += "</tr>";
		}
    tableString += "</table>";
    div.innerHTML = tableString;
    body.appendChild(div);
}

function createTextSpace(cellID) {
    var meeting = prompt("Date and room");
    if(meeting) {
    document.getElementById(cellID).innerHTML+= "<br><div class='reserv'>" + meeting + "</div>";
		}
}
