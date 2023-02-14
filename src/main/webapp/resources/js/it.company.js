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
    document.location.href = "equipments/";
}

function addCompany() {

    $.ajax({
        url: ajaxUrl +name_company.value,
        method: 'post',
        /* dataType: 'json',
        data: $(this).serialize(),*/
        success: function(){
            document.location.reload();
            //document.location.href = "/profile/company/";
            //alert("OK!")
        },
        error: function (error) {alert('error add Company; ' + eval(error));}
    });


}

$(document).ready(function () {

    beforeSelectCompany();

});