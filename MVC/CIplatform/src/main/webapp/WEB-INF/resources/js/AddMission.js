$(document).ready(function() {
  	document.getElementById('pro-image').addEventListener('change', readImage, false);
  	$("#pro-image").val('');
  	document.getElementById('pro-docs').addEventListener('change', readDocs, false);
  	$("#pro-docs").val('');
});
function readImage() {
  if (window.File && window.FileList && window.FileReader) {
      files = event.target.files; //FileList object
      for (let i = 0; i < files.length; i++) {
         	var file = files[i];
         		
          	if (!file.type.match('image')) continue;
          
          	var picReader = new FileReader();
          	
          	picReader.addEventListener('load', function (event) {
              var picFile = event.target;
          });
          picReader.readAsDataURL(file);
      }
  } else {
      console.log('Browser not support');
  }
}
function readDocs() {
  if (window.File && window.FileList && window.FileReader) {
      docs = event.target.files; //FileList object
      for (let i = 0; i < docs.length; i++) {
         	var file = files[i];
          
          	var picReader = new FileReader();
          	
          	picReader.addEventListener('load', function (event) {
              var picFile = event.target;
          });
      }
  } else {
      console.log('Browser not support');
  }
}
