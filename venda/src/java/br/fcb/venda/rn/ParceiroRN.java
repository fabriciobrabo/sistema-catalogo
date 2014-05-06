/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.fcb.venda.rn;

import br.fcb.venda.dao.GenericDAO;
import br.fcb.venda.entidade.Parceiro;
import java.util.List;

/**
 *
 * @author ufrastic
 */
public class ParceiroRN implements InterfaceRN<Parceiro>{

    private GenericDAO<Parceiro> dao = new GenericDAO<Parceiro>();
    
    @Override
    public Parceiro obter(Object id) {
        if (id == null) {
            return null;
        }else{
            return dao.obter(Parceiro.class, id);
        }
    }

    @Override
    public List<Parceiro> obterTodos() {
        return dao.obterTodos(Parceiro.class);
    }

    @Override
    public boolean criar(Parceiro o) {
        if (o.getNome().equals("") || o.getSobrenome().equals("") ||
                o.getBairro().equals("") || o.getCep().equals("") ||
                o.getCidade().equals("")) {
            return false;
        }else{
            return dao.criar(o);
        }
    }

    @Override
    public boolean atualizar(Parceiro o) {
        if (o.getNome().equals("")) {
            return false;
        }else{
            return dao.atualizar(o);
        }
    }

    @Override
    public boolean remover(Parceiro o) {
        return dao.excluir(o);
    }
    
}
