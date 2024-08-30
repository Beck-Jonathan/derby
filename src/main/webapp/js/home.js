$(document).ready(function(){
    $(".explanationContainer").hide();
    $(".skill").css("background-color","white").css("display", "none");

    $(".questionMark").hover(function() {

            var self = $(this);
            var kiddos = self.siblings();
            for (var i = 0; i < kiddos.length; i++) {

                var element=kiddos[i];
                if($(element).hasClass('explanationContainer')) {
                    $(kiddos[i]).show('slow');
                }
            }
        },function() {
            var self = $(this);
            var kiddos = self.siblings();
            for (var i = 0; i < kiddos.length; i++) {

                var element=kiddos[i];
                if($(element).hasClass('explanationContainer')) {
                    $(kiddos[i]).hide('slow');
                }
            }

    });

    //select capstone
    $("#capstone").hover(function() {
        addskill("cSharp");
        addskill("Html");
        addskill("CSS");
        addskill("Multi");
        addskill("T-SQL");
        addskill("Git");
        addskill("UnitTests");
        addskill("Tech");
        addskill("Agile");
        addskill("Solid");
        addskill("Interfaces");



    },function() {
        clearskills();
    });
    //end select capstone

    //select Java
    $("#java").hover(function() {
        addskill("Servlets");
        addskill("JSP");
        addskill("Framework");
        addskill("Html");
        addskill("CSS");
        addskill("JavaScript");
        addskill("Api");
        addskill("Multi");
        addskill("Git");
        addskill("Solid");



    },function() {
        clearskills();
    });
    //end select Java

    //select net
    $("#net").hover(function() {
        addskill("cSharp");
        addskill("Html");
        addskill("CSS");
        addskill("Multi");
        addskill("T-SQL");
        addskill("Git");
        addskill("UnitTests");

        addskill("Solid");
        addskill("Interfaces");



    },function() {
        clearskills();
    });
    //end select net

    //select client
    $("#client").hover(function() {
        addskill("Framework");
        addskill("Html");
        addskill("CSS");
        addskill("JavaScript");


    },function() {
        clearskills();
    });
    //end select client

    //select honors
    $("#honors").hover(function() {
        addskill("cSharp");
        addskill("Servlets");
        addskill("JSP");
        addskill("Framework");
        addskill("Html");
        addskill("CSS");
        addskill("JavaScript");
        addskill("Api");

        addskill("MySql");
        addskill("T-SQL");

        addskill("Git");
        addskill("UnitTests");

        addskill("Interfaces");



    },function() {
        clearskills();
    });
    //end select honors

    //select game
    $("#game").hover(function() {
        addskill("cSharp");
        addskill("Unity");

    },function() {
        clearskills()
    });
    //end select game

    //select budget
    $("#budget").hover(function() {
        addskill("Servlets");
        addskill("JSP");
        addskill("Framework");
        addskill("Html");
        addskill("CSS");
        addskill("JavaScript");
        addskill("Api");
        addskill("MySql");
        addskill("Git");

    },function() {
        clearskills()
    });
    //end select budget

    //select coursework
    $("#coursework").hover(function() {
        addskill("Servlets");
        addskill("JSP");
        addskill("Framework");
        addskill("Html");
        addskill("CSS");
        addskill("JavaScript");
        addskill("Api");
        addskill("Multi");
        addskill("MySql");
        addskill("Git");
        addskill("Tech");
        addskill("Agile");
        addskill("Solid");



    },function() {
        clearskills()
    });
    //end select coursework

    //select pearson
    $("#pearson").hover(function() {
        console.log("pearson")
        $("#cSharp").css("background-color","LightGreen")

    },function() {
        clearskills()
    });
    //end select pearson

    //select email
    $("#email").hover(function() {
        addskill("Servlets");
        addskill("JSP");
        addskill("Html");
        addskill("CSS");

    },function() {
        clearskills()
    });
    //end select email

    //select apidemo
    $("#apidemo").hover(function() {

        addskill("Html");
        addskill("Api");

    },function() {
        clearskills()
    });
    //end select apidemo

});

function addskill(skill){
    var element = document.getElementById(skill);
    $(element).css("background-color", "LightGreen");
    $(element).css("display", "block");
}
function clearskills() {
    var skills = document.getElementsByClassName('skill');
    for (i = 0; i < skills.length; i++) {
        $(skills[i]).css("background-color", "white");
        $(skills[i]).css("display", "none");
    }
}