$(function(){
    var form = $('#new_schedule');

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