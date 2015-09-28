<%
    attrs.class = attrs.class ?: ''
    attrs.class += ' form-control'
%>
<div>
    ${raw(g.textArea(attrs, body))}
</div>