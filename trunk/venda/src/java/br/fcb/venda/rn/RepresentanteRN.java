/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fcb.venda.rn;

import br.fcb.venda.dao.GenericDAO;
import br.fcb.venda.entidade.Representante;
import java.util.List;

/**
 *
 * @author ufrastic
 */
public class RepresentanteRN implements InterfaceRN<Representante> {

    private GenericDAO<Representante> dao = new GenericDAO<Representante>();

    @Override
    public Representante obter(Object id) {
        if (id == null) {
            return null;
        } else {
            return dao.obter(Representante.class, id);
        }
    }

    @Override
    public List<Representante> obterTodos() {
        return dao.obterTodos(Representante.class);
    }

    @Override
    public boolean criar(Representante o) {
        if (o.getNome().equals("")) {
            return false;
        }else{
            return dao.criar(o);
        }
    }

    @Override
    public boolean atualizar(Representante o) {
        if (o.getNome().equals("")) {
            return false;
        }else{
            return dao.atualizar(o);
        }
    }

    @Override
    public boolean remover(Representante o) {
        return dao.excluir(o);
    }

}
