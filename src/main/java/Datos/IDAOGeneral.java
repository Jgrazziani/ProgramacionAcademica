/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;
import java.net.UnknownHostException;
/**
 *
 * @author el_je_000
 */
public interface IDAOGeneral {
    /*
     * Cierra la conexión a la base de datos
     * @throws UnknownHostException
     */
         
    public void CerrarConexion() throws UnknownHostException;
        
}
