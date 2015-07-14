$(function () {

    var gender = $('#gender').data('value');
    if(gender == "男"){
        $('#male').attr("checked", true);
    }else{
        $('#female').attr("checked", true);
    }
});