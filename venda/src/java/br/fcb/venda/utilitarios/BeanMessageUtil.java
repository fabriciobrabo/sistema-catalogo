/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fcb.venda.utilitarios;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author ufrastic
 */
public class BeanMessageUtil {

    public static final String operacaoRealizada = "Operação Realizada!";
    public static final String falhaAoExlcuir = "Falha ao Excluir!";
    public static final String falhaAoSalvar = "Falha ao Salvar!";
    public static final String falhaAoSalvarVerificarParametros = "Verifique se todos parâmetros foram passados corretamente.";
    public static final String erroEmMetodo = "Erro Inesperado!";
    public static final String erroEmMetodoMaisMsgDeCatch = "Desculpe o transtorno, "
            + "estaremos verificando as possíveis causas de erro.\n\n\n"
            + "Causa do Erro: ";

    public static void criarMensagemDeSucessoSimples(String resumo, String detalhe) {
        criarMensagem(FacesMessage.SEVERITY_INFO, resumo, detalhe);
    }

    public static void criarMensagemDeErroSimples(String resumo, String detalhe) {
        criarMensagem(FacesMessage.SEVERITY_ERROR, resumo, detalhe);
    }

    public static void criarMensagemDeAlertaSimples(String resumo, String detalhe) {
        criarMensagem(FacesMessage.SEVERITY_ERROR, resumo, detalhe);
    }

    public static void criarMensagemDeAviso(String resumo, String detalhe) {
        criarMensagem(null, resumo, detalhe);
    }

    public static void criarMensagem(FacesMessage.Severity tipo, String resumo, String detalhe) {
        FacesContext currentInstance = FacesContext.getCurrentInstance();
        FacesMessage fm = new FacesMessage(resumo, detalhe);
        fm.setSeverity(tipo);
        currentInstance.addMessage(null, fm);
    }
}
