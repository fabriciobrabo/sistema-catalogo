/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fcb.venda.dao;

import br.fcb.venda.entidade.Usuario;
import javax.persistence.Query;

/**
 *
 * @author ufrastic
 */
public class UsuarioDAO extends GenericDAO<Usuario> implements InterfaceUsuarioDAO<Usuario> {

    @Override
    public Usuario obter(String acesso) {
        String query = "SELECT u FROM Usuario u WHERE u.email = :acesso OR "
                + "u.emailAlternativo = :acesso OR "
                + "u.username = :acesso";
        Usuario resultado;
        try {
            iniciarTransacao();
            Query q = this.getEntityManager().createQuery(query).setParameter("acesso", acesso);
            resultado = (Usuario) q.getSingleResult();
            confirmarTransacao();

            return resultado;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
