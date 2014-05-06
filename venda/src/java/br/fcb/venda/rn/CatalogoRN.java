/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fcb.venda.rn;

import br.fcb.venda.dao.GenericDAO;
import br.fcb.venda.entidade.Catalogo;
import java.util.List;

/**
 *
 * @author ufrastic
 */
public class CatalogoRN implements InterfaceRN<Catalogo> {

    private GenericDAO<Catalogo> dao = new GenericDAO<Catalogo>();

    @Override
    public Catalogo obter(Object id) {
        if (id == null) {
            return null;
        } else {
            return dao.obter(Catalogo.class, id);
        }
    }

    @Override
    public List<Catalogo> obterTodos() {
        return dao.obterTodos(Catalogo.class);
    }

    @Override
    public boolean criar(Catalogo o) {
        if (o.getNome().equals("") || o.getNome() == null) {
            return false;
        } else {
            return dao.criar(o);
        }
    }

    @Override
    public boolean atualizar(Catalogo o) {
        if (o.getNome().equals("")|| o.getNome() == null) {
            return false;
        }else{
            return dao.atualizar(o);
        }
    }

    @Override
    public boolean remover(Catalogo o) {
        return dao.excluir(o);
    }

}
