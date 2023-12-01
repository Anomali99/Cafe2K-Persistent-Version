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
import model.Supply;
import servis.ServisSupply;

/**
 *
 * @author fatiq
 */
public class DaoSupply implements ServisSupply {

    @Override
    public void tambahData(Supply mod) {
        EntityManager em = Persistence.createEntityManagerFactory("NewCafe2KPU").createEntityManager();
        em.getTransaction().begin();
        em.persist(mod);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void hapusData(String id) {
        EntityManager em = Persistence.createEntityManagerFactory("NewCafe2KPU").createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Supply> query = em.createNamedQuery("Supply.getByNo", Supply.class);
        query.setParameter("noSupply", id);
        query.setMaxResults(1);
        Supply mod = query.getSingleResult();
        em.remove(mod);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<Supply> ambilData() {
        EntityManager em = Persistence.createEntityManagerFactory("NewCafe2KPU").createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Supply> query = em.createNamedQuery("Supply.getAll", Supply.class);
        List<Supply> list = query.getResultList();
        em.getTransaction().commit();
        em.close();
        return list;
    }

    @Override
    public List<Supply> getByNO(String no) {
        EntityManager em = Persistence.createEntityManagerFactory("NewCafe2KPU").createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Supply> query = em.createNamedQuery("Supply.getByNO", Supply.class);
        query.setParameter("noSupply", "%"+no+"%");
        List<Supply> list = query.getResultList();
        em.getTransaction().commit();
        em.close();
        return list;
    }

    @Override
    public List<Supply> getByTanggal(String tanggal) {
        EntityManager em = Persistence.createEntityManagerFactory("NewCafe2KPU").createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Supply> query = em.createNamedQuery("Supply.getByTanggal", Supply.class);
        query.setParameter("tanggal", "%"+tanggal+"%");
        List<Supply> list = query.getResultList();
        em.getTransaction().commit();
        em.close();
        return list;
    }

    @Override
    public List<Supply> getByPetugas(String nama) {
        EntityManager em = Persistence.createEntityManagerFactory("NewCafe2KPU").createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Supply> query = em.createNamedQuery("Supply.getByPegawai", Supply.class);
        query.setParameter("nama", "%"+nama+"%");
        List<Supply> list = query.getResultList();
        em.getTransaction().commit();
        em.close();
        return list;
    }

    @Override
    public List<Supply> getBySupplier(String nama) {
        EntityManager em = Persistence.createEntityManagerFactory("NewCafe2KPU").createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Supply> query = em.createNamedQuery("Supply.getBySupplier", Supply.class);
        query.setParameter("nama", "%"+nama+"%");
        List<Supply> list = query.getResultList();
        em.getTransaction().commit();
        em.close();
        return list;
    }

    @Override
    public Supply getByNo(String no) {
        EntityManager em = Persistence.createEntityManagerFactory("NewCafe2KPU").createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Supply> query = em.createNamedQuery("Supply.getByNo", Supply.class);
        query.setParameter("noSupply", no);
        query.setMaxResults(1);
        Supply mod = query.getSingleResult();
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
            TypedQuery<String> query = em.createNamedQuery("Supply.getNomer", String.class);
            query.setMaxResults(1);
            String s = query.getSingleResult();
            em.getTransaction().commit();
            em.close();
            return "R" + no + String.format("%03d", Integer.parseInt(s) + 1);
        } catch (NoResultException e) {
            return "R" + no + "001";
        }
    }
    
}
