/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import encje.Serwisant;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

/**
 *
 * @author zetosoftware
 */
@Path("")
public class Serwisanci {
    @EJB
    beans.Serwisanci bean;
    
    @GET
    @Path("serwisanci/new")
    @Produces("text/plain")
    public long dodajSerwisanta(@QueryParam("imie") String imie,@QueryParam("nazwisko") String nazwisko)
    {
        return bean.dodajSerwisanta(imie, nazwisko);
    }
            
    @GET
    @Path("serwisanci")
    @Produces("application/json")
    public List<Serwisant> listaSerwisantow()
    {
        return bean.listaSerwisantow();
    }
}
