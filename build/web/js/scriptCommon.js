function show_flash(id) {
    $("#" + id).fadeIn('slow');
    setInterval(function() {
        $("#" + id).fadeOut('slow');
    }, 5000);
}

function show_logout() {
    $("#logout_box").fadeIn('slow');
}
function hide_logout() {
    $("#logout_box").fadeOut('slow');
}

function showAlert(msg) {
    $("#popupBackground").fadeIn();
    $('#alertPop').fadeIn(600);
    $('#paragraph').html(msg);
}
function hideAlert() {
    $("#popupBackground").fadeOut(600);
    $('#alertPop').fadeOut();
}

function showConfirm(url) {
    $("#popupBackground").fadeIn();
    $('#confirmPop').fadeIn(600);
    $('#eventYes').attr('url', url);
}

function hideConfirm() {
    $("#popupBackground").fadeOut(600);
    $('#confirmPop').fadeOut();
}

function validate(idArray) {
    var count = idArray.length;
    for (var i = 0; i <= count; i++) {
        if (idArray[i] === 'title') {
            countChars();
        }
        if (checkNull(idArray[i])) {
            continue;
        } else {
            showAlert('Please fill every fields.');
            return false;
        }
    }
    return true;
}

function countChars() {
    var val = $('#title').val().length;
    if (val > 20) {
        alert('Only 20 characters are allowed in title.');
        $('#title').css({
            'color': '#f00'
        });
        return false;
    } else if ($('#title').val() === '') {
        return false;
    } else {
        $('#title').css({
            'color': '#555'
        });
        return true;
    }
}

function checkNull(idName) {
    var id = $("#" + idName).val();
    if (id === '') {
        return false;
    } else {
        return true;
    }
}
