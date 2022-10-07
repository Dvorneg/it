const equipmentAjaxUrl = "/profile/equipments";
let form;
const modal = new bootstrap.Modal(document.querySelector('#editRow'));

// https://stackoverflow.com/a/5064235/548473
const ctx = {
    ajaxUrl: equipmentAjaxUrl,
    updateTable: function () {
        $.ajax({
            type: "GET",
            url: equipmentAjaxUrl /*+ "filter",*/
            /*data: $("#filter").serialize()*/
        }).done(updateTableByData);
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
                "paging": true,
                "info": true,
               "language": {
                    url:"resources/dataTable/ru.json"
                }
                //, buttons: [ 'copy', 'excel', 'pdf', 'colvis' ]
            }
        ));
    form = $('#detailsForm');

    $(document).ajaxError(function (event, jqXHR, options, jsExc) {
        failNoty(jqXHR);
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
                     "data": "inventoryNumber"
                 },
                 {
                     "data": "name"
                 },
                 {
                     "data": "description"
                 },
                 {
                     "data": "company"
                 },
                 {
                     "data": "typeOf"
                 },
                 {
                     "data": "releaseDate"
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


/*function updateRow(id) {
    form.find(":input").val("");
    $("#modalTitle").html("editTitle");
    $.get(ctx.ajaxUrl + id, function (data) {
        $.each(data, function (key, value) {
            form.find("input[name='" + key + "']").val(value);
        });
        $('#editRow').modal();
    });
}*/


let failedNote;

//После кнопки "добавить" (открытие модального окна)
function add() {
    $("#modalTitle").html("Добавить оборудование.");
    form.find(":input").val("");
    modal.show();
}

//После кнопки "Сохранить" (модального окна)
function save() {
    $.ajax({
        type: "POST",
        url: ctx.ajaxUrl,
        data: form.serialize()
    }).done(function () {
        modal.hide();
        ctx.updateTable();
        successNoty("saved");
    });
}

function closeNoty() {
    if (failedNote) {
        failedNote.close();
        failedNote = undefined;
    }
}

function successNoty(key) {
    closeNoty();
    new Noty({
        text: "<span class='fa fa-lg fa-check'></span> &nbsp;" + key,
        type: 'success',
        layout: "bottomRight",
        timeout: 1000
    }).show();
}

function failNoty(jqXHR) {
    closeNoty();
    var errorInfo = jqXHR.responseJSON;
    failedNote = new Noty({
        //text: "<span class='fa fa-lg fa-exclamation-circle'></span> &nbsp;" + errorInfo.typeMessage + "<br>" + errorInfo.details.join("<br>"),
        text: "<span class='fa fa-lg fa-exclamation-circle'></span> &nbsp;" + errorInfo.typeMessage + "<br>" + errorInfo.error+("<br>"),
        type: "error",
        layout: "bottomRight"
    });
    failedNote.show()
}