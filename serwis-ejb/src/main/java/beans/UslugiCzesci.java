/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import encje.Czesc;
import encje.Usluga;
import java.util.Collection;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author zetosoftware
 */
@Stateless
@LocalBean
public class UslugiCzesci {
    @PersistenceContext(name="primary")
    private EntityManager entityManager;
    
    public Usluga DodajUsluge(String nazwa)
    {
        Usluga u=new Usluga();
        u.setNazwa(nazwa);
        entityManager.persist(u);
        return u;
    }
    
    public Czesc DodajCzesc(String nazwa)
    {
        Czesc c=new Czesc();
        c.setNazwa(nazwa);
        entityManager.persist(c);
        return c;
    }
    
    public List<Usluga> ListujUslugi()
    {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Usluga> cq = cb.createQuery(Usluga.class);
        Root<Usluga> rootEntry = cq.from(Usluga.class);
        CriteriaQuery<Usluga> all = cq.select(rootEntry);
        TypedQuery<Usluga> allQuery = entityManager.createQuery(all);
        return allQuery.getResultList();
    }
    
    public List<Czesc> ListujCzesci()
    {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Czesc> cq = cb.createQuery(Czesc.class);
        Root<Czesc> rootEntry = cq.from(Czesc.class);
        CriteriaQuery<Czesc> all = cq.select(rootEntry);
        TypedQuery<Czesc> allQuery = entityManager.createQuery(all);
        return allQuery.getResultList();
    }
}
