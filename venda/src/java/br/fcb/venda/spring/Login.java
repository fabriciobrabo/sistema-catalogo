/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fcb.venda.spring;

import br.fcb.venda.entidade.Usuario;
import br.fcb.venda.rn.UsuarioRN;
import java.util.ArrayList;
import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 *
 * @author ufrastic
 */
public class Login implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String string) throws UsernameNotFoundException, DataAccessException {
        if (string == null || string.isEmpty()) {
            throw new UsernameNotFoundException(string);
        } else {
            final UsuarioRN rnUsuario = new UsuarioRN();
            Usuario usuarioLogado = rnUsuario.obter(string);
            List<GrantedAuthority> papeis = new ArrayList<GrantedAuthority>();
            if (usuarioLogado != null) {
                papeis.add(new GrantedAuthorityImpl(usuarioLogado.getPerfil()));
                return new User(usuarioLogado.getEmail(),
                        usuarioLogado.getSenha(),
                        true,
                        true,
                        true,
                        true,
                        papeis);
            } else {
                throw new UsernameNotFoundException(string);
            }
        }
    }
}
