<% if (attrs['class'].contains('asc') || attrs['class'].contains('desc')) {attrs['class'] = attrs['class'].replace('asc', 'sorting_asc').replace('desc', 'sorting_desc') } else {  attrs['class'] = "${attrs['class']} sorting" }; %>
<th onclick="document.location = '${raw(link)}'" ${attrs.each {out << raw("${it.key}=\"${it.value}\"")}}>
    ${title}
</th>