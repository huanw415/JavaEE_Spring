$(function () {

    $('.chooseCoach').on('click', function () {

        var coachName = $(this).data("name");

        $('#dropdownMenu').data('id', $(this).data('id'));
        $('#dropdownMenu').text(coachName);

        //console.log($('#dropdownMenu').data('id'));
    });


    $('.submit').on('click', function(){

        var courseId = $(this).data("id");
        var coachId = $('#dropdownMenu').data('id');
        var courseName = $('#dropdownMenu').text();
        console.log(courseName + "=======");
        console.log(coachId + "=======");
        $.ajax({
            type: 'POST',
            url: './courses/update/' + courseId,
            data: {coachId: coachId,
                   courseName: courseName},
            success: function(){
                $(location).attr('href', './courses');
            }
        });
    });

});