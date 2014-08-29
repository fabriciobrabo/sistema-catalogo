/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fcb.venda.rn;

import br.fcb.venda.dao.GenericDAO;
import br.fcb.venda.entidade.Produto;
import java.util.List;

/**
 *
 * @author ufrastic
 */
public class ProdutoRN implements InterfaceRN<Produto> {

    private GenericDAO<Produto> dao = new GenericDAO<Produto>();

    @Override
    public Produto obter(Object id) {
        if (id == null) {
            return null;
        } else {
            return dao.obter(Produto.class, id);
        }
    }

    @Override
    public List<Produto> obterTodos() {
        return dao.obterTodos(Produto.class);
    }

    @Override
    public boolean salvar(Produto o) {
        if (o.getCatalogo() == null || o.getCodigo() == null
                || o.getNome() == null || o.getPreco() == null) {
            return false;
        } else {
            if (o.getId() == null) {
                return dao.criar(o);
            } else {
                return dao.atualizar(o);
            }
        }
    }

    @Override
    public boolean remover(Produto o) {
        return dao.excluir(o);
    }

}
