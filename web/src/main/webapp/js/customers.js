$(function(){

    $('.deleteCustomer').on('click', function(){

        var deleteId = $(this).data('id');

        $.ajax({
            url: './customers/deletion/' + deleteId,
            type: 'DELETE',
            success: function(){
                $(location).attr('href','./customers');
            }
        });
    })
});