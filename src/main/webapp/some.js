
var myVar = setInterval(myTimer, 1000);var today = new Date()
var curHr = today.getHours()

if (curHr < 12) {
    console.log('good morning')
} else if (curHr < 18) {
    console.log('good afternoon')
} else {
    console.log('good evening')
}

function myTimer() {
    var d;
    d = new Date();
    document.getElementById("timer").innerHTML = d.toLocaleTimeString();
    return myVar;
}
function loginPromt() {
var p = prompt("would like to log in");
alert(p);
window.location = "/login";
}



