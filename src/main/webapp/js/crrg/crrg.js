$(document).ready(function() {
    document.body.addEventListener('touchstart', function(e){ e.preventDefault(); });
    var i = 0;
    var modal = document.getElementById("myModal");
    var modalbg = document.getElementById("modalbg");
    var modalImg = document.getElementById("img01");
    var  images = document.getElementsByClassName("image");

    for (const image of images) {

        image.ondblclick=(event)=>{
            i=0;
            while (true){
                if (images[i].id===image.id){
                    break;
                }
                i++;
            }
            modal.style.display = "block";
            modalbg.style.display = "block";
            modalImg.src = image.src;
            checkArrows(i,images);
            offsetCalculate();
            modal.style.height = 10;
            //modalImg.style.height = Math.Min(image.height,95);
            //modalImg.style.width = Math.Min(image.width,95);
            //captionText.innerHTML = this.alt;
            }
        }

    var right = document.getElementsByClassName("right")[0];
    right.onclick = function() {
        i++;
        pageRight(i,images,modalImg);
        offsetCalculate();
        checkArrows(i,images);

    }

    var left = document.getElementsByClassName("left")[0];
    left.onclick = function(){
        i--;
        pageLeft(i,images,modalImg);
        offsetCalculate();
    checkArrows(i,images);
    };

    var span = document.getElementsByClassName("close")[0];
    span.onclick = function() {
        modal.style.display = "none";
        modalbg.style.display = "none";
    }

    const track = document.getElementById("image-track");

const handleOnDown = e => track.dataset.mouseDownAt = e.clientX;

const handleOnUp = () => {
    track.dataset.mouseDownAt = "0";
    track.dataset.prevPercentage = track.dataset.percentage;
}

const handleOnMove = e => {
    if(track.dataset.mouseDownAt === "0") return;

    const mouseDelta = parseFloat(track.dataset.mouseDownAt) - e.clientX,
        maxDelta = window.innerWidth / 2;

    var percentage = (mouseDelta / maxDelta) * -100;
    var    nextPercentageUnconstrained = parseFloat(track.dataset.prevPercentage) + percentage;
    var    nextPercentage = Math.max(Math.min(nextPercentageUnconstrained, 0), -100);
    if (isNaN(nextPercentage) ){
        nextPercentage=-50;
    }
    track.dataset.percentage = nextPercentage;

    track.animate({
        transform: `translate(${nextPercentage}%, -50%)`
    }, { duration: 1200, fill: "forwards" });

    for(const image of track.getElementsByClassName("image")) {
        image.animate({
            objectPosition: `${100 + nextPercentage}% center`
        }, { duration: 1200, fill: "forwards" });
    }

}

/* -- Had to add extra lines for touch events -- */

window.onmousedown = e => handleOnDown(e);

window.ontouchstart = e => handleOnDown(e.touches[0]);

window.onmouseup = e => handleOnUp(e);

window.ontouchend = e => handleOnUp(e.touches[0]);

window.onmousemove = e => handleOnMove(e);

window.ontouchmove = e => handleOnMove(e.touches[0]);

})

function change(){
    const  images = document.getElementsByClassName("image");
    var selected = document.getElementById("selectevent").value;

    var credits = document.getElementById("credit");

    if(selected==="stpats"){

        credits.style.display= "none";
    }
    else {

        credits.style.display= "block";
    }
    for (const image of images) {
    let currentsource = image.src;

    let newsource = currentsource.replace("ames",selected);
         newsource = newsource.replace("wisconsin",selected);
         newsource = newsource.replace("stpats",selected)
        image.src=newsource;

    }

}

function replaceChar(origString, replaceChar, index) {
    let firstPart = origString.substr(0, index);
    let lastPart = origString.substr(index + 1);

    let newString = firstPart + replaceChar + lastPart;
    return newString;
}

function pageLeft(i,images,modalImg) {

    var newImage = images[i];
    modalImg.src = newImage.src;
}


    function pageRight(i,images,modalImg){

        var newImage=images[i];
        modalImg.src=newImage.src;

    }
    function checkArrows( i,images){
        var left = document.getElementsByClassName("left")[0];
        var right = document.getElementsByClassName("right")[0];
        if (i===0){
            left.style.display="none"
        }
        else {
            left.style.display="block"
        }
        if (i===images.length-1){
            right.style.display="none"

        }
        else {
            right.style.display="block"
        }

    }

function offsetCalculate(){
    var parent = document.getElementById('img01');
    console.log (parent);
    var xLeft = parent.x
    var width = parent.clientWidth;
    var padding=20;
    var leftLocation = xLeft+padding;
    var rightLocation =xLeft+width-padding;
    var leftString = leftLocation+"px";
    var rightString = rightLocation+"px";
    console.log(leftString);
    console.log(rightString);
   // $('#close').css({

        //'right': rightString,
   // });
   // $('#left').css({

        //'left': leftString,
   // });
   // $('#right').css({

     //   'right': rightString,
    //});
}

