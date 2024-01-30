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
import model.Bahan;
import model.DetailBahan;
import model.DetailMasak;
import model.Memasak;
import model.Menu;
import servis.ServisMasak;

/**
 *
 * @author fatiq
 */
public class DaoMasak implements ServisMasak {

    @Override
    public void tambahData(Memasak mod) {
        EntityManager em = Persistence.createEntityManagerFactory("NewCafe2KPU").createEntityManager();
        em.getTransaction().begin();
        em.persist(mod);
        for(DetailMasak dm : mod.getDetailMasakCollection()){
            Menu m = dm.getMenu();
            m.setStok(m.getStok() + dm.getJumlah());
            em.merge(m);
            for(DetailBahan db : m.getDetailBahanCollection()){
                Bahan b = db.getBahan();
                b.setStok(b.getStok() - (db.getJumlah()*dm.getJumlah()));
                em.merge(b);
            }
        }
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void hapusData(String id) {
        EntityManager em = Persistence.createEntityManagerFactory("NewCafe2KPU").createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Memasak> query = em.createNamedQuery("Memasak.getByNo", Memasak.class);
        query.setParameter("noMasak", id);
        query.setMaxResults(1);
        Memasak mod = query.getSingleResult();
        em.remove(mod);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<Memasak> ambilData() {
        EntityManager em = Persistence.createEntityManagerFactory("NewCafe2KPU").createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Memasak> query = em.createNamedQuery("Memasak.getAll", Memasak.class);
        List<Memasak> list = query.getResultList();
        em.getTransaction().commit();
        em.close();
        return list;
    }

    @Override
    public List<Memasak> getByNO(String no) {
        EntityManager em = Persistence.createEntityManagerFactory("NewCafe2KPU").createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Memasak> query = em.createNamedQuery("Memasak.getByNO", Memasak.class);
        query.setParameter("noMasak", "%"+no+"%");
        List<Memasak> list = query.getResultList();
        em.getTransaction().commit();
        em.close();
        return list;
    }

    @Override
    public List<Memasak> getByTanggal(Date tanggal) {
        EntityManager em = Persistence.createEntityManagerFactory("NewCafe2KPU").createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Memasak> query = em.createNamedQuery("Memasak.getByTanggal", Memasak.class);
        query.setParameter("tanggal", "%"+tanggal+"%");
        List<Memasak> list = query.getResultList();
        em.getTransaction().commit();
        em.close();
        return list;
    }

    @Override
    public List<Memasak> getByPetugas(String nama) {
        EntityManager em = Persistence.createEntityManagerFactory("NewCafe2KPU").createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Memasak> query = em.createNamedQuery("Memasak.getByPegawai", Memasak.class);
        query.setParameter("nama", "%"+nama+"%");
        List<Memasak> list = query.getResultList();
        em.getTransaction().commit();
        em.close();
        return list;
    }

    @Override
    public List<Memasak> getByMenu(String nama) {
        EntityManager em = Persistence.createEntityManagerFactory("NewCafe2KPU").createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Memasak> query = em.createNamedQuery("Memasak.getByMenu", Memasak.class);
        query.setParameter("menu", "%"+nama+"%");
        List<Memasak> list = query.getResultList();
        em.getTransaction().commit();
        em.close();
        return list;
    }

    @Override
    public Memasak getByNo(String no) {
        EntityManager em = Persistence.createEntityManagerFactory("NewCafe2KPU").createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Memasak> query = em.createNamedQuery("Memasak.getByNO", Memasak.class);
        query.setParameter("noMasak", no);
        query.setMaxResults(1);
        Memasak mod = query.getSingleResult();
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
            TypedQuery<String> query = em.createNamedQuery("Memasak.getNomer", String.class);
            query.setMaxResults(1);
            String s = query.getSingleResult();
            em.getTransaction().commit();
            em.close();
            return "C" + no + String.format("%03d", Integer.parseInt(s) + 1);
        } catch (NoResultException e) {
            return "C" + no + "001";
        }
    }
    
}
