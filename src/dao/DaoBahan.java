/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import model.Bahan;
import servis.ServisBahan;

/**
 *
 * @author fatiq
 */
public class DaoBahan implements ServisBahan {

    @Override
    public void tambahData(Bahan mod) {
        EntityManager em = Persistence.createEntityManagerFactory("NewCafe2KPU").createEntityManager();
        em.getTransaction().begin();
        em.persist(mod);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void ubahData(Bahan mod) {
        EntityManager em = Persistence.createEntityManagerFactory("NewCafe2KPU").createEntityManager();
        em.getTransaction().begin();
        em.merge(mod);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void hapusData(String kode) {
        EntityManager em = Persistence.createEntityManagerFactory("NewCafe2KPU").createEntityManager();
        em.getTransaction().begin();
        Bahan mod = em.find(Bahan.class, kode);
        em.remove(mod);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<Bahan> ambilData() {
        EntityManager em = Persistence.createEntityManagerFactory("NewCafe2KPU").createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Bahan> query = em.createNamedQuery("Bahan.getAll", Bahan.class);
        List<Bahan> list = query.getResultList();
        em.getTransaction().commit();
        em.close();
        return list;
    }

    @Override
    public List<Bahan> getByKODE(String kode) {
        EntityManager em = Persistence.createEntityManagerFactory("NewCafe2KPU").createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Bahan> query = em.createNamedQuery("Bahan.getByKODE", Bahan.class);
        query.setParameter("kodeBahan", "%" + kode + "%");
        List<Bahan> list = query.getResultList();
        em.getTransaction().commit();
        em.close();
        return list;
    }

    @Override
    public List<Bahan> getByNama(String nama) {
        EntityManager em = Persistence.createEntityManagerFactory("NewCafe2KPU").createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Bahan> query = em.createNamedQuery("Bahan.getByNama", Bahan.class);
        query.setParameter("nama", "%" + nama + "%");
        List<Bahan> list = query.getResultList();
        em.getTransaction().commit();
        em.close();
        return list;
    }

    @Override
    public Bahan getByKode(String kode) {
        EntityManager em = Persistence.createEntityManagerFactory("NewCafe2KPU").createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Bahan> query = em.createNamedQuery("Bahan.getByKode", Bahan.class);
        query.setParameter("kodeBahan", kode);
        query.setMaxResults(1);
        Bahan mod = query.getSingleResult();
        em.getTransaction().commit();
        em.close();
        return mod;
    }

    @Override
    public String getNomer() {
        try {
            EntityManager em = Persistence.createEntityManagerFactory("NewCafe2KPU").createEntityManager();
            em.getTransaction().begin();
            TypedQuery<String> query = em.createNamedQuery("Bahan.getNomer", String.class);
            query.setMaxResults(1);
            String s = query.getSingleResult();
            em.getTransaction().commit();
            em.close();
            return "BN" + String.format("%03d", Integer.parseInt(s) + 1);
        } catch (NoResultException e) {
            return "BN001";
        }
    }

}
