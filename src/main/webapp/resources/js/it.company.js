const ajaxUrl = "profile/company/";
//const companySelect = formCompany.selectCompany;
const name_company = document.querySelector("[id='name_company']");

function beforeSelectCompany() {

    $.ajax({
        url: ajaxUrl,
        dataType: "json",
        //success: function (data, textStatus) {
        success: function (data ) {

            $.each(data, function(i, val) {
                //$('#select_hero').append('<option value="val.name">"val.name"</option>');
                //$('#select_hero').append('<option value="' +'n'+ val.id + '">' + val.name + '</option>');
                $('#selectCompany').append('<option value="' + val.id + '">' + val.name + '</option>');

            });

        }
    });

}


function selectCompany() {

    var companyId= document.getElementById("selectCompany").value;
    $.ajax({
        url: ajaxUrl +'select/' + companyId,
        method: 'post',
        success: function(){
            document.location.href = "equipments/";
        },
        error: function (error) {alert('error select Company; ' + eval(error));}
    });

}

function addCompany() {

    $.ajax({
        url: ajaxUrl +name_company.value,
        method: 'post',
        success: function(){
            document.location.reload();
        },
        error: function (error) {alert('error add Company; ' + eval(error));}
    });


}

$(document).ready(function () {

    beforeSelectCompany();

});