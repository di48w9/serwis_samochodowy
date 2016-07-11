/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import encje.Klient;
import encje.Samochod;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

/**
 *
 * @author zetosoftware
 */

@Path("")
public class Klienci {
    
    @EJB
    beans.Klienci bean;
    
    @POST
    @Path("klienci")
    @Produces("text/plain")
    public long dodajKlienta(@QueryParam("imie") String imie,@QueryParam("nazwisko") String nazwisko,@QueryParam("typ") Klient.TypKlienta typ)
    {
        return bean.dodajKlienta(imie, nazwisko, typ);
    }
    
    @GET
    @Path("klienci")
    @Produces("application/json")
    public List<Klient> ListaKlientow()
    {
        return bean.ListaKlientow();
    }
    
    @POST
    @Path("samochody")
    public void dodajSamochod(@QueryParam("klient") long klient_id,@QueryParam("VIN") String VIN,@QueryParam("RokProdukcji") int rok_produkcji)
    {
        bean.dodajSamochod(klient_id, VIN, rok_produkcji);
    }
    
    @GET
    @Path("samochody")
    @Produces("application/json")
    public List<Samochod> listaSamochodow()
    {
        return bean.listaSamochodow();
    }
}
