/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fcb.venda.bean;

import br.fcb.venda.entidade.ItemPedido;
import br.fcb.venda.entidade.Pedido;
import br.fcb.venda.rn.PedidoRN;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author ufrastic
 */
@ManagedBean
@RequestScoped
public class PedidoBean {

    private final PedidoRN rn_pedido = new PedidoRN();
    private Pedido pedido = new Pedido();
    private List<Pedido> listaPedidos;
    private ItemPedido itemPedido = new ItemPedido();

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public List<Pedido> getListaPedidos() {
        listaPedidos = rn_pedido.obterTodos();
        return listaPedidos;
    }

    public ItemPedido getItemPedido() {
        return itemPedido;
    }

    public void setItemPedido(ItemPedido itemPedido) {
        this.itemPedido = itemPedido;
    }

    public void adicionarProdutoLista() {
        itemPedido.setPedido(pedido);
        if (pedido.getItemPedidoList() == null) {
            pedido.setItemPedidoList(new ArrayList<ItemPedido>());
        }
        pedido.getItemPedidoList().add(itemPedido);
        itemPedido = new ItemPedido();
    }

    public void removerProdutoLista() {
        rn_pedido.removerProdutoLista(pedido, itemPedido);
    }

}
