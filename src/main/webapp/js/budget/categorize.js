$(document).ready(function() {
    var allbuttons = document.getElementsByClassName("category");
    for (var i = 0; i < allbuttons.length; i++) {
        allbuttons[i].addEventListener('change', function () {

            category = this.value;
            let id = this.getAttribute("id");
            var address = document.getElementById("addr").getAttribute("addr");


            let y = takevalues(id, address);


        });
}
function takevalues(x,url) {

    document.getElementById(x+"_status").style.transition = "all 2s";
    if (category == null) {
        return;
    }
    $("#"+x+"_status").show("slide", { direction: "left" }, 300);
    document.getElementById(x+"_status").innerText="loading";
    document.getElementById(x+"_status").style.color="red";


    const xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (xhr.readyState == XMLHttpRequest.DONE) {
            console.log(xhr.responseText);
            console.log(x+"_status");
            document.getElementById(x+"_status").innerText=xhr.responseText;
            document.getElementById(x+"_status").style.color="green";
            $("#"+x+"_status").hide("fade", { direction: "right" }, 300);
        }
    }



    xhr.open("POST", url+"/UTS", true);
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    let params = "t_id=" + x + "&category=" + category; // probably use document.getElementById(...).value
    xhr.send(params);


}})

