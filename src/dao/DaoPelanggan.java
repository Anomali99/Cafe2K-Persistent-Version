/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import model.Pelanggan;
import servis.ServisPelanggan;

/**
 *
 * @author fatiq
 */
public class DaoPelanggan implements ServisPelanggan {

    @Override
    public void tambahData(Pelanggan mod) {
        EntityManager em = Persistence.createEntityManagerFactory("NewCafe2KPU").createEntityManager();
        em.getTransaction().begin();
        em.persist(mod);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void ubahData(Pelanggan mod) {
        EntityManager em = Persistence.createEntityManagerFactory("NewCafe2KPU").createEntityManager();
        em.getTransaction().begin();
        em.merge(mod);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void hapusData(String id) {
        EntityManager em = Persistence.createEntityManagerFactory("NewCafe2KPU").createEntityManager();
        em.getTransaction().begin();
        Pelanggan mod = em.find(Pelanggan.class, id);
        em.remove(mod);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<Pelanggan> ambilData() {
        EntityManager em = Persistence.createEntityManagerFactory("NewCafe2KPU").createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Pelanggan> query = em.createNamedQuery("Pelanggan.getAll", Pelanggan.class);
        List<Pelanggan> list = query.getResultList();
        em.getTransaction().commit();
        em.close();
        return list;
    }

    @Override
    public List<Pelanggan> getByID(String id) {
        EntityManager em = Persistence.createEntityManagerFactory("NewCafe2KPU").createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Pelanggan> query = em.createNamedQuery("Pelanggan.getByID", Pelanggan.class);
        query.setParameter("idPelanggan", "%" + id + "%");
        List<Pelanggan> list = query.getResultList();
        em.getTransaction().commit();
        em.close();
        return list;
    }

    @Override
    public List<Pelanggan> getByNama(String nama) {
        EntityManager em = Persistence.createEntityManagerFactory("NewCafe2KPU").createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Pelanggan> query = em.createNamedQuery("Pelanggan.getByNama", Pelanggan.class);
        query.setParameter("nama", "%" + nama + "%");
        List<Pelanggan> list = query.getResultList();
        em.getTransaction().commit();
        em.close();
        return list;
    }

    @Override
    public List<Pelanggan> getByAlamat(String alamat) {
        EntityManager em = Persistence.createEntityManagerFactory("NewCafe2KPU").createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Pelanggan> query = em.createNamedQuery("Pelanggan.getByAlamat", Pelanggan.class);
        query.setParameter("alamat", "%" + alamat + "%");
        List<Pelanggan> list = query.getResultList();
        em.getTransaction().commit();
        em.close();
        return list;
    }

    @Override
    public Pelanggan getById(String id) {
        EntityManager em = Persistence.createEntityManagerFactory("NewCafe2KPU").createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Pelanggan> query = em.createNamedQuery("Pelanggan.getById", Pelanggan.class);
        query.setParameter("idPelanggan", id);
        query.setMaxResults(1);
        Pelanggan mod = query.getSingleResult();
        em.getTransaction().commit();
        em.close();
        return mod;
    }

    @Override
    public String getNomer() {
        Date now = new Date();
        SimpleDateFormat tanggal = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat nonformat = new SimpleDateFormat("yyMMdd");
        tanggal.format(now);
        String no = nonformat.format(now);
        try {
            EntityManager em = Persistence.createEntityManagerFactory("NewCafe2KPU").createEntityManager();
            em.getTransaction().begin();
            TypedQuery<String> query = em.createNamedQuery("Pelanggan.getNomer", String.class);
            query.setMaxResults(1);
            String s = query.getSingleResult();
            em.getTransaction().commit();
            em.close();
            return "P" + no + String.format("%03d", Integer.parseInt(s) + 1);
        } catch (NoResultException e) {
            return "P" + no + "001";
        }
    }

}
