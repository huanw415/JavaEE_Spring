$(function(){

    $('.deleteCourse').on('click', function(){

        var deleteId = $(this).data('id');

        $.ajax({
            url: './courses/deletion/' + deleteId,
            type: 'DELETE',
            success: function(){
                $(location).attr('href','./courses');
            }
        });
    })
});