$(function(){

    $('.deleteSchedule').on('click', function(){

        var deleteId = $(this).data('id');

        $.ajax({
            url: './schedules/deletion/' + deleteId,
            type: 'DELETE',
            success: function(){
                $(location).attr('href','./schedules');

            }
        });
    })
});