<%attrs.class = attrs.class ?: ''; attrs.class += ' date'%>
<div class="input-group">
    ${raw(thmrz.textField(attrs, body))}
    <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
</div>