package model;

import org.apache.commons.mail.HtmlEmail;

import java.net.URL;

public class Email {

    private String hostName;
    private String de;
    private String para;
    private String assunto;
    private String url;
    private int port;
    private String htmlMsg;
    private String textMsg;
    private String Autenticacao;

    public Email() {
    }

    public Email(String hostName, String de, String para, String assunto, String url, int port, String htmlMsg, String textMsg, String autenticacao) {
        this.hostName = hostName;
        this.de = de;
        this.para = para;
        this.assunto = assunto;
        this.url = url;
        this.port = port;
        this.htmlMsg = htmlMsg;
        this.textMsg = textMsg;
        Autenticacao = autenticacao;
    }

    public String hostName() {
        return hostName;
    }

    public Email hostName(String hostName) {
        this.hostName = hostName;
        return this;
    }

    public String de() {
        return de;
    }

    public Email de(String de) {
        this.de = de;
        return this;
    }

    public String para() {
        return para;
    }

    public Email para(String para) {
        this.para = para;
        return this;
    }

    public String assunto() {
        return assunto;
    }

    public Email assunto(String assunto) {
        this.assunto = assunto;
        return this;
    }

    public String url() {
        return url;
    }

    public Email url(String url) {
        this.url = url;
        return this;
    }

    public int port() {
        return port;
    }

    public Email port(int port) {
        this.port = port;
        return this;
    }

    public String htmlMsg() {
        return htmlMsg;
    }

    public Email htmlMsg(String htmlMsg) {
        this.htmlMsg = htmlMsg;
        return this;
    }

    public String textMsg() {
        return textMsg;
    }

    public Email textMsg(String textMsg) {
        this.textMsg = textMsg;
        return this;
    }

    public String autenticacao() {
        return Autenticacao;
    }

    public Email autenticacao(String autenticacao) {
        Autenticacao = autenticacao;
        return this;
    }
}
