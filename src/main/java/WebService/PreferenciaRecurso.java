/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebService;

import Logica.FabricaComando;
import javax.ws.rs.core.Response;

/**
 *
 * @author el_je_000
 */
public class PreferenciaRecurso {
    
    public static Response createPreferencias(String prueba) {
        try{
        System.out.println("POST " + prueba);
        String result = prueba;
        FabricaComando.ObtenerComandoCrearPreferencia().Ejecutar(prueba);
        return Response.status(201).entity(result).build();
        } catch(UnsupportedOperationException e){
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }    
    
}
