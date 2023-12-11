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
import model.DetailPembelian;
import model.Menu;
import model.Pembelian;
import servis.ServisPembelian;

/**
 *
 * @author fatiq
 */
public class DaoPembelian implements ServisPembelian {

    @Override
    public void tambahData(Pembelian mod) {
        EntityManager em = Persistence.createEntityManagerFactory("NewCafe2KPU").createEntityManager();
        em.getTransaction().begin();
        em.persist(mod);
        for (DetailPembelian p : mod.getDetailPembelianCollection()) {
            Menu m = p.getMenu();
            m.setStok(m.getStok() - p.getJumlah());
            em.merge(m);
        }
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void ubahData(Pembelian mod) {
        EntityManager em = Persistence.createEntityManagerFactory("NewCafe2KPU").createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Pembelian> query = em.createNamedQuery("Pembelian.getByNo", Pembelian.class);
        query.setParameter("noPembelian", mod.getPembelianPK().getNoPembelian());
        query.setMaxResults(1);
        Pembelian old = query.getSingleResult();
        for (DetailPembelian p : mod.getDetailPembelianCollection()) {
            Menu m = p.getMenu();
            DetailPembelian b = null;
            for (DetailPembelian d : old.getDetailPembelianCollection()) {
                if (m.getKodeMenu().equals(d.getMenu().getKodeMenu())) {
                    b = d;
                }
            }
            if (b != null) {
                int i = p.getJumlah() - b.getJumlah();
                m.setStok(m.getStok() - i);
            } else {
                m.setStok(m.getStok() - p.getJumlah());
            }
            em.merge(m);
        }
        em.merge(mod);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void hapusData(String id) {
        EntityManager em = Persistence.createEntityManagerFactory("NewCafe2KPU").createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Pembelian> query = em.createNamedQuery("Pembelian.getByNo", Pembelian.class);
        query.setParameter("noPembelian", id);
        query.setMaxResults(1);
        Pembelian mod = query.getSingleResult();
        em.remove(mod);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<Pembelian> ambilData() {
        EntityManager em = Persistence.createEntityManagerFactory("NewCafe2KPU").createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Pembelian> query = em.createNamedQuery("Pembelian.getAll", Pembelian.class);
        List<Pembelian> list = query.getResultList();
        em.getTransaction().commit();
        em.close();
        return list;
    }

    @Override
    public List<Pembelian> getByNO(String no) {
        EntityManager em = Persistence.createEntityManagerFactory("NewCafe2KPU").createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Pembelian> query = em.createNamedQuery("Pembelian.getByNO", Pembelian.class);
        query.setParameter("noPembelian", "%" + no + "%");
        List<Pembelian> list = query.getResultList();
        em.getTransaction().commit();
        em.close();
        return list;
    }

    @Override
    public List<Pembelian> getByTanggal(Date tanggal) {
        EntityManager em = Persistence.createEntityManagerFactory("NewCafe2KPU").createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Pembelian> query = em.createNamedQuery("Pembelian.getByTanggal", Pembelian.class);
        query.setParameter("tanggal", tanggal);
        List<Pembelian> list = query.getResultList();
        em.getTransaction().commit();
        em.close();
        return list;
    }

    @Override
    public List<Pembelian> getByPetugas(String nama) {
        EntityManager em = Persistence.createEntityManagerFactory("NewCafe2KPU").createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Pembelian> query = em.createNamedQuery("Pembelian.getByPegawai", Pembelian.class);
        query.setParameter("nama", "%" + nama + "%");
        List<Pembelian> list = query.getResultList();
        em.getTransaction().commit();
        em.close();
        return list;
    }

    @Override
    public List<Pembelian> getByPelanggan(String nama) {
        EntityManager em = Persistence.createEntityManagerFactory("NewCafe2KPU").createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Pembelian> query = em.createNamedQuery("Pembelian.getByPelanggan", Pembelian.class);
        query.setParameter("nama", "%" + nama + "%");
        List<Pembelian> list = query.getResultList();
        em.getTransaction().commit();
        em.close();
        return list;
    }

    @Override
    public Pembelian getByNo(String no) {
        EntityManager em = Persistence.createEntityManagerFactory("NewCafe2KPU").createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Pembelian> query = em.createNamedQuery("Pembelian.getByNo", Pembelian.class);
        query.setParameter("noPembelian", no);
        query.setMaxResults(1);
        Pembelian mod = query.getSingleResult();
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
            TypedQuery<String> query = em.createNamedQuery("Pembelian.getNomer", String.class);
            query.setMaxResults(1);
            String s = query.getSingleResult();
            em.getTransaction().commit();
            em.close();
            return "T" + no + String.format("%03d", Integer.parseInt(s) + 1);
        } catch (NoResultException e) {
            return "T" + no + "001";
        }
    }

}
