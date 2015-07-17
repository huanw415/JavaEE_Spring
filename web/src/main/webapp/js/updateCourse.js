$(function () {

    $('.chooseCoach').on('click', function () {
        
        var coachName = $(this).data("name");
        $('#dropdownMenu').text(coachName);
    })
});