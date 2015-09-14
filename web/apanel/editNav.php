<div class="admin_site_center">
    <form method="POST" url="<?php echo baseUrl ?>apanel/updateNav" id="editForm">
        <input type="hidden" value="<?php echo $editId; ?>" name="editId" id="editId"/>
        <label for="category"><h5>Item Name:</h5></label> <input id="navName" type="text" class="form-control admin_editBox_override" name="navName" value="<?php echo $itemName; ?>"/>
        <label for="description"><h5>Description:</h5></label> <input id="description" type="text" class="form-control admin_editBox_override" name="description" value="<?php echo $desc; ?>"/>
        <button type="button" class="admin_add_btn" id="addUpdate">
            <i class="glyphicon glyphicon-saved back_btn"></i> Update Item
        </button>
    </form>
    <a href="javascript:void(0);" id="cancelBtn">
        <button class="admin_edit_btn">
            <i class="glyphicon glyphicon-remove back_btn"></i> Cancel
        </button>
    </a>
</div>

<div class="popupBackground" id="popupBackground">
    <div class="popupWrap" id="alertPop">
        <div class="titleBar">Alert !!!<span class="closeBtn" id="alertClose"></span></div>
        <div class="popupBox">
            <p id="paragraph"></p>
            <button class="btnPop" id="alertOk">OK</button>
        </div>
    </div>
</div>

<script>
    $(document).ready(function() {
        $("#cancelBtn,#formClose").click(function() {
            hidePanel('addItemPanel');
        });
        $("#addUpdate").click(function() {
            postForm('editForm');
        });
    });
</script>
