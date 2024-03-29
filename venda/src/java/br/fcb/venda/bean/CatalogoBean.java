/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fcb.venda.bean;

import br.fcb.venda.entidade.Catalogo;
import br.fcb.venda.rn.CatalogoRN;
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
public class CatalogoBean {

    private Catalogo catalogo = new Catalogo();
    private final CatalogoRN rn_catalogo = new CatalogoRN();
    private List<Catalogo> listaCatalogos;

    public Catalogo getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(Catalogo catalogo) {
        this.catalogo = catalogo;
    }

    public List<Catalogo> getListaCatalogos() {
        listaCatalogos = rn_catalogo.obterTodosOrdenado();
        return listaCatalogos;
    }

    public void salvar() {
        boolean limpar = true;
        if (catalogo.getId() != null) {
            limpar = false;
        }
        try {
            if (rn_catalogo.salvar(catalogo)) {
                BeanMessageUtil.criarMensagemDeSucessoSimples(BeanMessageUtil.operacaoRealizada, "");
                if (limpar) {
                    catalogo = new Catalogo();
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
            if (rn_catalogo.remover(catalogo)) {
                BeanMessageUtil.criarMensagemDeSucessoSimples(BeanMessageUtil.operacaoRealizada, "");
                catalogo = new Catalogo();
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
