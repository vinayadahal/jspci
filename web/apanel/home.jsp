<div class="admin_site">
    <div class="panel pane_overide">
        <div class="panel das_icon"><a href="<?php echo baseUrl ?>apanel/menu"><img src="<?php echo baseUrl; ?>images/adminIcons/menu.png" width="128" height="128" />Menu</a></div>
        <div class="panel das_icon"><a href="<?php echo baseUrl ?>apanel/pages"><img src="<?php echo baseUrl; ?>images/adminIcons/pages.png" width="128" height="128" />Pages</a></div>
        <div class="panel das_icon"><a href="<?php echo baseUrl ?>apanel/images"><img src="<?php echo baseUrl; ?>images/adminIcons/images.png" width="128" height="128" />Images</a></div>
        <div class="panel das_icon"><a href="<?php echo baseUrl ?>apanel/settings"><img src="<?php echo baseUrl; ?>images/adminIcons/settings.png" width="128" height="128" />Settings</a></div>
    </div>
</div>

<script>
    $(document).ready(function() {
        $('#contentIcon').click(function(e) {
            showAlert('Please add menu items before going to this category.');
            e.preventDefault();
        });
        $('#alertClose,#alertOk').click(function() {
            hideAlert();
        });
    });
</script>