<div class="admin_site_center_pages">
    <form method="POST" url="<?php echo baseUrl ?>apanel/insertPage" id="addForm">
        <input type="hidden" name="token" value="pageId" id="pageId" />
        <label for="pageTitle"><h5>Title:</h5></label>
        <input id="pageTitle" type="text" class="form-control admin_editBox_override" name="title" />
        <label for="content"><h5>Content:</h5></label>
        <textarea id="content" name="content"></textarea>
        <label for="desc"><h5>Description:</h5></label>
        <input id="desc" type="text" class="form-control admin_editBox_override" name="desc" />
        <label for="menuName"><h5>Assign Menu:</h5></label>
        <select id="menuName" name="menuName" class="form-control">
            <?php foreach ($menuName as $menu) { ?>
                <option value="<?php echo $menu['id']; ?>"><?php echo $menu['menuName']; ?></option>
            <?php } ?>
        </select>
        <button type="button" class="admin_add_btn" id="addUpdate">
            <i class="glyphicon glyphicon-saved back_btn"></i> Add Page
        </button>
    </form>
    <a href="javascript:void(0);" id="cancelBtn">
        <button class="admin_edit_btn">
            <i class="glyphicon glyphicon-remove back_btn"></i> Cancel
        </button>
    </a>
</div>
<script src="<?php echo baseUrl; ?>ckeditor/ckeditor.js" type="text/javascript"></script>
<script src="<?php echo baseUrl; ?>ckfinder/ckfinder.js" type="text/javascript"></script>
<script type="text/javascript">
    var editor = CKEDITOR.replace('content', {
        filebrowserBrowseUrl: '<?php echo baseUrl; ?>ckfinder/ckfinder.html',
        filebrowserImageBrowseUrl: '<?php echo baseUrl; ?>ckfinder/ckfinder.html?Type=Images',
        filebrowserFlashBrowseUrl: '<?php echo baseUrl; ?>ckfinder/ckfinder.html?Type=Flash',
        filebrowserUploadUrl: '<?php echo baseUrl; ?>ckfinder/core/connector/php/connector.php?command=QuickUpload&type=Files',
        filebrowserImageUploadUrl: '<?php echo baseUrl; ?>ckfinder/core/connector/php/connector.php?command=QuickUpload&type=Images',
        filebrowserFlashUploadUrl: '<?php echo baseUrl; ?>ckfinder/core/connector/php/connector.php?command=QuickUpload&type=Flash'
    });
    CKFinder.setupCKEditor(editor, '<?php echo baseUrl; ?>ckfinder/');


    $(document).ready(function () {
        $("#cancelBtn,#formClose").click(function () {
            hidePanel();

        });
        $("#addUpdate").click(function () {
            postForm('addForm');
        });
    });
</script>