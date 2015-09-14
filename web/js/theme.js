function postData(url) {
    $("#loading").show();
    $.ajax({
        url: url,
        type: "POST",
        cache: false,
        processData: false,
        contentType: false,
        complete: function () {
            $("#loading").hide();
        },
        error: function (response) {
            show_flash('failed');
            $('#flashBox').html('');
            $('#flashBox').html(response);
        },
        success: function (response) {
            $('#flashBox').html('');
            $('#flashBox').html(response);
            show_flash('success');
        },
        failure: function (response) {
            show_flash('success');
            $('#flashBox').html('');
            $('#flashBox').html(response);
        }
    });
}

function deleteData() {
    $("#loading").show();
    $.ajax({
        url: $("#eventYes").attr('url'),
        type: "get",
        cache: false,
        complete: function () {
            $('#loading').hide();
        },
        success: function (response) {
            $('#flashBox').html('');
            $('#flashBox').html(response);
            loadData();
            show_flash('success');
        },
        failure: function (response) {
            show_flash('failed');
            $('#flashBox').html('');
            $('#flashBox').html(response);
        }
    });
}