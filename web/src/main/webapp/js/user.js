$(function(){

    $(".deleteUser").on("click", function(){

        var id = $(this).data('id');

        $.ajax({
            url: './users/deletion/' + id,
            type: 'DELETE',
            success: function() {
                $(location).attr('href','./users');
            }
        });
    })
});