<%attrs.class = attrs.class ?: ''; attrs.class += ' date'%>
<div class="input-append date">
    <div class="input-group">
        ${raw(thmrz.textField(attrs, body))}
        <span class="input-group-addon add-on"><i class="glyphicon glyphicon-calendar"></i></span>
    </div>
</div>