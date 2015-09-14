function postForm(formName) {
    hidePanel();
    $("#loading").show();
    if (validate(['navName', 'description'])) {
        var url = $("#" + formName).attr("url");
        var navName = $('#navName').val();
        var description = $('#description').val();
        var dataString;
        if (formName === 'editForm') {
            dataString = 'navName=' + navName + '&description=' + description + '&editId=' + $("#editId").val();
        } else {
            dataString = 'navName=' + navName + '&description=' + description;
        }
        $.ajax({
            url: url,
            type: "POST",
            data: dataString,
            cache: false,
            complete: function() {
                $("#loading").hide();
            },
            success: function(response) {
                $('#flashBox').html('');
                $('#flashBox').html(response);
                loadData();
                show_flash('success');
            },
            failure: function(response) {
                show_flash('success');
                $('#flashBox').html('');
                $('#flashBox').html(response);
            }
        });
    } else {
        $('#loading').hide();
        alert('Error occurred!');
    }
}

function deleteData() {
    $("#loading").show();
    $.ajax({
        url: $("#eventYes").attr('url'),
        type: "get",
        cache: false,
        complete: function() {
            $('#loading').hide();
        },
        success: function(response) {
            $('#flashBox').html('');
            $('#flashBox').html(response);
            loadData();
            show_flash('success');
        },
        failure: function(response) {
            show_flash('success');
            $('#flashBox').html('');
            $('#flashBox').html(response);
        }
    });
}