$(document).ready(function() {
  	document.getElementById('pro-image').addEventListener('change', readImage, false);
  	$("#pro-image").val('');
 	$(document).on('click', '.image-cancel', function() {
	    let no = $(this).data('no');
	    $(".preview-image.preview-show-"+no).remove();
  	});
});

function openLeftMenu() {
  document.getElementById("leftMenu").style.display = "block";
}

function closeLeftMenu() {
  document.getElementById("leftMenu").style.display = "none";
}

function openRightMenu() {
  document.getElementById("rightMenu").style.display = "block";
}

function closeRightMenu() {
  document.getElementById("rightMenu").style.display = "none";
}



var num = 4;
function readImage() {
  if (window.File && window.FileList && window.FileReader) {
      files = event.target.files; //FileList object
      var output = $(".preview-images-zone");
      for (let i = 0; i < files.length; i++) {
         	var file = files[i];
         	console.log(file);
          	if (!file.type.match('image')) continue;
          
          	var picReader = new FileReader();
          	
          	picReader.addEventListener('load', function (event) {
              var picFile = event.target;
              var html =  '<div class="preview-image preview-show-' + num + '">' +
                          '<div class="image-cancel" data-no="' + num + '">x</div>' +
                          '<div class="image-zone"><img id="pro-img-' + num + '" src="' + picFile.result + '"></div>' +
                          '<div class="tools-edit-image"><a href="javascript:void(0)" data-no="' + num + '" class="btn btn-light btn-edit-image">edit</a></div>' +
                          '</div>';

              output.append(html);
              num = num + 1;
          });
          picReader.readAsDataURL(file);
      }
//      $("#pro-image").val('');
  } else {
      console.log('Browser not support');
  }
}

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

function gridlist(){
  document.getElementById("gridlist").style.display = "none";
  document.getElementById("listgrid").style.display = "block";
}
function listgrid(){
  document.getElementById("gridlist").style.display = "block";
  document.getElementById("listgrid").style.display = "none";
}

function mySearchText() {
    var input, filter;
    input = document.getElementById("mySearchInput");
    filter = input.value.toUpperCase()
    console.log(filter);
	
}

