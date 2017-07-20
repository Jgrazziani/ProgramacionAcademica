/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.FABRICADAO;
import Datos.IDAOProfesor;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 *
 * @author el_je_000
 */
public class ComandoCrearProfesor extends ComandoGeneral {
    @Override
    public Object Ejecutar (Object parametro)
    {
        try
        {
           System.out.println(" LLAMADO A FABRICA OBTENER DAOCrearProfesor " + parametro.toString());
           IDAOProfesor _daoProfesor;
           System.out.println("LLAMAR a FABRICADAO");
           _daoProfesor = FABRICADAO.ObtenerDAOProfesor();
           //System.out.println("clases "+System.getProperty("java.class.path"));           
           boolean Crearprofesor = _daoProfesor.CrearProfesor(parametro.toString());                           
           return Crearprofesor;                      
        }
        catch (UnsupportedOperationException e)
        {
             System.out.println("ENTRO EN LA EXCEPTION DE COMANDO crear profesor");
             JsonParser parser = new JsonParser();
             JsonObject o = (JsonObject)parser.parse("{\"respuesta\": \"No se pudo cargar la lista de profesores\"}");
             return o.toString();                      
        }
    }
}
