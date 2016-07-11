/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import encje.Czesc;
import encje.Usluga;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

/**
 *
 * @author zetosoftware
 */
@Path("")
public class UslugiCzesci {
    
    @EJB
    private beans.UslugiCzesci bean;
    
    @GET
    @Path("uslugi/new")
    public void DodajUsluge(@QueryParam("nazwa") String nazwa)
    {
        bean.DodajUsluge(nazwa);
    }
    
    @GET
    @Path("uslugi/lel")
    public String test() throws JAXBException
    {
        return (JAXBContext.newInstance(Czesc.class).getClass()).toString()+
        (JAXBContext.newInstance(Czesc.class).getClass())+
        (JAXBContext.newInstance(Czesc.class, Usluga.class).getClass());
    }
    
    @GET
    @Path("uslugi")
    @Produces("application/json")
    public List<Usluga> listujUslugi()
    {
        return bean.ListujUslugi();
    }
    
    @GET
    @Path("czesci/new")
    public void DodajCzesc(@QueryParam("nazwa") String nazwa)
    {
        bean.DodajCzesc(nazwa);
    }
    
    @GET
    @Path("czesci")
    @Produces("application/json")
    public List<Czesc> listujCzesci()
    {
        return bean.ListujCzesci();
    }
}
