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
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author zetosoftware
 */
@Entity
@Table(name="PozycjaUsluga")
public class PozycjaUsluga extends PozycjaFaktury implements Serializable {
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uslugaId")
    private Usluga usluga;

    public void setUsluga(Usluga usluga) {
        this.usluga = usluga;
    }

    public Usluga getUsluga() {
        return usluga;
    }
    
    @Override
    public void updateAll()
    {
        usluga.getNazwa();
    }

    @Override
    public String toString() {
        return "encje.PozycjaUsluga[ id=" + id + " ]";
    }
    
}
