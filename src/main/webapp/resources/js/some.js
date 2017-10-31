var myVar = setInterval(myTimer, 1000);
var today = new Date()

function myTimer() {
    var d;
    d = new Date();
    document.getElementById("timer").innerHTML = d.toLocaleTimeString();
    return myVar;
}

if(p) {
    window.location = "/login";
    clearTimeout(id)
} else {
    window.location = "/index.jsp"
    clearTimeout(id);

}

$('#login').on("click", function(){
    $('#login').css().display = "none";
});



