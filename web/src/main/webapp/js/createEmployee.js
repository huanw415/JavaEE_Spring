$(function(){

    var userName;
   $('.chooseUser').on('click', function(){

       userName = $(this).data('name');
       $('#dropdownMenu').text(userName);
   });

    $('.submit').on('click', function(){
        var employeeName = $('#employeeName').val();
        var role = $('input:radio[name="role"]:checked').val();

        $.ajax({
            url: '/web/employees/creation',
            type: 'POST',
            data: {employeeName: employeeName, role: role, userName: userName},
            success: function(data){
                $(location).attr('href', '/web/employees');
            }
        })
    })
});