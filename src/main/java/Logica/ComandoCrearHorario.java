/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.FABRICADAO;
import Datos.IDAOHorario;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 *
 * @author el_je_000
 */
public class ComandoCrearHorario extends ComandoGeneral{
    @Override
    public Object Ejecutar (Object parametro)
    {
        try
        {
           System.out.println(" LLAMADO A FABRICA OBTENER DAOCrearHorario " + parametro.toString());
           IDAOHorario _daoHorario;
           System.out.println("LLAMAR a FABRICADAO");
           _daoHorario = FABRICADAO.ObtenerDAOHorario();
           boolean Crearhorario = _daoHorario.CrearHorario(parametro.toString());                           
           return Crearhorario;                      
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
