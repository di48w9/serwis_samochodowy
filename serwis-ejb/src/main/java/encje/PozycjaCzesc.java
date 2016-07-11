/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encje;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author zetosoftware
 */
@Entity
@Table(name="PozycjaCzesc")
public class PozycjaCzesc extends PozycjaFaktury implements Serializable {

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "czescId")
    Czesc czesc;

    public void setCzesc(Czesc czesc) {
        this.czesc = czesc;
    }

    public Czesc getCzesc() {
        return czesc;
    }
    
    @Override
    public void updateAll()
    {
        czesc.getNazwa();
    }

    @Override
    public String toString() {
        return "encje.PozycjaCzesc[ id=" + id + " ]";
    }
    
}
