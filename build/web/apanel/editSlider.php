<div class="admin_edit_center">
    <div class="imageEditPanel">
        <img src="<?php echo baseUrl . $imgPath; ?>" id="cropbox" style="width: 700px;" />
    </div>
    <h4>Tips:</h4>
    <ol>
        <li>Click on the image.</li>
        <li>Adjust the selection box UP or DOWN.</li>
        <li>Click on <b>Crop & Save</b>.</li>
    </ol>
    <h4>Trouble cropping?</h4>
    Try resizing image before uploading.
    <form url="<?php echo baseUrl ?>apanel/images/updateSlider" method="post" onsubmit="return;" id="editForm">
        <input type="hidden" name="imgPath" id="imgPath" value="<?php echo rootDir . '/' . $imgPath; ?>" />
        <input type="hidden" name="imgId" id="imgId" value="<?php echo $id; ?>"/>
        <input type="hidden" id="x" name="x" />
        <input type="hidden" id="y" name="y" />
        <input type="hidden" id="w" name="w" />
        <input type="hidden" id="h" name="h" />
        <label for="caption"><h5>Caption:</h5></label><input type="text" id="caption" name="caption" value="<?php echo $caption; ?>" class="form-control admin_editBox_override" style="width: 250px;"/>
        <button type="button" class="admin_add_btn" id="addUpdate">
            <i class="glyphicon glyphicon-save back_btn"></i> Save
        </button>
    </form>
</div>

<script type="text/javascript">
    $(function() {
        $('#cropbox').Jcrop({
            aspectRatio: 0,
            onSelect: updateCoords,
            minSize: [700, 350],
            maxSize: [700, 350]
        });
        imageSize();
        $("#cancelBtn,#formClose").click(function() {
            hidePanel('addItemPanel');
        });
        $("#addUpdate").click(function() {
            if (checkCoords()) {
                postForm('editForm');
            }
        });
    });
    function updateCoords(c) {
        $('#x').val(c.x);
        $('#y').val(c.y);
        $('#w').val(c.w);
        $('#h').val(c.h);
    }
    function checkCoords() {
        if (parseInt($('#w').val())) {
            return true;
        } else {
            alert('Please select a crop region then press save.');
            return false;
        }
    }
    function imageSize() {
        var height = $('#cropbox').height();
        if (height >= 500) {
            $('#footerAdmin').attr('class', 'footerNormal');
        } else {
            $('#footerAdmin').attr('class', 'navbar navbar-default navbar-fixed-bottom');
        }
    }
</script>
