$(document).ready(function() {
    $('#btnRight').click(function(e) {
        var selectedOpts = $('#lstBox1 option:selected');
        if (selectedOpts.length == 0) {
            alert("Nothing to move.");
            e.preventDefault();
        }

        $('#lstBox2').append($(selectedOpts).clone());
        $(selectedOpts).remove();
        console.log(selectedOpts);
        e.preventDefault();
    });

    $('#btnLeft').click(function(e) {
        var selectedOpts = $('#lstBox2 option:selected');
        if (selectedOpts.length == 0) {
            alert("Nothing to move.");
            e.preventDefault();
        }

        $('#lstBox1').append($(selectedOpts).clone());
        $(selectedOpts).remove();
        console.log(selectedOpts.length);
        e.preventDefault();
        
    });
    
    $('#addSkillButton').click(function (e) {
        var selectedSkills=$('#selectedSkills').children();
        console.log(selectedSkills);
        $("#lstBox2").empty();
        $("#lstBox2").append($(selectedSkills).clone());
    });
    $('#saveSkills').click(function(e){
        var savedSkill=$("#lstBox2").children();
        console.log(savedSkill);
        $("#selectedSkills").empty();
        $('#selectedSkills').append($(savedSkill).clone());
        
    });

});
