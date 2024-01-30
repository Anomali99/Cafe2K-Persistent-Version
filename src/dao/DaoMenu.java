/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import model.Menu;
import servis.ServisMenu;

/**
 *
 * @author fatiq
 */
public class DaoMenu implements ServisMenu {

    @Override
    public void tambahData(Menu mod) {
        EntityManager em = Persistence.createEntityManagerFactory("NewCafe2KPU").createEntityManager();
        em.getTransaction().begin();
        em.persist(mod);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void ubahData(Menu mod) {
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
        Menu mod = em.find(Menu.class, id);
        em.remove(mod);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<Menu> ambilData() {
        EntityManager em = Persistence.createEntityManagerFactory("NewCafe2KPU").createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Menu> query = em.createNamedQuery("Menu.getAll", Menu.class);
        List<Menu> list = query.getResultList();
        em.getTransaction().commit();
        em.close();
        return list;
    }

    @Override
    public List<Menu> getTerlaris() {
        try {
            EntityManager em = Persistence.createEntityManagerFactory("NewCafe2KPU").createEntityManager();
            em.getTransaction().begin();
            TypedQuery<Menu> query = em.createNamedQuery("Menu.getTerlaris", Menu.class);
            List<Menu> list = query.getResultList();
            em.getTransaction().commit();
            em.close();
            list.sort(Comparator.comparingInt(Menu -> Menu.getTerjual()));
            List<Menu> list1 = new ArrayList();
            for(int i = list.size(); i > 0; i--){
                list1.add(list.get(i-1));
            }
            if (list1.size() <= 6) {
                return list1;
            } else {
                return list1.subList(0, 5);
            }
        } catch (PersistenceException e) {
            return new ArrayList();
        }
    }

    @Override
    public List<Menu> getByKODE(String kode) {
        EntityManager em = Persistence.createEntityManagerFactory("NewCafe2KPU").createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Menu> query = em.createNamedQuery("Menu.getByKODE", Menu.class);
        query.setParameter("kodeMenu", "%" + kode + "&");
        List<Menu> list = query.getResultList();
        em.getTransaction().commit();
        em.close();
        return list;
    }

    @Override
    public List<Menu> getByNama(String nama) {
        EntityManager em = Persistence.createEntityManagerFactory("NewCafe2KPU").createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Menu> query = em.createNamedQuery("Menu.getByNama", Menu.class);
        query.setParameter("nama", "%" + nama + "&");
        List<Menu> list = query.getResultList();
        em.getTransaction().commit();
        em.close();
        return list;
    }

    @Override
    public List<Menu> getByBahan(String bahan) {
        EntityManager em = Persistence.createEntityManagerFactory("NewCafe2KPU").createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Menu> query = em.createNamedQuery("Menu.getByBahan", Menu.class);
        query.setParameter("bahan", "%" + bahan + "&");
        List<Menu> list = query.getResultList();
        em.getTransaction().commit();
        em.close();
        return list;
    }

    @Override
    public Menu getByKode(String kode) {
        EntityManager em = Persistence.createEntityManagerFactory("NewCafe2KPU").createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Menu> query = em.createNamedQuery("Menu.getByKode", Menu.class);
        query.setParameter("kodeMenu", kode);
        query.setMaxResults(1);
        Menu mod = query.getSingleResult();
        em.getTransaction().commit();
        em.close();
        return mod;
    }

    @Override
    public String getNomer() {
        try {
            EntityManager em = Persistence.createEntityManagerFactory("NewCafe2KPU").createEntityManager();
            em.getTransaction().begin();
            TypedQuery<String> query = em.createNamedQuery("Menu.getNomer", String.class);
            query.setMaxResults(1);
            String s = query.getSingleResult();
            em.getTransaction().commit();
            em.close();
            return "MN" + String.format("%03d", Integer.parseInt(s) + 1);
        } catch (NoResultException e) {
            return "MN001";
        }
    }

}
