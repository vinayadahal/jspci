<div class="admin_site_center_pages">
    <form method="POST" url="<?php echo baseUrl ?>apanel/updatePage" id="editForm">
        <input type="hidden" name="contentId" value="<?php echo $editId; ?>" id="editId" />
        <label for="pageTitle"><h5>Title:</h5></label>
        <input id="pageTitle" type="text" class="form-control admin_editBox_override" name="title" value="<?php echo $title; ?>" />
        <label for="content"><h5>Content:</h5></label>
        <textarea id="content" name="content"><?php echo $content; ?></textarea>
        <label for="desc"><h5>Description:</h5></label>
        <input id="desc" type="text" class="form-control admin_editBox_override" name="desc" value="<?php echo $desc; ?>"/>
        <label for="menuName"><h5>Assigned Menu:</h5></label>
        <select id="menuName" name="menuName" class="form-control">
            <?php
            foreach ($allMenu as $menu) {
                if ($menu['id'] == $editMenuId) {
                    ?>
                    <option value="<?php echo $menu['id']; ?>" selected="selected"><?php echo $menu['menuName']; ?></option>
                    <?php
                } else {
                    ?>
                    <option value="<?php echo $menu['id']; ?>"><?php echo $menu['menuName']; ?></option>
                    <?php
                }
            }
            ?>
        </select>
        <button type="button" class="admin_add_btn" id="addUpdate">
            <i class="glyphicon glyphicon-saved back_btn"></i> Update Page
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
            hidePanel('addItemPanel');
        });
        $("#addUpdate").click(function () {
            postForm('editForm');
        });
    });
</script>