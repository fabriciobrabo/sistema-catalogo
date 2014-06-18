/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fcb.venda.rn;

import br.fcb.venda.dao.UsuarioDAO;
import br.fcb.venda.entidade.Usuario;
import java.util.List;

/**
 *
 * @author ufrastic
 */
public class UsuarioRN implements InterfaceRN<Usuario> {

    private UsuarioDAO dao = new UsuarioDAO();

    public Usuario obter(String acesso) {
        return dao.obter(acesso);
    }

    @Override
    public Usuario obter(Object id) {
        if (id == null) {
            return null;
        } else {
            return dao.obter(Usuario.class, id);
        }
    }

    @Override
    public List<Usuario> obterTodos() {
        return dao.obterTodos(Usuario.class);
    }

    @Override
    public boolean salvar(Usuario o) {
        if (o.getEmail().equals("") || o.getUsername().equals("") || o.getSenha().equals("")) {
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
    public boolean remover(Usuario o) {
        return dao.excluir(o);
    }
}
