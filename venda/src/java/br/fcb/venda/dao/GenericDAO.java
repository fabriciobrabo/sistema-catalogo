/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fcb.venda.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author ufrastic
 */
public class GenericDAO<T> implements InterfaceDAO<T> {

    private EntityManager em = (EntityManager) FabricaEntityManager.obterFabrica().createEntityManager();

    public GenericDAO() {
    }

    @Override
    public boolean criar(T o) {
        try {
            em.getTransaction().begin();
            em.persist(o);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            if (em.isOpen()) {
                em.getTransaction().rollback();
            }
            return false;
        }
    }

    @Override
    public boolean atualizar(T o) {
        try {
            em.getTransaction().begin();
            em.merge(o);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            if (em.isOpen()) {
                em.getTransaction().rollback();
            }
            return false;
        }
    }

    @Override
    public boolean excluir(T o) {
        try {
            em.getTransaction().begin();
            em.remove(o);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            if (em.isOpen()) {
                em.getTransaction().rollback();
            }
            return false;
        }
    }

    @Override
    public T obter(Class<T> classe, Object id) {
        if (id == null) {
            return null;
        }
        try {
            em.getTransaction().begin();
            String query = classe.getSimpleName() + ".findById";
            final Query q = em.createNamedQuery(query);
            T t = (T) q.setParameter("id", id).getSingleResult();
            em.getTransaction().commit();
            return t;
        } catch (Exception e) {
            if (em.isOpen()) {
                em.getTransaction().rollback();
            }
            return null;
        }
    }

    @Override
    public List<T> obterTodos(Class<T> classe) {
        List<T> resposta = null;
        try {
            em.getTransaction().begin();
            String query = classe.getSimpleName() + ".findAll";
            Query q = em.createNamedQuery(query);
            resposta = (List<T>) q.getResultList();
            em.getTransaction().commit();
            return resposta;
        } catch (Exception e) {
            if (em.isOpen()) {
                em.getTransaction().rollback();
            }
            return resposta;
        }
    }

}
