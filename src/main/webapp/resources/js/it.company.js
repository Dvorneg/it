//const companySelect = formCompany.selectCompany;


function beforeSelectCompany() {

    $.ajax({
        url: '/profile/company',
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
    document.location.href = "/equipments";
}


$(document).ready(function () {

    beforeSelectCompany();

});