function loadData() {
    $("#loading").show();
    $.ajax({
        url: $("#bodyMain").attr('url'),
        type: "get",
        cache: false,
        complete: function() {
            $('#loading').hide();
        },
        success: function(response) {
            $('#bodyMain').html('');
            $('#bodyMain').html(response);
        },
        failure: function(response) {
            console.log(response);
        }
    });
}

function showAddPanel(id, heading) {
    $("#loading").show();
    $.ajax({
        url: $("#" + id).attr('url'),
        type: "get",
        cache: false,
        complete: function() {
            $('#loading').hide();
        },
        success: function(response) {
            $("#formPanel").fadeIn(600);
            $("#heading").html(heading);
            $("#data").html(response);
        },
        failure: function(response) {
            console.log(response);
        }
    });
}

function showUpdatePanel(url, heading) {
    $("#loading").show();
    $.ajax({
        url: url,
        type: "get",
        cache: false,
        complete: function() {
            $('#loading').hide();
        },
        success: function(response) {
            $("#formPanel").fadeIn(600);
            $("#heading").html(heading);
            $("#data").html(response);
            if (heading === 'Publish Image') {
                $('#formSize').attr('class', 'pagesPopupFrom');
            }
        },
        failure: function(response) {
            console.log(response);
        }
    });
}

function hidePanel() {
    $("#formPanel").fadeOut(600);
}
