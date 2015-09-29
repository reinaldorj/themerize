<asset:stylesheet src="bootstrap.min.css" />
<asset:stylesheet src="bootstrap-theme.min.css" />
<asset:stylesheet src="bootstrap-datetimepicker.min.css" />
<asset:stylesheet src="font-awesome.min.css" />
<asset:stylesheet src="thmrz.css" />

<asset:javascript src="jquery" />
<asset:javascript src="bootstrap.min" />
<asset:javascript src="bootstrap-datetimepicker.min.js" />
<asset:javascript src="thmrz" />

<script>
    $(document).ready(function() {
        $(".input-append.date").datetimepicker({
            pickTime: false
        });
    });
</script>