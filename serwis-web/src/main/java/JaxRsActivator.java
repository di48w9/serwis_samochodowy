/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.eclipse.persistence.jaxb.rs.MOXyJsonProvider;
import rest.Faktury;
import rest.Klienci;
import rest.Serwisanci;
import rest.UslugiCzesci;

/**
 *
 * @author zetosoftware
 */
@ApplicationPath("/rest")
public class JaxRsActivator extends Application {
  @Override
    public Set<Class<?>> getClasses() {
        HashSet<Class<?>> set = new HashSet<Class<?>>(2);
        set.add(MOXyJsonProvider.class);
        set.add(UslugiCzesci.class);
        set.add(Klienci.class);
        set.add(Faktury.class);
        set.add(Serwisanci.class);
        return set;
}
}
