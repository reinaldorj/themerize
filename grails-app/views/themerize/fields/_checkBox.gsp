<% attrs.class = attrs.class ?: ''; attrs.class += ' checkbox' %>
<div class="form-control">
    ${raw(g.checkBox(attrs, body))}
</div>