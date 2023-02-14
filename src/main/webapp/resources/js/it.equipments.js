const equipmentAjaxUrl = "profile/equipments/";

let form;
const modal = new bootstrap.Modal(document.querySelector('#editRow'));
let locale;
const datatableOpts = {
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

            "data": "typeOf",
            "render": function (data) {
                return data;

            }
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
        /* this make a stile, paint red example, data-user-excess css  color: red;
             $(row).attr("data-user-excess", data.excess);*/
    }

};

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

function getLocale() {

    $.ajax({
        type: "GET",
        url: "locale/",
        success: function (data) {
            locale = data;
            //get language, after get table and calendar
            makeEditable(datatableOpts);
            $.datetimepicker.setLocale(locale);

        },
        error: function (xhr, ajaxOptions, thrownError) {
            alert(thrownError + "\r\n" + xhr.statusText + "\r\n" + xhr.responseText);
            makeEditable(datatableOpts);
        }
    });

}

function makeEditable(datatableOpts) {

    let urlLocale;
    if (locale === "ru") {
        urlLocale = "resources/dataTable/ru.json"
    } else {
        urlLocale = "resources/dataTable/en.json"
    }

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
                    //url:"resources/dataTable/ru.json"
                    url: urlLocale
                }
                //, buttons: [ 'copy', 'excel', 'pdf', 'colvis' ]
            }
        ));

    //alert ( ${pageContext.response.locale} );
    form = $('#detailsForm');

    $(document).ajaxError(function (event, jqXHR, options) {
        failNoty(jqXHR);
    });
    //alert("Шаг 1, ок!");
    $.ajaxSetup({cache: false});

/*    // csrf off
    var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");
    $(document).ajaxSend(function (e, xhr, options) {
        xhr.setRequestHeader(header, token);
    });*/
}

let failedNote;

//after "add" button (open modal window)
function add() {
    $("#modalTitle").html("Добавить оборудование");
    form.find(":input").val("");
    modal.show();
}

/*after "edit" button (open modal window)*/
function updateRow(id) {

    form.find(":input").val("");
    $("#modalTitle").html("Изменить оборудование.");
    $.get(ctx.ajaxUrl + id, function (data) {
        $.each(data, function (key, value) {
            form.find("input[name='" + key + "']").val(value);
        });
        /*Setting the current value in the list of enumerations*/
        $('#typeOfArray').val($('#typeOf').val());
        modal.show();
    });
}

/*after "delete" button*/
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


///*after "save " button*/ (modal window)
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

/*Pop-up notifications*/
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
            text: "<span class='fa fa-lg fa-exclamation-circle'></span> &nbsp;" + errorInfo.typeMessage + "<br>" + errorInfo.details.join("<br>"),
            type: "error",
            layout: "bottomRight"
        });
        failedNote.show()
}


/*button, icon output*/
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
    getLocale();

    $('#releaseDate').datetimepicker({
        /*language:'ru',*/
        timepicker: false,
        format: 'y-m-d',
        formatDate: 'y-m-d',
    });

});


