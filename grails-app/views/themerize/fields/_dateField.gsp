<%attrs.class = attrs.class ?: ''; attrs.class += ' date'%>
<div class="input-group">
    ${raw(thmrz.textField(attrs, body))}
    <span class="input-group-addon ui-datepicker-trigger" onclick="$(this).parent().find('input').focus()"><i class="glyphicon glyphicon-calendar"></i></span>
</div>