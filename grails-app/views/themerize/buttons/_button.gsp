<% attrs.class = attrs.class ?: "btn btn-${attrs.remove('type')}" %>

<button type="button" ${attrs.each {out << raw("${it.key}=\"${it.value}\" ")}}>${raw(body())}</button>