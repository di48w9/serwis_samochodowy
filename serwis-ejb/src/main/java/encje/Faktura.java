/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encje;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.CascadeType;
import static javax.persistence.CascadeType.PERSIST;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

/**
 *
 * @author zetosoftware
 */
@Entity
@Table(name="Faktura")
@XmlAccessorType(XmlAccessType.NONE)
public class Faktura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "klientId")
    private Klient klient;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "serwisantId")
    private Serwisant serwisant;
    
    @OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    @JoinColumn(name="elementId")
    @XmlElement(name="elementy")
    private List<PozycjaFaktury> elementy;
    
    int vat;

    public void setVat(int vat) {
        this.vat = vat;
    }

    public List<PozycjaFaktury> getElementy() {
        return elementy;
    }

    public int getVat() {
        return vat;
    }

    public Faktura() {
        elementy=new ArrayList<>();
    }
    
    public void addElement(PozycjaFaktury element)
    {
        elementy.add(element);
    }

    public Klient getKlient() {
        return klient;
    }

    public Serwisant getSerwisant() {
        return serwisant;
    }

    public void setKlient(Klient klient) {
        this.klient = klient;
    }

    public void setSerwisant(Serwisant serwisant) {
        this.serwisant = serwisant;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    @XmlElement(name="netto")
    public int getNetto()
    {
        return brutto()*(100+vat)/100;
    }
    
    
    @XmlElement(name="brutto")
    public int getBrutto()
    {
        return brutto();
    }
    
    public int brutto()
    {
        int rabat_robocizna=0;
        int rabat_czesci=0;
        int obecny_rok = Calendar.getInstance().get(Calendar.YEAR);
        switch (klient.getTyp())
        {
            case Indywidualny:
            {
                if ((obecny_rok-klient.NajstarszySamochod().getRokProdukcji())>=4)
                {
                    rabat_robocizna=10;
                    rabat_czesci=20;
                }
                break;
            }
            case Firma:
            {
                rabat_robocizna=10;
                rabat_czesci=10;
                break;
            }
            case VIP:
            {
                if (klient.getSamochody().size()>=2)
                {
                    rabat_robocizna=10;
                    rabat_czesci=30;
                }
                break;
            }
        }
        int wynik=0;
        for (PozycjaFaktury p:elementy)
        {
            if (p instanceof PozycjaCzesc)
            {
                wynik=wynik+(p.getKoszt()*(100-rabat_czesci)/100);
            } else
            {
                wynik=wynik+(p.getKoszt()*(100-rabat_robocizna)/100);
            }
        }
        return wynik;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Faktura)) {
            return false;
        }
        Faktura other = (Faktura) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "encje.Faktura[ id=" + id + " ]";
    }
    
}
