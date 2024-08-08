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

	$("#Mortgage").button();
	$( "#Mortgage" ).button( "option", "icon", "ui-icon-check" );
	$( "#Mortgage" ).button( "option", "showIcon", "true" );
	$( "#Mortgage" ).button( "option", "label", "Mortgage" );

	$("#Mortgage_Payment").button();
	$( "#Mortgage_Payment" ).button( "option", "icon", "ui-icon-check" );
	$( "#Mortgage_Payment" ).button( "option", "showIcon", "true" );
	$( "#Mortgage_Payment" ).button( "option", "label", "calculate" );

	let submit_mortgage = document.getElementById("Save_Mortgage")
	submit_mortgage.setAttribute("disabled","true");
	var payment = document.getElementById("Mortgage_Payment")
	if (payment!=null) {
		let submit_mortgage = document.getElementById("Save_Mortgage")

		payment.addEventListener('click', function () {
			var errors=0;
			var p=0;
			var r=0;
			var n=0;
			var i=0;
			//get pv
			var pv = document.getElementById("inputmortgagePresent_Value")
			if (pv.value!="") {
				 p = pv.value;
			}
			else{errors++;}
			//get rate
			var rate = document.getElementById("inputmortgageInterest_Rate")
			if (rate.value!="") {
				 i = rate.value*1.00/100/12;

			}
			else{errors++;}
			//get fv
			var fv = document.getElementById("inputmortgageFuture_Value")
			if (fv.value!="") {
				 fv = fv.value;
			}
			else{errors++;}

			//get nper
			var nper = document.getElementById("inputmortgageRemaining_Term")
			if (nper.value!="") {
				 n = nper.value;

			}
			else{errors++;}
			if (errors==0){
				var payment_bpx = document.getElementById("inputmortgageMonthly_Payment");
				console.log("Pricipal:"+p+"\n Interest Rate: "+i+"\n Nper: "+n+" ")
				var monthly_payment = Math.round(p * i * (Math.pow(1 + i, n)) / (Math.pow(1 + i, n) - 1)*100)/100;
				var month=1;
				console.log((monthly_payment));
				submit_mortgage.removeAttribute("disabled");
				submit_mortgage.setAttribute("enabled","true");
				amortization=document.getElementById("amortization");
				var table = document.createElement("table");
				table.classList.add("table");
				table.classList.add("table-bordered");
				var th  = document.createElement("tr");
				var rh=document.createElement("th");
				rh.innerHTML="Month";
				th.appendChild(rh);
				rh=document.createElement("th");
				rh.innerHTML="Payment";
				th.appendChild(rh);
				rh=document.createElement("th");
				rh.innerHTML="Interest";
				th.appendChild(rh);
				rh=document.createElement("th");
				rh.innerHTML="Principal";
				th.appendChild(rh);
				table.appendChild(th);
				while(p>0){
					tr=document.createElement("tr")
					var interest = Math.round(100*p*i)/100;
					p = Math.round(100*(p-monthly_payment+interest))/100;
					month++;
					var td=document.createElement("td")
					td.innerHTML=month;
					tr.append(td);
					 td=document.createElement("td")
					td.innerHTML=monthly_payment;
					tr.append(td);
					 td=document.createElement("td")
					td.innerHTML=interest;
					tr.append(td);
					 td=document.createElement("td")
					td.innerHTML=p;
					tr.append(td);
					table.appendChild(tr);


				}
				document.getElementById('amortization').appendChild(table);
				console.log(amortization.innerHTML)
			}


		});
	}




});
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


}
	const onClick = function () {

	}
	var allbuttons = document.getElementsByClassName("category");
	for (var i = 0; i < allbuttons.length; i++) {
		allbuttons[i].addEventListener('change', function () {

			category = this.value;
			let id = this.getAttribute("id");
			var address=document.getElementById("addr").getAttribute("addr");



			let y = takevalues(id,address);


		});
}




