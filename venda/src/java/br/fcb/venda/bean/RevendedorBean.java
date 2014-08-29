/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fcb.venda.bean;

import br.fcb.venda.entidade.Monitor;
import br.fcb.venda.entidade.Revendedor;
import br.fcb.venda.rn.MonitorRN;
import br.fcb.venda.rn.RevendedorRN;
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
public class RevendedorBean {

    private Revendedor revendedor = new Revendedor();
    private final RevendedorRN rn_revendedor = new RevendedorRN();
    private final MonitorRN rn_monitor = new MonitorRN();
    private List<Revendedor> listaRevendedores;

    public Revendedor getRevendedor() {
        return revendedor;
    }

    public void setRevendedor(Revendedor revendedor) {
        this.revendedor = revendedor;
    }

    public List<Revendedor> getListaRevendedores() {
        listaRevendedores = rn_revendedor.obterTodosOrdenado();
        return listaRevendedores;
    }

    public void salvar() {
        boolean limpar = true;
        if (revendedor.getId() != null) {
            limpar = false;
        }
        try {
            if (rn_revendedor.salvar(revendedor)) {
                BeanMessageUtil.criarMensagemDeSucessoSimples(BeanMessageUtil.operacaoRealizada, "");
                if (limpar) {
                    revendedor = new Revendedor();
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
            if (rn_revendedor.remover(revendedor)) {
                BeanMessageUtil.criarMensagemDeSucessoSimples(BeanMessageUtil.operacaoRealizada, "");
                revendedor = new Revendedor();
            } else {
                BeanMessageUtil.criarMensagemDeAlertaSimples(BeanMessageUtil.falhaAoExlcuir,
                        BeanMessageUtil.erroEmMetodo);
            }
        } catch (Exception e) {
            BeanMessageUtil.criarMensagemDeErroSimples(BeanMessageUtil.erroEmMetodo, BeanMessageUtil.erroEmMetodoMaisMsgDeCatch + e.getMessage());
        }
    }
    
    public List<Monitor> autoCompleteMonitor(String busca){
        return rn_monitor.autoCompleteMonitor(busca);
    }

    public String adicionarNovo() {
        return "";
    }

    public String irLista() {
        return "lista.xhtml";
    }
}
