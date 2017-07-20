/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

/**
 *
 * @author el_je_000
 */
public class FabricaComando {
    
        public static ComandoGeneral<String, String> ObtenerComandoCrearProfesor()
    {      try {
                return new ComandoCrearProfesor();
            }catch(UnsupportedOperationException e){
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }            
    }
        public static ComandoGeneral<String, String> ObtenerComandoCrearPreferencia()
    {      try {
                return new ComandoCrearPreferencia();
            }catch(UnsupportedOperationException e){
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }            
    }
        public static ComandoGeneral<String, String> ObtenerComandoCrearHorario()
    {      try {
                return new ComandoCrearHorario();
            }catch(UnsupportedOperationException e){
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }            
    }        
        
}
