<g:if test="${flash.message}">
    <div class="alert alert-success" role="status">${flash.message}</div>
</g:if>
<g:hasErrors bean="${bean}">
    <ul class="alert alert-danger" role="alert">
        <g:eachError bean="${bean}" var="error">
            <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message
                    error="${error}"/></li>
        </g:eachError>
    </ul>
</g:hasErrors>