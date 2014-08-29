/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fcb.venda.rn;

import br.fcb.venda.dao.GenericDAO;
import br.fcb.venda.entidade.Monitor;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ufrastic
 */
public class MonitorRN implements InterfaceRN<Monitor> {

    private GenericDAO<Monitor> dao = new GenericDAO<Monitor>();

    @Override
    public Monitor obter(Object id) {
        if (id == null) {
            return null;
        } else {
            return dao.obter(Monitor.class, id);
        }
    }

    @Override
    public List<Monitor> obterTodos() {
        return dao.obterTodos(Monitor.class);
    }

    @Override
    public boolean salvar(Monitor o) {
        if (o.getNome().equals("")) {
            return false;
        } else {
            if (o.getId() == null) {
            return dao.criar(o);
            }else{
                return dao.atualizar(o);
            }
        }
    }

    @Override
    public boolean remover(Monitor o) {
        return dao.excluir(o);
    }
    
    public List< Monitor> obterTodosOrdenado() {
        return dao.obterTodosOrdenado(Monitor.class, "nome");
    }
    
    public List<Monitor> autoCompleteMonitor(String busca) {
        if (busca == null || busca.length() < 3) {
            return null;
        } else {
            List<Monitor> resposta = new ArrayList<Monitor>();
            for (Monitor monitor : obterTodos()) {
                if (!(monitor.getNome() + monitor.getSobrenome()).toUpperCase().contains(busca.toUpperCase())) {
                    //Não encontrou no nome, então tenta pelo cpf
                    if (monitor.getCpf().toUpperCase().contains(busca.toUpperCase())) {
                        resposta.add(monitor);
                        break;
                    }
                } else {
                    //Encontrou pelo nome, então adiciona
                    resposta.add(monitor);
                }
            }
            return resposta;
        }
    }

}
