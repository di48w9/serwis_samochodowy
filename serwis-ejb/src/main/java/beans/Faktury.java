/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import encje.Czesc;
import encje.Faktura;
import encje.Klient;
import encje.PozycjaCzesc;
import encje.PozycjaFaktury;
import encje.PozycjaUsluga;
import encje.Serwisant;
import encje.Usluga;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author zetosoftware
 */
@Stateless
@LocalBean
public class Faktury {

    
    @PersistenceContext(name="primary")
    private EntityManager entityManager;
    
    public Faktura znajdzFakture(long nr_faktury)
    {
        Faktura f=entityManager.find(Faktura.class, nr_faktury);
        for (PozycjaFaktury p:f.getElementy()) 
        {
            p.getKoszt();
            p.updateAll();
        }
        return f;
    }
    
    public long dodajFakture(long klucz_klienta,long klucz_serwisanta,List<ElementFaktury_VO> pozycje,int vat) throws Exception
    {
                List<PozycjaFaktury> pozycje_bo=new ArrayList<>();
        for (ElementFaktury_VO el:pozycje)
        {
            PozycjaFaktury p=null;
            if (el.getTyp()==ElementFaktury_VO.TypFaktury.Usluga)
            {
                p=new PozycjaUsluga();
                Usluga obj=entityManager.find(Usluga.class, (long)el.getId_uslugiczesci());
                ((PozycjaUsluga)p).setUsluga(obj);
            } else
            {
                p=new PozycjaCzesc();
                Czesc obj=entityManager.find(Czesc.class, (long)el.getId_uslugiczesci());
                ((PozycjaCzesc)p).setCzesc(obj);
            }
            p.setKoszt(el.getKoszt());
            pozycje_bo.add(p);
        }
        
        Klient k=entityManager.find(Klient.class, klucz_klienta);
        Serwisant s=entityManager.find(Serwisant.class,klucz_serwisanta);
        Faktura f=new Faktura();
        if ((k==null)||(s==null)) throw new Exception("Null!");
        k.addFaktura(f);
        f.setSerwisant(s);
        f.setKlient(k);
        f.setVat(vat);
        for (PozycjaFaktury p:pozycje_bo)
        {
            f.addElement(p);
        }
        entityManager.persist(f);
        return f.getId();
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
