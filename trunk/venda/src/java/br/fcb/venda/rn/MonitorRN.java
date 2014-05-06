/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fcb.venda.rn;

import br.fcb.venda.dao.GenericDAO;
import br.fcb.venda.entidade.Monitor;
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
    public boolean criar(Monitor o) {
        if (o.getNome().equals("")) {
            return false;
        } else {
            return dao.criar(o);
        }
    }

    @Override
    public boolean atualizar(Monitor o) {
        if (o.getNome().equals("")) {
            return false;
        } else {
            return dao.atualizar(o);
        }
    }

    @Override
    public boolean remover(Monitor o) {
        return dao.excluir(o);
    }

}
