function verifyPassword() {  
  var pw = document.getElementById("password").value;
  var cpw = document.getElementById("confpassword").value;
  if(pw.length<8){
	  swal("Error!", "Minimum length is 8 character!", "error");
	  return false;
  }
  
  if(pw != cpw) {  
	  	swal("Error!", "Password and confirm password are not same!", "error");
     	return false;
  }
    return true;
}   
