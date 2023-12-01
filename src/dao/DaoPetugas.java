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
import model.Pegawai;
import servis.ServisPetugas;

/**
 *
 * @author fatiq
 */
public class DaoPetugas implements ServisPetugas {

    @Override
    public void tambahData(Pegawai mod) {
        EntityManager em = Persistence.createEntityManagerFactory("NewCafe2KPU").createEntityManager();
        em.getTransaction().begin();
        em.persist(mod);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void ubahData(Pegawai mod) {
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
        Pegawai mod = em.find(Pegawai.class, id);
        em.remove(mod);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<Pegawai> ambilData() {
        EntityManager em = Persistence.createEntityManagerFactory("NewCafe2KPU").createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Pegawai> query = em.createNamedQuery("Pegawai.getAll", Pegawai.class);
        List<Pegawai> list = query.getResultList();
        em.getTransaction().commit();
        em.close();
        return list;
    }

    @Override
    public List<Pegawai> getByID(String id) {
        EntityManager em = Persistence.createEntityManagerFactory("NewCafe2KPU").createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Pegawai> query = em.createNamedQuery("Pegawai.getByID", Pegawai.class);
        query.setParameter("idPegawai", "%" + id + "%");
        List<Pegawai> list = query.getResultList();
        em.getTransaction().commit();
        em.close();
        return list;
    }

    @Override
    public List<Pegawai> getByNama(String nama) {
        EntityManager em = Persistence.createEntityManagerFactory("NewCafe2KPU").createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Pegawai> query = em.createNamedQuery("Pegawai.getByNama", Pegawai.class);
        query.setParameter("nama", "%" + nama + "%");
        List<Pegawai> list = query.getResultList();
        em.getTransaction().commit();
        em.close();
        return list;
    }

    @Override
    public List<Pegawai> getByAlamat(String alamat) {
        EntityManager em = Persistence.createEntityManagerFactory("NewCafe2KPU").createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Pegawai> query = em.createNamedQuery("Pegawai.getByAlamat", Pegawai.class);
        query.setParameter("alamat", "%" + alamat + "%");
        List<Pegawai> list = query.getResultList();
        em.getTransaction().commit();
        em.close();
        return list;
    }

    @Override
    public Pegawai getById(String id) {
        EntityManager em = Persistence.createEntityManagerFactory("NewCafe2KPU").createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Pegawai> query = em.createNamedQuery("Pegawai.getById", Pegawai.class);
        query.setParameter("idPegawai", id);
        query.setMaxResults(1);
        Pegawai mod = query.getSingleResult();
        em.getTransaction().commit();
        em.close();
        return mod;
    }

    @Override
    public String getNomer() {
        try {
            EntityManager em = Persistence.createEntityManagerFactory("NewCafe2KPU").createEntityManager();
            em.getTransaction().begin();
            TypedQuery<String> query = em.createNamedQuery("Pegawai.getNomer", String.class);
            query.setMaxResults(1);
            String s = query.getSingleResult();
            em.getTransaction().commit();
            em.close();
            return "PT" + String.format("%03d", Integer.parseInt(s) + 1);
        } catch (NoResultException e) {
            return "PT001";
        }
    }

    @Override
    public Pegawai login(String user, String pass) {
        try {
            EntityManager em = Persistence.createEntityManagerFactory("NewCafe2KPU").createEntityManager();
            em.getTransaction().begin();
            TypedQuery<Pegawai> query = em.createNamedQuery("Pegawai.login", Pegawai.class);
            query.setParameter("username", user);
            query.setParameter("password", Encrypt.getmd5java(pass));
            Pegawai mod = query.getSingleResult();
            em.getTransaction().commit();
            em.close();
            return mod;
        } catch (NoResultException e) {
            return null;
        }
    }

}
