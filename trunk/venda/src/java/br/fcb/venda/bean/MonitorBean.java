/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fcb.venda.bean;

import br.fcb.venda.entidade.Monitor;
import br.fcb.venda.entidade.Representante;
import br.fcb.venda.rn.MonitorRN;
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
public class MonitorBean {

    private Monitor monitor = new Monitor();
    private final MonitorRN rn_monitor = new MonitorRN();
    private final RepresentanteRN rn_representante = new RepresentanteRN();
    private List<Monitor> listaMonitores;

    public Monitor getMonitor() {
        return monitor;
    }

    public void setCatalogo(Monitor monitor) {
        this.monitor = monitor;
    }

    public List<Monitor> getListaMonitores() {
        listaMonitores = rn_monitor.obterTodosOrdenado();
        return listaMonitores;
    }

    public void salvar() {
        boolean limpar = true;
        if (monitor.getId() != null) {
            limpar = false;
        }
        try {
            if (rn_monitor.salvar(monitor)) {
                BeanMessageUtil.criarMensagemDeSucessoSimples(BeanMessageUtil.operacaoRealizada, "");
                if (limpar) {
                    monitor = new Monitor();
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
            if (rn_monitor.remover(monitor)) {
                BeanMessageUtil.criarMensagemDeSucessoSimples(BeanMessageUtil.operacaoRealizada, "");
                monitor = new Monitor();
            } else {
                BeanMessageUtil.criarMensagemDeAlertaSimples(BeanMessageUtil.falhaAoExlcuir,
                        BeanMessageUtil.erroEmMetodo);
            }
        } catch (Exception e) {
            BeanMessageUtil.criarMensagemDeErroSimples(BeanMessageUtil.erroEmMetodo, BeanMessageUtil.erroEmMetodoMaisMsgDeCatch + e.getMessage());
        }
    }

    public List<Representante> autoCompleteRepresentante(String busca) {
        return rn_representante.autoCompleteRepresentante(busca);
    }

    public String adicionarNovo() {
        return "";
    }

    public String irLista() {
        return "lista.xhtml";
    }
}
