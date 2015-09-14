<div class="admin_edit_center">
    <div class="panel panel-info">
        <div class="panel-heading headings">
            <h4 class="panel-title">Navigation Bar</h4>
        </div>
        <table class="table table-hover table_override_content">
            <tr>
                <th width="20">S.No.</th>
                <th>Menu Item</th>
                <th>Description</th>
                <th colspan="2" style="text-align: center">Action</th>
            </tr>
            <?php
            if (!empty($getInfo)) {
                $i = 1;
                foreach ($getInfo as $info) {
                    ?>
                    <tr>
                        <td><a href="<?php echo baseUrl ?>apanel/editNav?id=<?php echo $info['id']; ?>"><?php echo $i++; ?></a></td>
                        <td><a href="<?php echo baseUrl ?>apanel/editNav?id=<?php echo $info['id']; ?>"><?php echo ucfirst($info['menuName']); ?></a></td>
                        <td><?php echo $info['desc']; ?></td>
                        <td width="10">
                            <a href="javascript:void(0);" title="Edit" onclick="showUpdatePanel('<?php echo baseUrl ?>apanel/editNav?id=<?php echo $info['id']; ?>', 'Edit Menu');">
                                <i class="glyphicon glyphicon-pencil glyphicon_list_override"></i>
                            </a>
                        </td>
                        <td width="10">
                            <a onclick="showConfirm('<?php echo baseUrl ?>apanel/deleteNav?id=<?php echo $info['id'] ?>');" title="Delete" href="javascript:void(0);">
                                <i class="glyphicon glyphicon-remove glyphicon_delete_override"></i>
                            </a>
                        </td>
                    </tr>
                    <?php
                }
            }
            ?>
        </table>
        <a href="javascript:void(0);" url="<?php echo baseUrl ?>apanel/addNav" id="addItem">
            <button class="admin_add_btn">
                <i class="glyphicon glyphicon-plus back_btn"></i> Add Menu
            </button>
        </a>
        <a href="<?php echo baseUrl ?>apanel/menu">
            <button class="admin_edit_btn">
                <i class="glyphicon glyphicon-arrow-left back_btn"></i> Back
            </button>
        </a>
    </div>
</div>

<div class="popupBackground" id="formPanel">
    <div class="panel panel-info popupFormWrap">
        <div class="panel-heading" style="height: 37px;">
            <h4 class="panel-title" id="heading" style="float:left"></h4>
            <span class="closeBtn" id="formClose"></span>
        </div>
        <div class="popupForm">
            <div id="data"></div>
        </div>
    </div>
</div>

<script>
    $(document).ready(function() {
        $('#confirmYes').click(function() {
            hideConfirm();
            deleteData();
        });
        $('#confirmClose,#confirmNo').click(function() {
            hideConfirm();
        });
        $("#addItem").click(function() {
            showAddPanel('addItem', 'Add Menu');
        });
    });
</script>