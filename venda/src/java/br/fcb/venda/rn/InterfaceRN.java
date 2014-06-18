/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.fcb.venda.rn;

import java.util.List;

/**
 *
 * @author ufrastic
 */
public interface InterfaceRN<T> {
    
    public T obter(Object id);
    public List<T> obterTodos();
    public boolean salvar(T o);
    public boolean remover(T o);
}
