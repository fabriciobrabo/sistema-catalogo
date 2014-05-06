/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.fcb.venda.rn;

import br.fcb.venda.dao.GenericDAO;
import br.fcb.venda.entidade.Revendedor;
import java.util.List;

/**
 *
 * @author ufrastic
 */
public class RevendedorRN implements InterfaceRN<Revendedor>{

    private GenericDAO<Revendedor> dao = new GenericDAO<Revendedor>();
    
    @Override
    public Revendedor obter(Object id) {
        if (id == null) {
            return null;
        }else{
            return dao.obter(Revendedor.class, id);
        }
    }

    @Override
    public List<Revendedor> obterTodos() {
        return dao.obterTodos(Revendedor.class);
    }

    @Override
    public boolean criar(Revendedor o) {
        if (o.getNome().equals("")) {
            return false;
        }else{
            return dao.criar(o);
        }
    }

    @Override
    public boolean atualizar(Revendedor o) {
           if (o.getNome().equals("")) {
            return false;
        }else{
            return dao.atualizar(o);
        }
    }

    @Override
    public boolean remover(Revendedor o) {
        return dao.excluir(o);
    }
    
}
