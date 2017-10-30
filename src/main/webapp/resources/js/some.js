var myVar = setInterval(myTimer, 1000);var today = new Date()
var curHr = today.getHours();

if (curHr < 12) {
    alert('Good morning')
} else if (curHr < 17) {
    alert('Good afternoon')
} else {
    alert('Good evening')
}

function myTimer() {
    var d;
    d = new Date();
    document.getElementById("timer").innerHTML = d.toLocaleTimeString();
    return myVar;
}
var id = setTimeout(loginPromt, 8000);
function loginPromt() {
var p = confirm("would like to log in");

if(p) {
    window.location = "/login";
    clearTimeout(id)
}
}
function createAdForUser() {
    var button = document.getElementById('profile-create-ads').onclick;
if (button){
    window.showModalDialog("/ads/create");
}

}




