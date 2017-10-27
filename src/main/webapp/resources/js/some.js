
var myVar = setInterval(myTimer, 1000);var today = new Date()
var curHr = today.getHours()

if (curHr < 12) {
    alert('good morning')
} else if (curHr < 17) {
    alert('good afternoon')
} else {
    alert('good evening')
}

function myTimer() {
    var d;
    d = new Date();
    document.getElementById("timer").innerHTML = d.toLocaleTimeString();
    return myVar;
}
var id = setTimeout(loginPromt, 4000);
function loginPromt() {
var p = confirm("would like to log in");

if(p) {
    window.location = "/login";
    clearTimeout(id)
}
}



