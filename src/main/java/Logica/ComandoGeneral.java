/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

/**
 *
 * @author el_je_000
 * @param <Entrada>
 * @param <Resultado>
 */
public abstract class ComandoGeneral<Entrada,Resultado> {
    
    /*
     * Ejecuta la funcion del comando
     * recibe un string  con los parametros de entrada
     * devuelve un string con la respuesta
     */
    public abstract Resultado Ejecutar(Entrada parametro);
    
}