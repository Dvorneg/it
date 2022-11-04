const equipmentAjaxUrl = "/profile/equipments/";
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
let failedNote;

//После кнопки "добавить" (открытие модального окна)
function add() {
    $("#modalTitle").html("Добавить оборудование.");
    form.find(":input").val("");
    modal.show();
}

/*После кнопки "изменить" (открытие модального окна)*/
function updateRow(id) {

    form.find(":input").val("");
    $("#modalTitle").html("Изменить оборудование.");
    $.get(ctx.ajaxUrl + id, function (data) {
        $.each(data, function (key, value) {
            form.find("input[name='" + key + "']").val(value);
        });
        /*Установка текущего значения в списке перечислений*/
        $('#typeOfArray').val($('#typeOf').val());
        modal.show();
    });
}

/*После кнопки "удалить"*/
function deleteRow(id) {
    if (confirm('Удалить запись?')) {
        $.ajax({
            url: ctx.ajaxUrl + id,
            type: "DELETE"
        }).done(function () {
            ctx.updateTable();
            successNoty("deleted");
        });
    }
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

/*Всплывающие уведомления*/
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


/*Кнопки, вывод значков*/
function renderEditBtn(data, type, row) {
    if (type === "display") {
       /* return "<a onclick='updateRow(" + row.id + ");'><span class='fa fa-pencil'></span></a>";*/
        return "<a onclick='updateRow(" + row.id + ");'><span class='fa fa-edit'></span></a>";
    }
}

function renderDeleteBtn(data, type, row) {
    if (type === "display") {
        return "<a onclick='deleteRow(" + row.id + ");'><span class='fa fa-remove'></span></a>";
    }
}

function onChangeTypeOfArray(text) {
    /*alert(text);*/
    $('#typeOf').val(text);
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
                },
                {
                    "render": renderEditBtn,
                    "defaultContent": "",
                    "orderable": false
                },
                {
                    "render": renderDeleteBtn,
                    "defaultContent": "",
                    "orderable": false
                }
            ]
            ,
            "order": [
                [
                    0,
                    "asc"
                ]
            ],
            "createdRow": function (row, data, dataIndex) {
               /* Тут можно при создании применить стили, например расркасить красным, где data-user-excess css  color: red;
                    $(row).attr("data-user-excess", data.excess);*/
            }

        });

    });

    $('#releaseDate').datetimepicker({
        /*language:'ru',*/
        timepicker: false,
        format: 'y-m-d',
        formatDate: 'y-m-d',
    });

    $.datetimepicker.setLocale('ru');

});


