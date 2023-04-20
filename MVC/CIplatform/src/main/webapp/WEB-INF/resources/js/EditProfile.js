$(document).ready(function() {
    $('#btnRight').click(function(e) {
        var selectedOpts = $('#lstBox1 option:selected');
        if (selectedOpts.length == 0) {
            swal("Nothing to move.","","error");
            e.preventDefault();
        }

        $('#lstBox2').append($(selectedOpts).clone());
        $(selectedOpts).remove();
        e.preventDefault();
    });

    $('#btnLeft').click(function(e) {
        var selectedOpts = $('#lstBox2 option:selected');
        if (selectedOpts.length == 0) {
            swal("Nothing to move.","","error");
            e.preventDefault();
        }

        $('#lstBox1').append($(selectedOpts).clone());
        $(selectedOpts).remove();
        e.preventDefault();
        
    });
    
    $('#addSkillButton').click(function (e) {
        var selectedSkills=$('#selectedSkills').children();
        $("#lstBox2").empty();
//        $("#lstBox2").append($(selectedSkills).clone());
    });
    $('#saveSkills').click(function(e){
        var savedSkill=$("#lstBox2").children();
        $("#selectedSkills").empty();
        $('#selectedSkills').append($(savedSkill).clone());
//        console.log(savedSkill);
//        console.log($('#selectedSkills').val());
        console.log($("#lstBox2").clone());
    });

});
function openRightMenu() {
  document.getElementById("rightMenu").style.display = "block";
}

function closeRightMenu() {
  document.getElementById("rightMenu").style.display = "none";
}
