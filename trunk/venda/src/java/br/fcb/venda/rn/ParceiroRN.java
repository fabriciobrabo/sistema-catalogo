/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fcb.venda.rn;

import br.fcb.venda.dao.GenericDAO;
import br.fcb.venda.entidade.Parceiro;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ufrastic
 */
public class ParceiroRN implements InterfaceRN<Parceiro> {

    private GenericDAO<Parceiro> dao = new GenericDAO<Parceiro>();

    @Override
    public Parceiro obter(Object id) {
        if (id == null) {
            return null;
        } else {
            return dao.obter(Parceiro.class, id);
        }
    }

    @Override
    public List<Parceiro> obterTodos() {
        return dao.obterTodos(Parceiro.class);
    }

    @Override
    public boolean salvar(Parceiro o) {
        if (o.getNome().equals("") || o.getSobrenome().equals("")
                || o.getBairro().equals("") || o.getCep().equals("")
                || o.getCidade().equals("")) {
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
    public boolean remover(Parceiro o) {
        return dao.excluir(o);
    }

    public List<Parceiro> obterTodosOrdenado() {
        return dao.obterTodosOrdenado(Parceiro.class, "nome");
    }

    public List<Parceiro> autoCompleteParceiro(String busca) {
        if (busca == null || busca.length() < 3) {
            return null;
        } else {
            List<Parceiro> resposta = new ArrayList<Parceiro>();
            for (Parceiro parceiro : obterTodos()) {
                if (!(parceiro.getNome() + parceiro.getSobrenome()).toUpperCase().contains(busca.toUpperCase())) {
                    //Não encontrou no nome, então tenta pelo cpf
                    if (parceiro.getCpf().toUpperCase().contains(busca.toUpperCase())) {
                        resposta.add(parceiro);
                        break;
                    }
                } else {
                    //Encontrou pelo nome, então adiciona
                    resposta.add(parceiro);
                }
            }
            return resposta;
        }
    }

}
