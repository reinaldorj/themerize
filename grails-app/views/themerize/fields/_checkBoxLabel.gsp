<div class="form-group">
    <label class="col-sm-3 control-label">${label ?: ''} <g:if test="${attrs.required}"><span class="text-danger">*</span></g:if></label>
    <div class="col-sm-8">
        ${raw(thmrz.checkBox(attrs, body))}
    </div>
</div>