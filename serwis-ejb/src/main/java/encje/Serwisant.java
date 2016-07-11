/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encje;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author zetosoftware
 */
@Entity
@Table(name="Serwisant")
public class Serwisant extends Osoba implements Serializable {

    public Serwisant() {
    }

    @Override
    public String toString() {
        return "encje.Serwisant[ id=" + id + " ]";
    }
    
}
