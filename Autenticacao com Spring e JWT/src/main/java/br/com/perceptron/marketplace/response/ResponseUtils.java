package br.com.perceptron.marketplace.response;

import br.com.perceptron.marketplace.categoria.Categoria;
import br.com.perceptron.marketplace.cliente.Cliente;
import br.com.perceptron.marketplace.endereco.Endereco;
import br.com.perceptron.marketplace.produto.Produto;
import br.com.perceptron.marketplace.usuario.Usuario;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public abstract class ResponseUtils {

    public static final String CATEGORIA = Categoria.class.getSimpleName() + "(s)";
    public static final String PRODUTO = Produto.class.getSimpleName() + "(s)";
    public static final String ENDERECO = Endereco.class.getSimpleName() + "(s)";
    public static final String USUARIO = Usuario.class.getSimpleName() + "(s)";
    public static final String CLIENTE = Cliente.class.getSimpleName() + "(s)";

    public static final HttpStatus $200 = HttpStatus.OK;
    public static final HttpStatus $201 = HttpStatus.CREATED;
    public static final HttpStatus $204 = HttpStatus.NO_CONTENT;
    public static final HttpStatus $302 = HttpStatus.FOUND;
    public static final HttpStatus $304 = HttpStatus.NOT_MODIFIED;
    public static final HttpStatus $400 = HttpStatus.BAD_REQUEST;
    public static final HttpStatus $401 = HttpStatus.UNAUTHORIZED;
    public static final HttpStatus $402 = HttpStatus.PAYMENT_REQUIRED;
    public static final HttpStatus $403 = HttpStatus.FORBIDDEN;
    public static final HttpStatus $404 = HttpStatus.NOT_FOUND;
    public static final HttpStatus $405 = HttpStatus.METHOD_NOT_ALLOWED;
    public static final HttpStatus $500 = HttpStatus.INTERNAL_SERVER_ERROR;
    public static final HttpStatus $501 = HttpStatus.NOT_IMPLEMENTED;
    public static final HttpStatus $503 = HttpStatus.SERVICE_UNAVAILABLE;


    public static final String MSG_RETORNO = ", por favor verifique e tente novamente";
    public static final String VALITATION_ERRORS = "Alguns campos não foram preenchidos corretamente" + MSG_RETORNO;

    public static final String BUSCA_OK = "Busca realizada com sucesso";
    public static final String BUSCA_NOK = "Não foi possivel concluir a busca solicitada.";
    public static final String ENCONTRADO = " encontrado(a).";
    public static final String NAO_ENCONTRADO = " não encontrado(a)" + MSG_RETORNO;
    public static final String DELETADO = "Objeto deletado com sucesso.";
    public static final String ERRO = "Ocorreu um erro ao realizar a operacao solicitada.";
    public static final String SALVO = " salvo(a) com sucesso.";
    public static final String NAO_SALVO = "Não foi possivel salvar/editar objeto(a)";
    public static final String USUARIO_JA_EXISTE = "Username já existe" + MSG_RETORNO;
    public static final String CREDENCIAIS_INVALIDAS = "Username e password estão incorretos" + MSG_RETORNO;
    public static final String OBJETO_NAO_ENCONTRADO = "Objeto não encontrado(a)" + MSG_RETORNO;
    public static final String OBJETO_DELETADO = "Objeto removido com sucesso.";
    public static final String OBJETO_SALVO_COM_SUCESSO = "Objeto salvo com sucesso.";

    public static final String EMAIL_NAO_ENVIADO = "Não foi possivel enviar email";
    public static final String ENVIO_DE_EMAIL_DESABILITADO = "Envio de email desabilitado";
    public static final String OBJETO_NULO = "Objeto(s) nulo" + MSG_RETORNO;
    public static final String OBJETO_POSSUI_RELACIONAMENTOS = "Objeto possui relacionamento de dependência com outros objetos, ação não concluida";

    public static final String SAVE_OR_UPDATE = "saveOrUpdate";
    public static final String NAO_PREENCHIDO = "Não foi preenchido" + MSG_RETORNO;
    public static final String DELETE_BY_ID = "deleteById";


    public static String searchOk(MessageSource m) {
        return getMessageSource(m, "search.ok");
    }

    public static String objectNotFound(MessageSource m) {
        return getMessageSource(m, "object.not.found");
    }

    public static String userNotFound(MessageSource m) {
        return getMessageSource(m, "user.not.found");
    }

    public static String refreshTokenMessage(MessageSource m) {
        return getMessageSource(m, "token.refresh");
    }

    public static String objectNotSave(MessageSource m) {
        return getMessageSource(m, "not.save");
    }

    public static String objectAlreadyExists(MessageSource m) {
        return getMessageSource(m, "object.already.exists");
    }

    public static String acceptLanguage(MessageSource m) {
        return getMessageSource(m, "accept.language");
    }

    public static String objectSaved(MessageSource m) {
        return getMessageSource(m, "save");
    }

    public static String notPermission(MessageSource m) {
        return getMessageSource(m, getMessageSource(m, "not.permission"));
    }

    public static String sendNewPasswordByEmail(MessageSource m) {
        return getMessageSource(m, "send.new.email");
    }

    public static String objectWithRelationship(MessageSource m) {
        return getMessageSource(m, "object.with.relationship");
    }

    public static String objectRemoved(MessageSource m) {
        return getMessageSource(m, "object.removed");
    }

    public static String titleValidation(MessageSource m) {
        return getMessageSource(m, "title.validation");
    }


    private static String getMessageSource(MessageSource m, String message) {
        return m.getMessage(message, null, LocaleContextHolder.getLocale());
    }
}
