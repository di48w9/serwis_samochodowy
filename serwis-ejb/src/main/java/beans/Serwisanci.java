/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import encje.Klient;
import encje.Serwisant;
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
public class Serwisanci {
    
    @PersistenceContext(name="primary")
    private EntityManager entityManager;
    
    public long dodajSerwisanta(String imie,String nazwisko)
    {
        Serwisant s=new Serwisant();
        s.setImie(imie);
        s.setNazwisko(nazwisko);
        entityManager.persist(s);
        return s.getId();
    }
    
    public List<Serwisant> listaSerwisantow()
    {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Serwisant> cq = cb.createQuery(Serwisant.class);
        Root<Serwisant> rootEntry = cq.from(Serwisant.class);
        CriteriaQuery<Serwisant> all = cq.select(rootEntry);
        TypedQuery<Serwisant> allQuery = entityManager.createQuery(all);
        return allQuery.getResultList();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
