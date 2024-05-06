var color = ["green", "aqua", "blue", "black"];
var i = 0;

function changeColor() {
    i++;
    if (i >= color.length) {
        i = 0;
    }
    var bgColor = document.getElementById("bgCol");
    bgColor.style.backgroundColor = color[i];
    var pColor = document.getElementsByTagName("p")[0];
    pColor.style.color = "white";
    var hColor = document.getElementsByTagName("h2")[0];
    hColor.style.color = "white";   
}

function bgWhite() {
    var bgColor = document.getElementById("bgCol");
    bgColor.style.backgroundColor = "white";
    var pColor = document.getElementsByTagName("p")[0];
    pColor.style.color = "black";
    var hColor = document.getElementsByTagName("h2")[0];
    hColor.style.color = "black";   
}