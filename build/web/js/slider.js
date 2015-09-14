function postForm(formName) {
    hidePanel();
    if (checkImage()) {
        $("#loading").show();
        var url = $("#" + formName).attr("url");
        var aFormData = new FormData();
        if (formName === 'editForm') {
            aFormData.append("imgPath", $('#imgPath').val());
            aFormData.append("caption", $('#caption').val());
            aFormData.append("imgId", $("#imgId").val());
            aFormData.append("x", $("#x").val());
            aFormData.append("y", $("#y").val());
            aFormData.append("w", $("#w").val());
            aFormData.append("h", $("#h").val());
        } else {
            aFormData.append("imgPath", $('#img').get(0).files[0]);
            aFormData.append("caption", $('#caption').val());
        }
        $.ajax({
            url: url,
            type: "POST",
            data: aFormData,
            cache: false,
            processData: false,
            contentType: false,
            complete: function() {
                $("#loading").hide();
            },
            error: function(response) {
                show_flash('failed');
                $('#flashBox').html('');
                $('#flashBox').html(response);
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
            show_flash('failed');
            $('#flashBox').html('');
            $('#flashBox').html(response);
        }
    });
}