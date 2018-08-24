package com.balceda.dao.implementacion;

import com.balceda.dao.interfaces.EntidadDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public abstract class EntidadDaoImpl<T> implements EntidadDAO<T>{

    EntityManagerFactory emf;
    EntityManager em;
    Class<T> objeto;

    public EntidadDaoImpl(Class<T> objeto) {
        emf = Persistence.createEntityManagerFactory("dev_sesion03PU");
        em = emf.createEntityManager();
        this.objeto = objeto;
    }

    @Override
    public void create(T t) {
        em.getTransaction().begin();
        em.persist(t);
        em.getTransaction().commit();
    }

    @Override
    public List<T> findAll() {
        List<T> lista;
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(objeto);
        Root<T> s = cq.from(objeto);
        cq.select(s);
        TypedQuery<T> q = em.createQuery(cq);
        lista = q.getResultList();
        return lista;
    }

    @Override
    public void update(T t) {
        em.getTransaction().begin();
        em.merge(t);
        em.getTransaction().commit();
    }

    @Override
    public void delete(T t) {

        T c = t;
        em.getTransaction().begin();
        if (c != null) {
            em.remove(c);
        }
        em.getTransaction().commit();

    }

    @Override
    public T find(Object id) {
        em.getTransaction().begin();
        T t = em.find(objeto, id);
        em.getTransaction().commit();
        return t;
    }

    public List<T> findRange(int[] range) {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(objeto));
        Query q = em.createQuery(cq);
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int count() {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        Root<T> rt = cq.from(objeto);
        cq.select(em.getCriteriaBuilder().count(rt));
        Query q = em.createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }

}
