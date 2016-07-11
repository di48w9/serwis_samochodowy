/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author zetosoftware
 */
public class ElementFaktury_VO {
    
    public enum TypFaktury{Usluga,Czesc};
    private int koszt;
    private int id_uslugiczesci;
    private TypFaktury typ;

    public ElementFaktury_VO() {
    }

    public int getKoszt() {
        return koszt;
    }

    public int getId_uslugiczesci() {
        return id_uslugiczesci;
    }

    public TypFaktury getTyp() {
        return typ;
    }

    public void setKoszt(int koszt) {
        this.koszt = koszt;
    }

    public void setId_uslugiczesci(int id_uslugiczesci) {
        this.id_uslugiczesci = id_uslugiczesci;
    }

    public void setTyp(TypFaktury typ) {
        this.typ = typ;
    }
    
    
}
