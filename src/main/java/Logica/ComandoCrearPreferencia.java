/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.FABRICADAO;
import Datos.IDAOPreferencia;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 *
 * @author el_je_000
 */
public class ComandoCrearPreferencia extends ComandoGeneral{
    @Override
    public Object Ejecutar (Object parametro)
    {
        try
        {
           System.out.println(" LLAMADO A FABRICA OBTENER DAOCrearPreferencia " + parametro.toString());
           IDAOPreferencia _daoPreferencia;
           System.out.println("LLAMAR a FABRICADAO");
           _daoPreferencia = FABRICADAO.ObtenerDAOPreferencia();
           //System.out.println("clases "+System.getProperty("java.class.path"));           
           boolean Crearpreferencia = _daoPreferencia.CrearPreferencia(parametro.toString());                           
           return Crearpreferencia;                      
        }
        catch (UnsupportedOperationException e)
        {
             System.out.println("ENTRO EN LA EXCEPTION DE COMANDO crear preferencia");
             JsonParser parser = new JsonParser();
             JsonObject o = (JsonObject)parser.parse("{\"respuesta\": \"No se pudo cargar las preferencias\"}");
             return o.toString();                      
        }
    }
    
    
}
