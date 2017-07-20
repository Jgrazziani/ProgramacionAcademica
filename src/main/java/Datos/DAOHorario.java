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
import java.util.logging.Logger;
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
public class DAOHorario extends DAOGeneral implements IDAOHorario {
    
    public ENTIDAD _horario = FABRICAENTIDAD.obtenerHorario(0, null, null, null, null, 0, 0, null, null, null);
    
    public enum NodeType implements Label{
        Horario;
    }
    public enum RelationType implements RelationshipType{
        Pertenece_a, secuenciaID;
    }
    public String EliminarEspacioEnBlanco(String eliminar){
        eliminar = eliminar.replace(" ", "");
        return eliminar;
    }
    public String EliminarPrimerEspacio(String eliminar){
        eliminar = eliminar.substring(1);       
        return eliminar;
    }
        public String Eliminarcomillas(String eliminar){
        eliminar = eliminar.replace("'", "");
        return eliminar;
    }
    private String ArreglarListaHorarios(String horarios){
        horarios = horarios.replace("[", "");
        horarios = horarios.replace("{", "");
        horarios = horarios.replace("]", "");
        horarios = horarios.replace(",", "");
        return horarios;
    }
    private int contarMaterias(String[] materias){
        int numeroMaterias = 0;
        numeroMaterias = (materias.length)/19;
        return numeroMaterias;
    }
    private List<String> EliminarRepetidos(List<String> dias){
        for (int i = 0; i<dias.size();i++){
            for(int j = 0; j<dias.size()-1 ;j++){
               if(i!=j){
                   if(dias.get(i)==dias.get(j)){
                       dias.remove(i);
                   }
               } 
            }
        }
        return dias;
    }
    private String Dia(String dia){        
        //System.out.println("Funcion dia "+dia +" " +dia.length());
        List<String> dias = new ArrayList<>();
        dias.add(dia);
        String diaSemana ="";
        for(int i = 0; i<dias.size();i++){
           System.out.println(dias.get(i));
           /*char ultimo = dia.charAt(dia.length()-1);
           System.out.println(ultimo);*/
           if (dia.length()>1){
                diaSemana = dia.substring(0, dia.length()-1);
                //int diaSemana = dia.length();
                //System.out.println("dias "+diaSemana);
           }
        }
        /*if(dia.length()>0){
            char ultimo = dia.charAt(dia.length()-1);
            System.out.println(ultimo);
        }*/
        return diaSemana;
    }
    private String obtenerValorDia(List<String> horarios, int p){
        String elDia="";
        for(int i=0 ; i<horarios.size();i++ ){
            int lunes,martes,miercoles,jueves,viernes;
            lunes=4;martes=7;miercoles=10;jueves=13;viernes=16;            
            if (p==1){
                elDia="";
                if (Integer.parseInt(horarios.get(i))== lunes){
                    elDia = "Lunes"+String.valueOf(p);
                }else if (Integer.parseInt(horarios.get(i))== martes){
                    elDia = "Martes"+String.valueOf(p);
                }else if (Integer.parseInt(horarios.get(i))== miercoles){
                    elDia = "Miercoles"+String.valueOf(p);
                }else if (Integer.parseInt(horarios.get(i))== jueves){
                    elDia = "Jueves"+String.valueOf(p);
                }else if (Integer.parseInt(horarios.get(i))== viernes){
                    elDia = "Viernes"+String.valueOf(p);
                }                
            }else {
                elDia = "";
                for(int j=2; j<=p; j++){
                   lunes = lunes+19; martes = martes+19; miercoles = miercoles+19; jueves = jueves+19; viernes = viernes+19; 
                }
                if (Integer.parseInt(horarios.get(i))== lunes){
                    elDia = "Lunes"+String.valueOf(p);
                }else if (Integer.parseInt(horarios.get(i))== martes){
                    elDia = "Martes"+String.valueOf(p);
                }else if (Integer.parseInt(horarios.get(i))== miercoles){
                    elDia = "Miercoles"+String.valueOf(p);
                }else if (Integer.parseInt(horarios.get(i))== jueves){
                    elDia = "Jueves"+String.valueOf(p);
                }else if (Integer.parseInt(horarios.get(i))== viernes){
                    elDia = "Viernes"+String.valueOf(p);
                }                
            }
        }
        elDia = Dia(elDia);
        return elDia;
    }
    private int secuenciax(int vuelta,int valor){
        int x;
        if (vuelta == 1){
            x= 0;
        }else{        
            x = valor;            
            for (int i = 2 ; i<vuelta;i++){
                x = x+19;
            }
        }
        return x;
    }
    private int secuenciay(int vuelta,int valor){
        int x;
        if (vuelta == 1){
            x= 18;
        }else{        
            x = valor;            
            for (int i = 1 ; i<vuelta;i++){
                x = x+19;
            }
        }
        return x;
    }    
    private List<String> listado(List<String> horarios){
        System.out.println("Listado "+ horarios.size()/19);
        int materias = horarios.size()/19;
     
        return horarios;
    }
    @Override
    public boolean CrearHorario(String horarios) {
        //System.out.println("horarios " + horarios);
        boolean respuesta = false;
        /*GraphDatabaseService graphDb = null;
        try {
            graphDb = DAOGeneral.IniciarConexion();            
        } catch (UnsupportedOperationException e) {
            Logger.getLogger(DAOHorario.class.getName()).log(Level.SEVERE, null, e);
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        } catch (Exception ex) {
            Logger.getLogger(DAOProfesor.class.getName()).log(Level.SEVERE, null, ex);
        }
        final Map<String, Object> params = MapUtil.map( "Sec_descripcion", "secuenicas" );
        try (Transaction tx = graphDb.beginTx()){*/               
            String str[] = ArreglarListaHorarios(horarios).split("}");
            //System.out.println("DAOHorario "/*+horarios*///);
            /*String id= "";
            ResourceIterator<Node> providers = graphDb.findNodes(DAOProfesor.NodeType.secuenciaID);
            while (providers.hasNext()) {
		final Node recordNode = providers.next();               
                String in = recordNode.getProperty("Sec_horario").toString();
                int number = Integer.parseInt(in);
                id = String.valueOf(number);
                String intTostring = "";
                int idtoint = Integer.parseInt(id);*/            
                for (int i = 0; i<str.length;i++)
                {                   
                    if(str[i].length()>1 && str[i].length()<10){
                          str[i] =  EliminarEspacioEnBlanco(str[i]);
                          str[i] =  Eliminarcomillas(str[i]);
                    }if (str[i].length()>10){
                        str[i] = EliminarPrimerEspacio(str[i]);                        
                    }
                    //System.out.println("STRING "+str[i] + " i: " + i + " Lomgitud "+ str[i].length());
                }
                int numeroMaterias = contarMaterias(str);  
                    //System.out.println("Materias "+ numeroMaterias);
                    List<String> HorarioDias = new ArrayList<>();
                    List<String> Dias = new ArrayList<>();
                    for (int p = 1; p<=numeroMaterias;p++)
                    {
                        //System.out.println("materia: "+p);
                        int y = 18;
                        int h = 19;
                        y = secuenciay(p,y);
                        h = secuenciax(p,h); 
                        //List<String> Dias = new ArrayList<>();
                        for ( int x= h; x<=y; x++){                   
                            System.out.println("Vuelta: "+p + " " +str[x] );
                            //if (str[x].length()<=1){
                                //System.out.println("posicion con longitud menor a 1 "+x); 
                                HorarioDias.add(String.valueOf(x));
                                //String dia = obtenerValorDia(HorarioDias,p);                                
                                //System.out.println("el dia es "+dia);
                               /* if (dia.length()>1)
                                {
                                    Dias.add(dia);
                                }*/
                            //}
                            /*for (int j = 0; j<Dias.size();j++){
                                System.out.println("lista de dias que no son:" + Dias.get(j)+ " Posicion"+ p);
                            }*/
                           /* for (int lh= h; lh<=y; lh++){
                                listaHorarios[lh] = str[x];
                            }  */                         
                            //System.out.println("Longitud "+str[x].length());
                            //Node Horario = graphDb.createNode(DAOHorario.NodeType.Horario);                    
                           /* idtoint = idtoint +1;
                            intTostring = String.valueOf(idtoint);
                            Horario.setProperty("Hor_id", intTostring);
                            Horario.setProperty("Hor_dia","");
                            Horario.setProperty("Hor_hora_inicio", "");
                            Horario.setProperty("Hor_hora_fin", "");
                            Horario.setProperty("Hor_catedra",str[3]);
                            Horario.setProperty("Hor_nrc_catedra", str[0]);
                            Horario.setProperty("Hor_seccion", str[1]);
                            Horario.setProperty("Hor_tipo", "horarios");
                            Horario.setProperty("Hor_salon", "");
                            tx.success();*/
                        }
                        //Dias = EliminarRepetidos(Dias);
                       /* for (int j = 0; j<Dias.size();j++){
                                System.out.println("lista de dias que no son:" + Dias.get(j)+ " Posicion"+ p);
                        }    */                    
                        /*recordNode.setProperty("Sec_horario", intTostring);
                        tx.success();*/
                    }
                    /*List<String> dia = listado(HorarioDias);
                    for (int horDia = 0 ; horDia<dia.size();horDia++){
                        System.out.println("lista de horarios " + dia.get(horDia));
                    }*/
           /* }
            respuesta = true;             
       }catch (NullPointerException NullPointerexcepcion){
            System.out.println("Error en DAOHorario, Función CREAR horario, Excepción NullPointer : " + NullPointerexcepcion);
            respuesta = false;
            throw NullPointerexcepcion;   
        }
        finally{
            graphDb.shutdown();
            System.out.println("SHUTDOWN");
        }*/
        
        return respuesta;
    }    
}
