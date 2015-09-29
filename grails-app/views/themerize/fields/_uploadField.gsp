<div class="input-group">
    <thmrz:textField id="label-${id}" name="nome_${name}" disabled="disabled" />
    <span class="input-group-btn">
        <thmrz:button type="primary btn-file">
            <i class="fa fa-fw fa-folder-open"></i>
            <input ${required ? "required" : ''} type="file" name="${name}" id="${id}" onchange="${extensoes ? "validarExtensaoArquivo${id}(\$(this))" : "processarArquivo${id}(\$(this))"}" >
        </thmrz:button>
    </span>
    <span class="input-group-btn">
        <thmrz:button id="removerSelecao-${id}" class="btn btn-danger" onclick="removerSelecao${id}()" style="display: none"><i class="fa fa-fw fa-trash-o"></i> </thmrz:button>
    </span>
</div>

%{--<thmrz:mensagem id="extensao-mensagem-${id}" titulo="${message(code: 'default.erro.label')}" mensagem="${message(code: 'default.arquivo.extensaoInvalida.message')}" />--}%
<script type="text/javascript">
    function processarArquivo${id}(campo) {
        $('#label-${id}').val(obterNomeArquivo${id}(campo));
        $('#removerSelecao-${id}').show();
    }

    function obterNomeArquivo${id}(campo) {
        return campo.val().split('\\').slice(-1)[0];
    }

    function validarExtensaoArquivo${id}(campo) {
        var nome = obterNomeArquivo${id}(campo);
        var extensao = nome.split('.')[1];
        var arrayExtensoes = '${extensoes}'.toLowerCase().split('|');
        var valido = true;
        if (arrayExtensoes.indexOf(extensao.toLowerCase()) == -1) {
            $('#extensao-mensagem-${id}').modal('show');
            removerSelecao${id}(campo);
            valido = false;
        } else {
            processarArquivo${id}(campo);
        }
        return valido;
    }

    function removerSelecao${id}() {
        var campo = $('\#${id}');
        campo.wrap('<form>').closest('form').get(0).reset();
        campo.unwrap();
        $('#label-${id}').val('');
        $('#removerSelecao-${id}').hide();
    }
</script>