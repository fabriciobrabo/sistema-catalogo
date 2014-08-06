/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fcb.venda.utilitarios;

import br.fcb.venda.entidade.Usuario;
import br.fcb.venda.rn.UsuarioRN;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author ufrastic
 */
public class BeanUtil {

    public static Usuario obterUsuarioLogado() {
        FacesContext f = FacesContext.getCurrentInstance();
        ExternalContext e = f.getExternalContext();
        UsuarioRN rn_usuario = new UsuarioRN();
        return rn_usuario.obter(e.getRemoteUser());
    }
}
