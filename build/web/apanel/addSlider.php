<div class="admin_site_center">
    <form method="POST" url="<?php echo baseUrl; ?>apanel/insertSlider" enctype="multipart/form-data" id="addForm">
        <label for="caption"><h5>Caption:</h5></label>
        <input id="caption" type="text" class="form-control admin_editBox_override" name="caption"/>
        <a href="javascript:void(0)">
            <span class="admin_edit_btn btn-file">
                <i class="glyphicon glyphicon-paperclip back_btn"></i> 
                Browse <input type="file" name="img" id='img'>
            </span>
        </a>
        <button type="button" class="admin_add_btn" style="float: right;" id="addUpdate">
            <i class="glyphicon glyphicon-arrow-up back_btn"></i> Upload
        </button>
    </form>
</div>
<label><h5>Preview: </h5></label>
<img id='imgLocation' class='productImg' style="width:400px;margin-bottom: 10px;height: 200px;">
<script>
    $(document).ready(function () {
        $(window).keydown(function (event) {
            if (event.keyCode === 13) {
                event.preventDefault();
                return false;
            }
        });
        $('#readMoreClose').click(function () {
            closeReadMore();
        });
        $('#img').change(function () {
            var filesize = this.files[0].size;
            if (filesize >= 2097152) {
                showAlert('File size should be less than 2 MB.');
                this.value = '';
            } else {
                showImg(this);
            }
        });
        $("#cancelBtn,#formClose").click(function () {
            hidePanel('addItemPanel');
        });
        $("#addUpdate").click(function () {
            postForm('addForm');
        });
    });
    function showImg(img) {
        if (img.files && img.files[0]) {
            var reader = new FileReader();
            if (checkSize(img)) {
                $('#imgLocation').attr('style', 'height:200px;width:auto;margin-bottom: 10px;');

            }
            reader.onload = function (e) {
                $('#imgLocation').attr('src', e.target.result);
            },
                    reader.readAsDataURL(img.files[0]);
        }
    }

    function checkSize() {
        var img = document.getElementById('img');
        var width = img.clientWidth;
        var height = img.clientHeight;
        if (width < height) {
            return false;
        } else {
            return true;
        }
    }
</script>