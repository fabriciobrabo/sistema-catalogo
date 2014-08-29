/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fcb.venda.rn;

import br.fcb.venda.dao.GenericDAO;
import br.fcb.venda.entidade.Representante;
import java.util.ArrayList;
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
    public boolean salvar(Representante o) {
        if (o.getNome().equals("") || o.getBairro().equals("")
                || o.getCidade().equals("") || o.getEstado().equals("")
                || o.getCpf().equals("") || o.getRg().equals("")
                || o.getEndereco().equals("") || o.getSobrenome().equals("")) {
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
    public boolean remover(Representante o) {
        return dao.excluir(o);
    }

    public List<Representante> obterTodosOrdenado() {
        return dao.obterTodosOrdenado(Representante.class, "nome");
    }
    
    public List<Representante> autoCompleteRepresentante(String busca) {
        if (busca == null || busca.length() < 3) {
            return null;
        } else {
            List<Representante> resposta = new ArrayList<Representante>();
            for (Representante representante : obterTodos()) {
                if (!(representante.getNome() + representante.getSobrenome()).toUpperCase().contains(busca.toUpperCase())) {
                    //Não encontrou no nome, então tenta pelo cpf
                    if (representante.getCpf().toUpperCase().contains(busca.toUpperCase())) {
                        resposta.add(representante);
                        break;
                    }
                } else {
                    //Encontrou pelo nome, então adiciona
                    resposta.add(representante);
                }
            }
            return resposta;
        }
    }
}
