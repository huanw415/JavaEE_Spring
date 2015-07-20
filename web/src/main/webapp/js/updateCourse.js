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
        var courseName = $('#name').val().trim();

        $.ajax({
            url: '/web/courses/update/' + courseId,
            type: 'POST',
            data: {coachId: coachId,
                   courseName: courseName},
            success: function(result){
                $(location).attr('href', '/web/courses');
            }
        });
    });
});