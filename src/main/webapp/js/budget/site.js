$(document).ready(function() {
	const category ="";

console.log("ready on new version")
	$("#Home").button();
	$( "#Home" ).button( "option", "icon", "ui-icon-check" );
	$( "#Home" ).button( "option", "showIcon", "true" );
	$( "#Home" ).button( "option", "label", "Home" );

	$("#SignUp").button();
	$( "#SignUp" ).button( "option", "icon", "ui-icon-check" );
	$( "#SignUp" ).button( "option", "showIcon", "true" );
	$( "#SignUp" ).button( "option", "label", "SignUp" );

	$("#SignIn").button();
	$( "#SignIn" ).button( "option", "icon", "ui-icon-check" );
	$( "#SignIn" ).button( "option", "showIcon", "true" );
	$( "#SignIn" ).button( "option", "label", "SignIn" );

	$("#user-dash").button();
	$( "#user-dash" ).button( "option", "icon", "ui-icon-check" );
	$( "#user-dash" ).button( "option", "showIcon", "true" );
	$( "#user-dash" ).button( "option", "label", "User Dash" );

	$("#Add").button();
	$( "#Add" ).button( "option", "icon", "ui-icon-check" );
	$( "#Add" ).button( "option", "showIcon", "true" );
	$( "#Add" ).button( "option", "label", "Add" );

	$("#View").button();
	$( "#View" ).button( "option", "icon", "ui-icon-check" );
	$( "#View" ).button( "option", "showIcon", "true" );
	$( "#View" ).button( "option", "label", "View" );


	$("#Category").button();
	$( "#Category" ).button( "option", "icon", "ui-icon-check" );
	$( "#Category" ).button( "option", "showIcon", "true" );
	$( "#Category" ).button( "option", "label", "Category Management" );


	$("#MoneyBreakdown").button();
	$( "#MoneyBreakdown" ).button( "option", "icon", "ui-icon-check" );
	$( "#MoneyBreakdown" ).button( "option", "showIcon", "true" );
	$( "#MoneyBreakdown" ).button( "option", "label", "BreakDown" );

	$("#Export").button();
	$( "#Export" ).button( "option", "icon", "ui-icon-check" );
	$( "#Export" ).button( "option", "showIcon", "true" );
	$( "#Export" ).button( "option", "label", "Export" );




});
function takevalues(x) {
	if (category == null) {
		return;
	}
	console.log(x+" "+category)

	const xhr = new XMLHttpRequest();
	xhr.open("POST", "http://localhost:8080/JavaIII_Kirkwood_war_exploded/categorize_transaction", true);
	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

	let params = "t_id=" + x + "&category=" + category; // probably use document.getElementById(...).value
	xhr.send(params);
	//return false;

}
	const onClick = function () {

	}
	var allbuttons = document.getElementsByClassName("category");
	for (var i = 0; i < allbuttons.length; i++) {
		allbuttons[i].addEventListener('change', function () {


			category = this.value;
			console.log("the new cat is: " + category);
		});

}

