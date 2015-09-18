<% attrs.class = attrs.class ?: "btn btn-${attrs.remove('type')} btn-quirk btn-wide mr5" %>
<a class="${attrs.class}" href="${attrs.link}" ${attrs.each {out << "${it.key}=\"${it.value}\""}}>
${raw(value ?: body())}
</a>