/**
 * 
 */

window.onload = function() {
	loadLoginView();
	$('#login').on('click', loadHomeView);
	$('#login').on('click', loadManager);
	$('#show').on('click', loadSubmitted);
	$('#submit').on('click', loadSubmitted);
	$('#make').on('click', loadSubmit);
	$('#homeNav').on('click', loadLoginView);
	$('#home').on('click', loadHomeView);
	$('#ahome').on('click', loadManager);
	
}

function loadLoginView() {

	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			$('#view').html(xhr.responseText);
			$('#login').on('click', login);
			$('#homeNav').on('click', loadLoginView);
		}
	}
	xhr.open("GET", "login.view", true);
	xhr.send();
}

function loadManager(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			$('#view').html(xhr.responseText);
			$('#showRes').on('click', loadPending);
			$('#viewRes').on('click', loadResolved);
			$('#homeNav').on('click', loadLoginView);
			$('#ahome').on('click', loadManager);
		}
	}
	xhr.open("GET", "manager.view", true);
	xhr.send();
}

function loadHomeView() {

	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			$("#view").html(xhr.responseText);
			$('#homeNav').on('click', loadLoginView);
			$('#show').on('click', loadSubmitted);
			$('#make').on('click', loadSubmit);
			$('#home').on('click', loadHomeView);
			
		}
	}
	xhr.open("GET", "home.view", true);
	xhr.send();
}
function login() {
	var username = $('#username').val();
	var password = $('#password').val();
	var obj = {
		ersUserName : username,
		ersPassword : password
	};
	
	var toSend = JSON.stringify(obj);
	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			$("#view").html(xhr.responseText);
			$('#show').on('click', loadSubmitted);
			$('#make').on('click', loadSubmit);
			$('#showRes').on('click', loadPending);
			$('#viewRes').on('click', loadResolved);
			$('#homeNav').on('click', loadLoginView);
			$('#home').on('click', loadHomeView);
			$('#ahome').on('click', loadManager);
			
		}
	}
	xhr.open("POST", "login", true);
	xhr.setRequestHeader("Content-Type", "application/json");
	xhr.send(toSend);
	
}

function loadPending(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			$('#view').html(xhr.responseText);
			getPending();
			$('#homeNav').on('click', loadLoginView);
			$('#ahome').on('click', loadManager);
		}
	}
	
	xhr.open("GET", "pending.view", true);
	xhr.send();
}

function loadResolved(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			$('#view').html(xhr.responseText)
			getResolved();
			$('#homeNav').on('click', loadLoginView);
			$('#ahome').on('click', loadManager);
		}
	}
	xhr.open("GET", "resolved.view", true);
	xhr.send();
	
}

function getResolved(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			console.log(xhr.responseText);
			let sub = JSON.parse(xhr.responseText);
			console.log(sub);
			for(let s of sub){
				appendResolved(s);
			}
			
		}
	}
	xhr.open("GET", "resolved", true);
	xhr.send();
}

function appendResolved(s){
	function reimb(){
	if(s.reimbStatusId == 1){
		s.reimbStatusId = 'Approved';
	}
	if(s.reimbStatusId == 2){
		s.reimbStatusId = 'Denied';
	}
	return s.reimbStatusId
	}
	var li = $(`<tr>
			<td>${s.reimbId}</td>
			<td>${s.reimbAmount}</td>
			<td>${s.reimbDescription}</td>
			<td>${reimb()}</td>
			
			</tr>`);
	$('#resolvedReq').append(li);
}



function loadSubmit(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			$('#view').html(xhr.responseText);
			$('#submit').on('click', makeReimbursement);
			$('#submit').on('click', loadSubmit);
			$('#homeNav').on('click', loadLoginView);
			$('#home').on('click', loadHomeView);
		}
	}
	xhr.open("GET", "reim.view", true);
	xhr.send();
	
}

function loadSubmitted(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			$('#view').html(xhr.responseText);
			getSubmitted();
			$('#goback1').on('click', loadHomeView);
			$('#homeNav').on('click', loadLoginView);
			$('#home').on('click', loadHomeView);
		}
	}
	xhr.open("GET", "submitted.view", true);
	xhr.send();
}

function getPending(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			console.log(xhr.responseText);
			let sub = JSON.parse(xhr.responseText);
			console.log(sub);
			for(let s of sub){
				appendPending(s);
			}
			$('#goback').on('click', loadManager);
		}
	}
	xhr.open("GET", "pending", true);
	xhr.send();
}

function loadResult(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			$('#view').html(xhr.responseText);
			$('#goback2').on('click', loadPending);
			
		}
	}
	
	xhr.open("GET", "result.view", true);
	xhr.send();
}

function appendPending(s){
	var l = $(`<tr>
		<td>${s.reimbId}</td>
		<td>${s.reimbAmount}</td>
		<td>${s.reimbDescription}
		<td>
                <button onclick="approveRequest(${s.reimbId}, 1); loadResult()" class="fa fa-check"></button>
                <button onclick="approveRequest(${s.reimbId}, 2); loadResult()" class="fa fa-times"></button>
        </td>
		</tr>`);
	$('#pendingReq').append(l);
}

function getSubmitted(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			console.log(xhr.responseText);
			let sub = JSON.parse(xhr.responseText);
			console.log(sub);
			for(let s of sub){
				appendSubmitted(s);
			}
		}
	}
	xhr.open("GET", "submitted", true);
	xhr.send();
}

function appendSubmitted(s){
	function reimb(){
		if(s.reimbStatusId == 1){
			s.reimbStatusId = 'Approved';
		}
		if(s.reimbStatusId == 2){
			s.reimbStatusId = 'Denied';
		}
		if(s.reimbStatusId == 3){
			s.reimbStatusId = 'Pending';
		}
		return s.reimbStatusId
		}
	var li = $(`<tr>
			<td>${s.reimbId}</td>
			<td>${s.reimbAmount}</td>
			<td>${s.reimbDescription}</td>
			<td>${reimb()}</td>
			</tr>`);
	$('#submittedList').append(li);
}

function makeReimbursement(){
	var amount = $('#amount').val();
	var description = $('#description').val();
	var type = $('#type').val();
	var submit = new Date();
	var obj = {
			reimbAmount: amount,
			reimbSubmitted: submit,
			reimbResolved: 2,
			reimbDescription: description,
			reimbResolver: 2,
			reimbStatusId: 3,
			reimbTypeId: type
	};
	
	var toSend = JSON.stringify(obj);
	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4){
			console.log(xhr.status);
			console.log(xhr.responseText);
			console.log(xhr.responseType);
			$('#submit').on('click', loadSubmit);
			
		}
	}
	xhr.open("POST", "reim", true);
	xhr.setRequestHeader("Content-Type", "application/json");
	xhr.send(toSend);
}

function approveRequest(reimbId, number){
	var submit = new Date();
	var obj = {
			reimbId: reimbId,
			reimbStatusId: number,
			reimbResolved: submit
	};
	var toSend = JSON.stringify(obj);
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4){
			console.log(xhr.status)
		}
	}
	console.log(toSend);
	xhr.open("PUT", "pending", true);
	xhr.setRequestHeader("Content-Type", "application/json");
	xhr.send(toSend);
}

