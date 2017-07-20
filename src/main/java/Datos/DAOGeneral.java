/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.io.File;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

/**
 *
 * @author el_je_000
 */
public class DAOGeneral implements IDAOGeneral {
    public static final String DEFAULT_NEO4J_STORE_DIR = "C:\\Users\\el_je_000\\Documents\\Neo4j\\informacion";
    public static String storeDir = DEFAULT_NEO4J_STORE_DIR;
    public static GraphDatabaseService graphDb;

      /*
     * Funcion que inicia la conexion con la BD
     * @return Base de Datos (GraphDatabaseService)
     * @throws Exception
     */
        public static GraphDatabaseService IniciarConexion() throws Exception  
        {   
           try 
            {
               graphDb = new GraphDatabaseFactory().newEmbeddedDatabase((new File(storeDir)));
               //graphDb = new GraphDatabaseFactory().newEmbeddedDatabase(storeDir);
               System.out.println("Inicio sesión BD");               
               return DAOGeneral.graphDb;
            }
           catch(UnsupportedOperationException e){
                System.out.println("Error en DAOGeneral, Función IniciarConexión, Excepción UnknownHost : " + e);
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            } 
        }

     /*
     * Funcion que cierra la conexion con la BD
     * @throws Exception
     */
    @Override
        public void CerrarConexion()
        {
            try 
            {
                graphDb.shutdown();
                System.out.println("Cierre de conexi[on");                
            }
           catch(UnsupportedOperationException e){
                      System.out.println("Error en DAOGeneral, Función CerrarConexión, Excepción UnknownHost : " + e);
                       throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                      //throw exception;               
            }                                              
        }        
        /*
        * Funcion que obtiene la Base de Datos
        * @return Base de Datos (DB)
        */
        public static GraphDatabaseService getDb() {
           return graphDb;
        }
        /*
        * Funcion que inicializa/sets la informacion de la Base de Datos (DB)
        * 
        */
        public static void setDb(GraphDatabaseService db) {
            DAOGeneral.graphDb = db;
        }
                    
    
}
