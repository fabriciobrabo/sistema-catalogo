/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fcb.venda.bean;

import br.fcb.venda.entidade.Produto;
import br.fcb.venda.rn.ProdutoRN;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author ufrastic
 */
@ManagedBean
@RequestScoped
public class ProdutoBean {

    private final ProdutoRN rn_produto = new ProdutoRN();
    private Produto produto = new Produto();
    private List<Produto> listaProduto;

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public List<Produto> getListaProduto() {
        listaProduto = rn_produto.obterTodos();
        return listaProduto;
    }

    public List<Produto> autoCompleteProduto(String busca) {
        return rn_produto.autoCompleteProduto(busca);
    }
}
