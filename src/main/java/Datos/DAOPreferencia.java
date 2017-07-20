/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Dominio.ENTIDAD;
import Dominio.FABRICAENTIDAD;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Label;
import java.util.logging.Logger;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.ResourceIterator;
import org.neo4j.graphdb.Transaction;
import org.neo4j.helpers.collection.MapUtil;

/**
 *
 * @author el_je_000
 */
public class DAOPreferencia extends DAOGeneral implements IDAOPreferencia{
    public ENTIDAD _preferencia = FABRICAENTIDAD.obtenerPreferencia(0, null, null, null, true); 

    public enum NodeType implements Label{
        Preferencia,secuenciaID;
    }

    @Override
    public boolean CrearPreferencia(String preferencias) {
        System.out.println("preferencia " + preferencias);
        boolean respuesta = false;
        GraphDatabaseService graphDb = null;
        try {
            graphDb = DAOGeneral.IniciarConexion();            
        } catch (UnsupportedOperationException e) {
            Logger.getLogger(DAOPreferencia.class.getName()).log(Level.SEVERE, null, e);
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        } catch (Exception ex) {
            Logger.getLogger(DAOProfesor.class.getName()).log(Level.SEVERE, null, ex);
        }
        final Map<String, Object> params = MapUtil.map( "Sec_descripcion", "secuenicas" );
        try (Transaction tx = graphDb.beginTx()){
            System.out.println("DAOPrefrencia "+preferencias);
            String id= "";
            ResourceIterator<Node> providers = graphDb.findNodes(DAOProfesor.NodeType.secuenciaID);
            List<String> Listapreferencias = new ArrayList<>();
            Listapreferencias.add("15 min. antes de la clase.");
            Listapreferencias.add("Abandono del salón.");
            Listapreferencias.add("Reporte manual de asistencia.");
            Listapreferencias.add("Firma de asistencia en escuela.");
            while (providers.hasNext()) {
		final Node recordNode = providers.next();               
                String i = recordNode.getProperty("Sec_pref").toString();
                int number = Integer.parseInt(i);
                id = String.valueOf(number);
                String intTostring = "";
                int idtoint = Integer.parseInt(id);
                for (int in = 0; in<Listapreferencias.size(); in++){
                    Node Preferencia = graphDb.createNode(NodeType.Preferencia);                    
                    idtoint = idtoint +1;
                    intTostring = String.valueOf(idtoint);
                    Preferencia.setProperty("Pref_id", intTostring);
                    Preferencia.setProperty("Pref_tipo","");
                    Preferencia.setProperty("Pref_nombre", Listapreferencias.get(in));
                    Preferencia.setProperty("Pref_descripcion", "");
                    Preferencia.setProperty("Pref_status","off");
                    Preferencia.setProperty("Pref", "preferencias");
                    Preferencia.setProperty("Usu_id", preferencias);
                    tx.success();
                }                
                recordNode.setProperty("Sec_pref", intTostring);
                tx.success();
	    }
            respuesta = true; 
        }catch (NullPointerException NullPointerexcepcion){
            System.out.println("Error en DAOPreferencia, Función CREAR preferencia, Excepción NullPointer : " + NullPointerexcepcion);
            respuesta = false;
            throw NullPointerexcepcion;   
        }
        finally{
            graphDb.shutdown();
            System.out.println("SHUTDOWN");
        }              
        return respuesta;        
    }
    
}
