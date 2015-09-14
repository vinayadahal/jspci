<div id="flashBox"></div>
<div class="admin_edit_center">
    <div class="panel panel-info" >
        <div class="panel-heading headings">
            <h4 class="panel-title">Available Themes</h4>
        </div>
        <div class="panel-body" style="padding:0 0 3px 0px;height: 213px">
            <?php if (!empty($preview)) { ?>
                <?php $i = 1; ?>
                <?php foreach ($preview as $key => $values) { ?>
                    <div class="sliderPreview">
                        <div class="img" style="background-image:url('<?php echo baseUrl . 'view/theme/' . $key . '/preview.png'; ?>');"></div>
                        <div class="captionImg">
                            <?php echo $key; ?>
                        </div>
                        <div class="overlay">
                            <div style="margin:3px; float:right;">
                                <a style="text-decoration: none;outline: none;" href="javascript:void(0);" onclick="postData('<?php echo baseUrl; ?>apanel/settings/themeSet?apply=1&path=theme/<?php echo $key ?>')">
                                    <i class="glyphicon glyphicon-ok overlayBtn"></i>
                                </a>
        <!--                                <a href="javascript:void(0);" onclick="showConfirm('<?php echo baseUrl ?>apanel/images/deleteSlider?id=<?php echo $images['id'] ?>');">
                                    <i class="glyphicon glyphicon-remove overlayBtn"></i>
                                </a>-->
                            </div>
                        </div>
                    </div>
                    <?php
                }
            }
            ?>
        </div>
    </div>
    <div style="padding: 30px 0px;">
        <img src="<?php echo baseUrl ?>images/adminIcons/warning_shield_grey.png" height="25" width="25">
        Choose theme to match your preference.
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
<script src="<?php echo baseUrl; ?>js/theme.js" type="text/javascript"></script>
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