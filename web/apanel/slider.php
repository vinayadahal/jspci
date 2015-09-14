<div class="admin_edit_center">
    <!--<h3>Slider Management</h3>-->
    <div class="panel panel-info" >
        <div class="panel-heading headings">
            <h4 class="panel-title">Slider Management</h4>
        </div>
        <div class="panel-body" style="padding:0 0 3px 0px;height: 213px">
            <?php if (!empty($imagePath)) { ?>
                <?php $i = 1; ?>
                <?php foreach ($imagePath as $images) { ?>
                    <div class="sliderPreview">
                        <div class="img" style="background-image:url('<?php echo baseUrl . $images['imgPath']; ?>');"></div>
                        <div class="captionImg">
                            <?php echo $images['caption'] ?>
                        </div>
                        <div class="overlay">
                            <div style="margin:3px; float:right;">
                                <a style="text-decoration: none;outline: none;" href="javascript:void(0);" onclick="showUpdatePanel('<?php echo baseUrl; ?>apanel/images/editSlider?id=<?php echo $images['id']; ?>', 'Publish Image')">
                                    <i class="glyphicon glyphicon-pencil overlayBtn"></i>
                                </a>
                                <a href="javascript:void(0);" onclick="showConfirm('<?php echo baseUrl ?>apanel/images/deleteSlider?id=<?php echo $images['id'] ?>');">
                                    <i class="glyphicon glyphicon-remove overlayBtn"></i>
                                </a>
                            </div>
                        </div>
                    </div>
                <?php } ?>
            <?php } else { ?>
                <div style="margin:90px auto;display: table;">
                    <a id="addImage" href="javascript:void(0);" url="<?php echo baseUrl ?>apanel/images/addSlider">
                        <button class="admin_add_btn" >
                            <i class="glyphicon glyphicon-plus back_btn"></i> Click to add an Image
                        </button>
                    </a>
                </div>
            <?php } ?>
        </div>
    </div>
    <?php if (count($imagePath) < 10) { ?> 
        <a id="addImage" href="javascript:void(0);" url="<?php echo baseUrl ?>apanel/images/addSlider">
            <button class="admin_add_btn" style="float: right;">
                <i class="glyphicon glyphicon-plus back_btn"></i> Add Image
            </button>
        </a>
    <?php } ?>
    <div style="padding: 30px 0px;">
        <img src="<?php echo baseUrl ?>images/adminIcons/warning_shield_grey.png" height="25" width="25">
        Every pictures must be edited by cropping before showing it on user side.
    </div>
</div>
<div class="popupBackground" id="formPanel">
    <div class="panel panel-info popupFormWrap">
        <div class="panel-heading" style="height: 37px;">
            <h4 class="panel-title" id="heading" style="float:left"></h4>
            <span class="closeBtn" id="formClose"></span>
        </div>
        <div class="popupForm" id="formSize">
            <div id="data"></div>
        </div>
    </div>
</div>
<script>
    function checkImage() {
        if ($('#img').val() === '') {
            showAlert('Browse and select a picture.');
            return false;
        } else {
            return true;
        }
    }
    $(document).ready(function () {
        $('#alertClose,#alertOk').click(function () {
            hideAlert();
        });
        $('#confirmYes').click(function () {
            hideConfirm();
            deleteData();
        });
        $('#confirmClose,#confirmNo').click(function () {
            hideConfirm();
        });
        $("#addImage").click(function () {
            showAddPanel('addImage', 'Add Image');
        });
        $("#sliderPreview").mouseover(function () {
            $('#overlay').fadeIn(300);
        });
        $("#sliderPreview").mouseout(function () {
            $('#overlay').fadeOut(300);
        });
    });
</script>