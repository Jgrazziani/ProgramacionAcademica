/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Dominio.ENTIDAD;
import Dominio.FABRICAENTIDAD;
import WebService.PreferenciaRecurso;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Response;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.RelationshipType;
import org.neo4j.graphdb.ResourceIterator;
import org.neo4j.graphdb.Transaction;
import org.neo4j.helpers.collection.MapUtil;

/**
 *
 * @author el_je_000
 */
public class DAOProfesor extends DAOGeneral implements IDAOProfesor{
    public ENTIDAD _profesor =  FABRICAENTIDAD.obtenerProfesor(0, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
    
    public enum NodeType implements Label{
        Usuario, Preferencia,secuenciaID;
    }
    
    public String EliminarEspacioEnBlanco(String eliminar){
        eliminar = eliminar.replace(" ", "");
        return eliminar;
    }
    
    @Override
    public boolean CrearProfesor(String profesor){
        System.out.println("profesor " + profesor);
        boolean respuesta = false;
        String id= "";
        GraphDatabaseService graphDb = null;
        try {
            graphDb = DAOGeneral.IniciarConexion();            
        } catch (UnsupportedOperationException e) {
            Logger.getLogger(DAOProfesor.class.getName()).log(Level.SEVERE, null, e);
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        } catch (Exception ex) {
            Logger.getLogger(DAOProfesor.class.getName()).log(Level.SEVERE, null, ex);
        }
        final Map<String, Object> params = MapUtil.map( "Sec_descripcion", "secuenicas" );
        try (Transaction tx = graphDb.beginTx()){
            System.out.println("DAOProfesor "+profesor);
            respuesta = true;
            String str[] = profesor.split(",");
            for (int i = 0; i<str.length;i++)
            {                   
                if(str[i].length()>1){
                  str[i] =  EliminarEspacioEnBlanco(str[i]);
                }                
            }            
            ResourceIterator<Node> providers = graphDb.findNodes(NodeType.secuenciaID);
            while (providers.hasNext()) {
		final Node recordNode = providers.next();               
                String i = recordNode.getProperty("Sec_usuario").toString();
                int number = Integer.parseInt(i);
                number = number + 1;
                id = String.valueOf(number);
                recordNode.setProperty("Sec_usuario", id);
                tx.success();
	    }    
            if (str.length == 6){
            Node Profesor = graphDb.createNode(NodeType.Usuario);
            Profesor.setProperty("Usu_id", id);
            Profesor.setProperty("Usu_foto","");
            Profesor.setProperty("Usu_correo", str[4]);
            Profesor.setProperty("Usu_contraseña", str[5]);
            Profesor.setProperty("Usu_tipo","Profesor");
            Profesor.setProperty("Usu_primer_nombre", str[2]);
            Profesor.setProperty("Usu_segundo_nombre", str[3]);
            Profesor.setProperty("Usu_primer_apellido", str[0]);
            Profesor.setProperty("Usu_segundo_apellido", str[1]);
            tx.success();
            respuesta = true; 
            }else if(str.length==5){
            System.out.println("longitud 5");
            Node Profesor = graphDb.createNode(NodeType.Usuario);
            Profesor.setProperty("Usu_id", id);
            Profesor.setProperty("Usu_foto","");
            Profesor.setProperty("Usu_correo",str[3]);
            Profesor.setProperty("Usu_contraseña", str[4]);
            Profesor.setProperty("Usu_tipo","Profesor");
            Profesor.setProperty("Usu_primer_nombre", str[2]);
            Profesor.setProperty("Usu_segundo_nombre", "");
            Profesor.setProperty("Usu_primer_apellido", str[0]);
            Profesor.setProperty("Usu_segundo_apellido", str[1]);
            tx.success();
            respuesta = true;                
            }            
        }catch (NullPointerException NullPointerexcepcion){
            System.out.println("Error en DAOProfesor, Función CREAR profesor, Excepción NullPointer : " + NullPointerexcepcion);
            respuesta = false;
            throw NullPointerexcepcion;   
        }
        finally{
            graphDb.shutdown();
            System.out.println("SHUTDOWN");
        }
            Response create = PreferenciaRecurso.createPreferencias(id);
            System.out.println("create "+create);        
        return respuesta;
    }    
}
