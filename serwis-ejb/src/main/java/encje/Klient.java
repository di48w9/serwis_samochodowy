/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encje;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import static javax.persistence.CascadeType.PERSIST;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author zetosoftware
 */
@Entity
@Table(name="Klient")
public class Klient extends Osoba implements Serializable {
    
    public enum TypKlienta {Indywidualny,Firma,VIP};
    private TypKlienta typ;
    
    @OneToMany(cascade=PERSIST,fetch = FetchType.EAGER)
    @JoinColumn(name = "samochodId")
    @XmlElement
    private List<Samochod> samochody;
    
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "fakturaId")
    private List<Faktura> faktury;

    public Klient() {
        samochody=new ArrayList<>();
        faktury=new ArrayList<>();
    }
    
    public void addSamochod(Samochod s)
    {
        samochody.add(s);
    }
    
    public void addFaktura(Faktura f)
    {
        faktury.add(f);
    }

    public List<Samochod> getSamochody() {
        return samochody;
    }

    public List<Faktura> getFaktury() {
        return faktury;
    }

    public TypKlienta getTyp() {
        return typ;
    }

    public void setTyp(TypKlienta typ) {
        this.typ = typ;
    }
    
    public Samochod NajstarszySamochod()
    {
        if (samochody.size()==0) return null;
        Samochod najstarszy=samochody.get(0);
        for (Samochod s:samochody)
        {
            if (najstarszy.getRokProdukcji()>s.getRokProdukcji()) najstarszy=s;
        }
        return najstarszy;
    }
    
    @Override
    public String toString() {
        return "encje.Klient[ id=" + id + " ]";
    }
    
}
