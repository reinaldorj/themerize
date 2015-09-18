<g:set var="toggleId" value="toggle-${attrs.id}" />
<g:set var="on" value="${attrs.value ? 'true' : 'false'}" />
<g:set var="estilo" value="${attrs.estilo ?: 'primary'}" />
<% attrs.style = 'display: none' %>
<div class="toggle-wrapper">
    <div id="${toggleId}" class="toggle toggle-modern ${estilo}"></div>
    ${raw(g.checkBox(attrs, body))}
    <script>$('\#${toggleId}').toggles({height: 26, checkbox: '\#${attrs.id}', on: ${on}});</script>
</div>