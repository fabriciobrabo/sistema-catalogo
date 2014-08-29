/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fcb.venda.bean;

import br.fcb.venda.entidade.Parceiro;
import br.fcb.venda.rn.ParceiroRN;
import br.fcb.venda.utilitarios.BeanMessageUtil;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author ufrastic
 */
@ManagedBean
@RequestScoped
public class ParceiroBean {

    private Parceiro parceiro = new Parceiro();
    private final ParceiroRN rn_parceiro = new ParceiroRN();
    private List<Parceiro> listaParceiros;

    public Parceiro getParceiro() {
        return parceiro;
    }

    public void setParceiro(Parceiro parceiro) {
        this.parceiro = parceiro;
    }

    public List<Parceiro> getListaParceiros() {
        listaParceiros = rn_parceiro.obterTodosOrdenado();
        return listaParceiros;
    }

    public void salvar() {
        boolean limpar = true;
        if (parceiro.getId() != null) {
            limpar = false;
        }
        try {
            if (rn_parceiro.salvar(parceiro)) {
                BeanMessageUtil.criarMensagemDeSucessoSimples(BeanMessageUtil.operacaoRealizada, "");
                if (limpar) {
                    parceiro = new Parceiro();
                }
            } else {
                BeanMessageUtil.criarMensagemDeAlertaSimples(BeanMessageUtil.falhaAoSalvar,
                        BeanMessageUtil.falhaAoSalvarVerificarParametros);
            }
        } catch (Exception e) {
            BeanMessageUtil.criarMensagemDeErroSimples(BeanMessageUtil.erroEmMetodo, BeanMessageUtil.erroEmMetodoMaisMsgDeCatch + e.getMessage());
        }
    }

    public String editar() {
        return "editar.xhtml";
    }

    public void excluir() {
        try {
            if (rn_parceiro.remover(parceiro)) {
                BeanMessageUtil.criarMensagemDeSucessoSimples(BeanMessageUtil.operacaoRealizada, "");
                parceiro = new Parceiro();
            } else {
                BeanMessageUtil.criarMensagemDeAlertaSimples(BeanMessageUtil.falhaAoExlcuir,
                        BeanMessageUtil.erroEmMetodo);
            }
        } catch (Exception e) {
            BeanMessageUtil.criarMensagemDeErroSimples(BeanMessageUtil.erroEmMetodo, BeanMessageUtil.erroEmMetodoMaisMsgDeCatch + e.getMessage());
        }
    }

    public String adicionarNovo() {
        return "";
    }

    public String irLista() {
        return "lista.xhtml";
    }
}
