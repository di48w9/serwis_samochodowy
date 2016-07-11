/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import encje.Klient;
import encje.Samochod;
import encje.Usluga;
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
public class Klienci {
    
    @PersistenceContext(name="primary")
    private EntityManager entityManager;

    public Klienci()
    {
    }
    
    public long dodajKlienta(String imie,String nazwisko,Klient.TypKlienta typ)
    {
        Klient k=new Klient();
        k.setImie(imie);
        k.setNazwisko(nazwisko);
        k.setTyp(typ);
        entityManager.persist(k);
        return k.getId();
    }
    
    public List<Klient> ListaKlientow()
    {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Klient> cq = cb.createQuery(Klient.class);
        Root<Klient> rootEntry = cq.from(Klient.class);
        CriteriaQuery<Klient> all = cq.select(rootEntry);
        TypedQuery<Klient> allQuery = entityManager.createQuery(all);
        for (Klient k: allQuery.getResultList())
        {
            k.getSamochody().size();
        }
        return allQuery.getResultList();
    }
    
    public void dodajSamochod(long klient_id,String VIN,int rok_produkcji)
    {
        Klient k=entityManager.find(Klient.class, klient_id);
        Samochod s=new Samochod();
        s.setRokProdukcji(rok_produkcji);
        s.setVIN(VIN);
        k.addSamochod(s);
        entityManager.persist(s);
    }
    
    public List<Samochod> listaSamochodow()
    {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Samochod> cq = cb.createQuery(Samochod.class);
        Root<Samochod> rootEntry = cq.from(Samochod.class);
        CriteriaQuery<Samochod> all = cq.select(rootEntry);
        TypedQuery<Samochod> allQuery = entityManager.createQuery(all);
        return allQuery.getResultList();
    }
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
