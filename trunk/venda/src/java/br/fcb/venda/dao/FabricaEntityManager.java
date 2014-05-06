/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.fcb.venda.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


/**
 *
 * @author ufrastic
 */
public class FabricaEntityManager {
    
    private static EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("vendaPU");
    
    private FabricaEntityManager() {
    }

    public static EntityManagerFactory obterFabrica() {
        return fabrica;
    }

    public static EntityManagerFactory obterFabrica(String unidadePersistencia) {
        if (fabrica != null && fabrica.isOpen()) {
            fabrica.close();
        }
        fabrica = Persistence.createEntityManagerFactory(unidadePersistencia);
        return fabrica;
    }
}