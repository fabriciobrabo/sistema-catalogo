/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fcb.venda.rn;

import br.fcb.venda.dao.GenericDAO;
import br.fcb.venda.entidade.Pedido;
import java.util.List;

/**
 *
 * @author ufrastic
 */
public class PedidoRN implements InterfaceRN<Pedido> {

    private GenericDAO<Pedido> dao = new GenericDAO<Pedido>();

    @Override
    public Pedido obter(Object id) {
        if (id == null) {
            return null;
        } else {
            return dao.obter(Pedido.class, id);
        }
    }

    @Override
    public List<Pedido> obterTodos() {
        return dao.obterTodos(Pedido.class);
    }

    @Override
    public boolean salvar(Pedido o) {
        if (o.getRevendedor() == null || o.getRepresentante() == null
                || o.getMonitor() == null || o.getItemPedidoList() == null
                || o.getTotalBruto() == null || o.getTotalLiquido() == null
                || o.getDataCadastrado() == null || o.getDataPedido() == null
                || o.getComicaoMonitor() == null || o.getComicaoRepresentante() == null
                || o.getComicaoRevendedor() == null) {
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
    public boolean remover(Pedido o) {
        return dao.excluir(o);
    }

}
