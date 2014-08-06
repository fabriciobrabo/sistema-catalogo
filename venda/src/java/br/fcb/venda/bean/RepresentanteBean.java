/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fcb.venda.bean;

import br.fcb.venda.entidade.Representante;
import br.fcb.venda.rn.RepresentanteRN;
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
public class RepresentanteBean {

    private Representante representante = new Representante();
    private final RepresentanteRN rn_representante = new RepresentanteRN();
    private List<Representante> listaRepresentantes;

    public Representante getRepresentante() {
        return representante;
    }

    public void setRepresentante(Representante representante) {
        this.representante = representante;
    }

    public List<Representante> getListaRepresentantes() {
        listaRepresentantes = rn_representante.obterTodosOrdenado();
        return listaRepresentantes;
    }

    public void salvar() {
        boolean limpar = true;
        if (representante.getId() != null) {
            limpar = false;
        }
        try {
            if (rn_representante.salvar(representante)) {
                BeanMessageUtil.criarMensagemDeSucessoSimples(BeanMessageUtil.operacaoRealizada, "");
                if (limpar) {
                    representante = new Representante();
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
            if (rn_representante.remover(representante)) {
                BeanMessageUtil.criarMensagemDeSucessoSimples(BeanMessageUtil.operacaoRealizada, "");
                representante = new Representante();
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
