/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

/**
 *
 * @author el_je_000
 */
public class FABRICADAO {

    public static IDAOProfesor ObtenerDAOProfesor() {
        
        return new DAOProfesor();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public static IDAOPreferencia ObtenerDAOPreferencia() {
        
        return new DAOPreferencia();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public static IDAOHorario ObtenerDAOHorario() {
        
        return new DAOHorario();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
