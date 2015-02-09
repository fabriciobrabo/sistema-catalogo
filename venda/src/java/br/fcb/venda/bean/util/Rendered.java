/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fcb.venda.bean.util;

import br.fcb.venda.entidade.Usuario;
import br.fcb.venda.spring.Util;

/**
 *
 * @author ufrastic
 */
public class Rendered {

    private boolean temp;
    private Usuario usuario;

    public boolean eRevendedor() {
        usuario = Util.obterUsuarioLogado();
        temp = usuario.getRevendedorList() != null;
        return temp;
    }

    public boolean eMonitor() {
        usuario = Util.obterUsuarioLogado();
        temp = usuario.getMonitorList() != null;
        return temp;
    }

    public boolean eRepresentante() {
        usuario = Util.obterUsuarioLogado();
        temp = usuario.getRepresentanteList() != null;
        return temp;
    }

    public boolean eParceiro() {
        usuario = Util.obterUsuarioLogado();
        temp = usuario.getParceiroList() != null;
        return temp;
    }
}
