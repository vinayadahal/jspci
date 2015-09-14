function postForm(formName) {
    hidePanel();
    $("#loading").show();
    if (validate(['pageTitle', 'menuName', 'desc'])) {
        var url = $("#" + formName).attr("url");
        var title = $('#pageTitle').val();
        var content = CKEDITOR.instances['content'].getData();
        var desc = $('#desc').val();
        var menuName = $('#menuName').val();
        var dataString;
        if (formName === 'editForm') {
            dataString = 'title=' + title + '&content=' + content + '&desc=' + desc + '&menuName=' + menuName + '&editId=' + $("#editId").val();
        } else {
            dataString = 'title=' + title + '&content=' + content + '&desc=' + desc + '&menuName=' + menuName;
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
        alert('Some fields are empty');
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