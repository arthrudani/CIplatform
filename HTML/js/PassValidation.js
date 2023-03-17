// verify password

function verifyPassword() {  
  var pw = document.getElementById("password").value;
  var cpw = document.getElementById("confpassword").value;
  if(pw != cpw) {  
		console.log("passwords are not same");
//      	alert("Confirm password is not same"); 
     	cpw.focus(); 
     	return false;
  }
    return true;
}   