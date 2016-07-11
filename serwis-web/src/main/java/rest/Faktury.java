/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import beans.ElementFaktury_VO;
import encje.Faktura;
import encje.PozycjaFaktury;
import encje.PozycjaUsluga;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

/**
 *
 * @author zetosoftware
 */

@Path("")
public class Faktury {
    
    @EJB
    beans.Faktury bean;
    
    
    @GET
    @Path("faktury/{id}")
    @Produces("application/json")
    public Faktura znajdzFakture(@PathParam("id") long nr_faktury)
    {
        return bean.znajdzFakture(nr_faktury);
    }
    
    @POST
    @Path("faktury/new")
    @Consumes("application/json")
    @Produces("text/plain")
    public long dodajFakture(List<ElementFaktury_VO> pozycje,@QueryParam("klient")long klucz_klienta,@QueryParam("serwisant")long klucz_serwisanta,@QueryParam("vat") @DefaultValue("23") int vat) throws Exception
    {

        return bean.dodajFakture(klucz_klienta, klucz_serwisanta, pozycje, vat);
    }
}
