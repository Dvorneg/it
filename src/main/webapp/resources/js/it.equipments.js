const userAjaxUrl = "/api/equipments";
let form;
// https://stackoverflow.com/a/5064235/548473
const ctx = {
    ajaxUrl: userAjaxUrl,
    updateTable: function () {
        $.get(userAjaxUrl, updateTableByData);
    }
}

function updateTableByData(data) {
    ctx.datatableApi.clear().rows.add(data).draw();
}

function makeEditable(datatableOpts) {

    ctx.datatableApi = $("#datatable11").DataTable(
        // https://api.jquery.com/jquery.extend/#jQuery-extend-deep-target-object1-objectN
        $.extend(true, datatableOpts,
            {
                "ajax": {
                    "url": ctx.ajaxUrl,
                    "dataSrc": ""
                },
                "paging": false,
                "info": true,
               "language": {
                    url:"resources/dataTable/ru_RU.json"
                }
                //, buttons: [ 'copy', 'excel', 'pdf', 'colvis' ]
            }
        ));
    /*form = $('#detailsForm');*/

    $(document).ajaxError(function (event, jqXHR, options, jsExc) {
        //alert(jsExc);
        //failNoty(jqXHR);
    });
    //alert("Шаг 1, ок!");
    $.ajaxSetup({cache: false});

    /* csrf off
       var token = $("meta[name='_csrf']").attr("content");
        var header = $("meta[name='_csrf_header']").attr("content");
        $(document).ajaxSend(function (e, xhr, options) {
            xhr.setRequestHeader(header, token);
        });*/
}

 $(document).ready(function () {
     $(function () {
         makeEditable({
             "columns": [
                 {
                     "data": "id"
                 },
                 {
                     "data": "description"
                 },
                 {
                     "data": "typeOf"
                 }
             ]
             ,
             "order": [
                 [
                     0,
                     "asc"
                 ]
             ]

         });
     });
 });