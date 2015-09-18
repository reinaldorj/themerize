<%
    attrs.class = attrs.class ?: ''
    attrs.class += ' form-control'
    def maxlength = attrs.maxlength?.toLong()
    String value = attrs.value
%>
<div>
    ${raw(g.textArea(attrs, body))}
    <g:if test="${maxlength}">
        <p>${message(code: 'default.caracteresRestantes.label')}<span>${value ? maxlength - value.size() : maxlength}</span></p>
    </g:if>
</div>