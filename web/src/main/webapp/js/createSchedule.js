$(function(){

    $('#customers').hide();
    var form = $('#new_schedule');

    $('input:radio[name="courseId"]').on('click', function () {
        var courseName = $(this).data('course');

        if(courseName === 'private'){
            $('#customers').show();
        }

    });

    form.submit(function (ev) {
        $.ajax({
            type: "POST",
            url: "/web/schedules/creation",
            data: form.serialize(),
            success: function (result) {
                if(result == 'coach is busy'){
                    $('#time').css('border', "red 1px solid");
                }else{
                    $(location).attr('href', '/web/schedules');
                }
            }
        });
        ev.preventDefault();
    });
});