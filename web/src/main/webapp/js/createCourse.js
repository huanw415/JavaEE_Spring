$(function(){

    var form = $('#new_course');

    form.submit(function (ev) {
        $.ajax({
            type: "POST",
            url: "/web/courses/creation",
            data: form.serialize(),
            success: function (result) {
                if(result == 'the course has existed'){
                    $('#courseName').css('border', "red 1px solid");
                }else{
                    $(location).attr('href', '/web/courses');
                }
            }
        });
        ev.preventDefault();
    });
});