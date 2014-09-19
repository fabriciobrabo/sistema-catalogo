/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fcb.venda.rn;

import br.fcb.venda.dao.GenericDAO;
import br.fcb.venda.entidade.Revendedor;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ufrastic
 */
public class RevendedorRN implements InterfaceRN<Revendedor> {

    private GenericDAO<Revendedor> dao = new GenericDAO<Revendedor>();

    @Override
    public Revendedor obter(Object id) {
        if (id == null) {
            return null;
        } else {
            return dao.obter(Revendedor.class, id);
        }
    }

    @Override
    public List<Revendedor> obterTodos() {
        return dao.obterTodos(Revendedor.class);
    }

    @Override
    public boolean salvar(Revendedor o) {
        if (o.getNome().equals("")) {
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
    public boolean remover(Revendedor o) {
        return dao.excluir(o);
    }

    public List<Revendedor> obterTodosOrdenado() {
        return dao.obterTodosOrdenado(Revendedor.class, "nome");
    }

    public List<Revendedor> autoCompleteRevendedor(String busca) {
        if (busca == null || busca.length() < 3) {
            return null;
        } else {
            List<Revendedor> resposta = new ArrayList<Revendedor>();
            for (Revendedor revendedor : obterTodos()) {
                if (!(revendedor.getNome() + revendedor.getSobrenome()).toUpperCase().contains(busca.toUpperCase())) {
                    //Não encontrou pelo nome do produto, então tenta pelo cpf
                    if (revendedor.getCpf().toUpperCase().contains(busca.toUpperCase())) {
                        resposta.add(revendedor);
                        break;
                    }
                } else {
                    //Encontrou pelo nome, então adiciona
                    resposta.add(revendedor);
                }
            }
            return resposta;
        }
    }

}
