$(document).ready(function(){
	alert("Hello Javatpoint");

	//create the tab 0 button
	$("#Home").button();
	$( "#Home" ).button( "option", "icon", "ui-icon-check" );
	$( "#Home" ).button( "option", "showIcon", "true" );
	$( "#Home" ).button( "option", "label", "&nbsp&nbsp&nbsp&nbsp All Fields Required" );
})