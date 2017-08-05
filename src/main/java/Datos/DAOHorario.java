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
        Horario,secuenciaID,Usuario;
    }
    public enum RelationType implements RelationshipType{
        Pertenece_a;
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
        numeroMaterias = (materias.length)/20;        
        return numeroMaterias;
    }
    @Override
    public boolean CrearHorario(String horarios) {
        System.out.println("horario " + horarios);
        boolean respuesta = false;
        String id= "";
        boolean SegundaClase = false;
        GraphDatabaseService graphDb = null;
        try {
            graphDb = DAOGeneral.IniciarConexion();            
        } catch (UnsupportedOperationException e) {
            Logger.getLogger(DAOHorario.class.getName()).log(Level.SEVERE, null, e);
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        } catch (Exception ex) {
            Logger.getLogger(DAOHorario.class.getName()).log(Level.SEVERE, null, ex);
        }
        final Map<String, Object> params = MapUtil.map( "Sec_descripcion", "secuenicas" );
        try (Transaction tx = graphDb.beginTx()){             
            respuesta = true;
            String ultimosDosDigitos= horarios.substring(horarios.length()-2, horarios.length());
            int numeroProfesores = Integer.parseInt(ultimosDosDigitos);
            System.out.println("hay  " + numeroProfesores + " en daoHorario");
            String str[] = ArreglarListaHorarios(horarios).split("}");            
                for (int i = 0; i<str.length;i++)
                {                   
                    if(str[i].length()>1 && str[i].length()<10){
                          str[i] =  EliminarEspacioEnBlanco(str[i]);
                          str[i] =  Eliminarcomillas(str[i]);
                    }if (str[i].length()>10){
                        str[i] = EliminarPrimerEspacio(str[i]);                        
                    }
                }
                int numeroMaterias = contarMaterias(str);  
                    String correoProfesor = "";
                    int InicioVuelta = 0;
                    String HoraInicio="";
                    String HoraFin="";
                    String Salon="";
                    String Dia = "";
                    String HoraInicio2="";
                    String HoraFin2="";
                    String Salon2="";
                    String Dia2 = "";
                    for (int p = 1; p<=numeroMaterias;p++)
                    {   
                        System.out.println("materia: "+p);
                        ResourceIterator<Node> providers = graphDb.findNodes(NodeType.secuenciaID);
                        while (providers.hasNext()) {
                            final Node recordNode = providers.next();               
                            String i = recordNode.getProperty("Sec_horario").toString();
                            int number = Integer.parseInt(i);
                            number = number + 1;
                            id = String.valueOf(number);
                            recordNode.setProperty("Sec_horario", id);
                            tx.success();
                        }                                        
                        if (p==1){
                            System.out.println("p igual a 1");
                            InicioVuelta =0;
                        }else if(p>1) {
                            System.out.println("p mayor a 1");
                            InicioVuelta = InicioVuelta+20;
                        }
                            correoProfesor = str[InicioVuelta+19];
                            System.out.println("correo del profesor "+correoProfesor);
                            Node Horario = graphDb.createNode(DAOHorario.NodeType.Horario);                    
                            if (str[InicioVuelta+4]!="" && str[InicioVuelta+4].length()>=8){
                                HoraInicio = str[InicioVuelta+4].substring(0,str[InicioVuelta+4].length()-3);
                                HoraFin = str[InicioVuelta+5].substring(0,str[InicioVuelta+5].length()-3);
                                Salon = str[InicioVuelta+6];
                                Dia = "Lunes";
                            }else if (str[InicioVuelta+7]!="" && str[InicioVuelta+7].length()>=8){
                                HoraInicio = str[InicioVuelta+7].substring(0,str[InicioVuelta+7].length()-3);
                                HoraFin = str[InicioVuelta+8].substring(0,str[InicioVuelta+8].length()-3);
                                Salon = str[InicioVuelta+9];
                                Dia = "Martes";
                            }else if (str[InicioVuelta+10]!="" && str[InicioVuelta+10].length()>=8){
                                HoraInicio = str[InicioVuelta+10].substring(0,str[InicioVuelta+10].length()-3);
                                HoraFin = str[InicioVuelta+11].substring(0,str[InicioVuelta+11].length()-3);
                                Salon = str[InicioVuelta+12]; 
                                Dia = "Miercoles";
                            }else if (str[InicioVuelta+13]!="" && str[InicioVuelta+13].length()>=8){
                                HoraInicio = str[InicioVuelta+13].substring(0,str[InicioVuelta+13].length()-3);
                                HoraFin = str[InicioVuelta+14].substring(0,str[InicioVuelta+14].length()-3);
                                Salon = str[InicioVuelta+15];
                                Dia = "Jueves";
                            }else if (str[InicioVuelta+16]!="" && str[InicioVuelta+16].length()>=8){
                                HoraInicio = str[InicioVuelta+16].substring(0,str[InicioVuelta+16].length()-3);
                                HoraFin = str[InicioVuelta+17].substring(0,str[InicioVuelta+17].length()-3);
                                Salon = str[InicioVuelta+18];
                                Dia = "Viernes";
                            }                            
                            Horario.setProperty("Hor_id", id);
                            Horario.setProperty("Hor_dia",Dia);
                            Horario.setProperty("Hor_hora_inicio", HoraInicio);
                            Horario.setProperty("Hor_hora_fin", HoraFin);
                            Horario.setProperty("Hor_catedra",str[InicioVuelta+3]);
                            Horario.setProperty("Hor_nrc_catedra", str[InicioVuelta]);
                            Horario.setProperty("Hor_seccion", str[InicioVuelta+1]);
                            Horario.setProperty("Hor_tipo", "horarios");
                            Horario.setProperty("Hor_salon", Salon); 
                            ResourceIterator<Node> providers1 = graphDb.findNodes(NodeType.Usuario);
                            while (providers1.hasNext()) {
                                final Node recordNode1 = providers1.next();               
                                if (recordNode1.getProperty("Usu_correo").toString().equals(correoProfesor))
                                {   
                                    recordNode1.createRelationshipTo(Horario, RelationType.Pertenece_a);
                                }
                                else {
                                    System.out.println("No encontrado "  + recordNode1.getProperty("Usu_correo"));
                                }
                            }                            
                            tx.success();                            
                            
                           if (str[InicioVuelta+7]!="" && str[InicioVuelta+7].length()>=8 && Dia!="Martes"){
                                HoraInicio2 = str[InicioVuelta+7].substring(0,str[InicioVuelta+7].length()-3);
                                HoraFin2 = str[InicioVuelta+8].substring(0,str[InicioVuelta+8].length()-3);
                                Salon2 = str[InicioVuelta+9];
                                Dia2 = "Martes";                                
                            }else if(str[InicioVuelta+10]!="" && str[InicioVuelta+10].length()>=8 && Dia != "Miercoles"){
                                HoraInicio2 = str[InicioVuelta+10].substring(0,str[InicioVuelta+10].length()-3);
                                HoraFin2 = str[InicioVuelta+11].substring(0,str[InicioVuelta+11].length()-3);
                                Salon2 = str[InicioVuelta+12]; 
                                Dia2 = "Miercoles";                                
                            }else if(str[InicioVuelta+13]!="" && str[InicioVuelta+13].length()>=8 && Dia!="Jueves"){
                                HoraInicio2 = str[InicioVuelta+13].substring(0,str[InicioVuelta+13].length()-3);
                                HoraFin2 = str[InicioVuelta+14].substring(0,str[InicioVuelta+14].length()-3);
                                Salon2 = str[InicioVuelta+15];
                                Dia2 = "Jueves";                                
                            }else if(str[InicioVuelta+16]!="" && str[InicioVuelta+16].length()>=8 && Dia!="Viernes"){
                                HoraInicio2 = str[InicioVuelta+16].substring(0,str[InicioVuelta+16].length()-3);
                                HoraFin2 = str[InicioVuelta+17].substring(0,str[InicioVuelta+17].length()-3);
                                Salon2 = str[InicioVuelta+18];
                                Dia2 = "Viernes";                                
                            }
                            if (HoraInicio2.length()>1 && HoraFin2.length()>1 && Salon2.length()>1 && Dia2.length()>1){
                                String id2="";
                                ResourceIterator<Node> providersS = graphDb.findNodes(NodeType.secuenciaID);
                                while (providersS.hasNext()) {
                                    final Node recordNodeS = providersS.next();               
                                    String i = recordNodeS.getProperty("Sec_horario").toString();
                                    int number = Integer.parseInt(i);
                                    number = number + 1;
                                    id2 = String.valueOf(number);
                                    recordNodeS.setProperty("Sec_horario", id2);
                                    tx.success();
                                }                                        
                                Node Horario1 = graphDb.createNode(DAOHorario.NodeType.Horario);
                                Horario1.setProperty("Hor_id", id2);
                                Horario1.setProperty("Hor_dia",Dia2);
                                Horario1.setProperty("Hor_hora_inicio", HoraInicio2);
                                Horario1.setProperty("Hor_hora_fin", HoraFin2);
                                Horario1.setProperty("Hor_catedra",str[InicioVuelta+3]);
                                Horario1.setProperty("Hor_nrc_catedra", str[InicioVuelta]);
                                Horario1.setProperty("Hor_seccion", str[InicioVuelta+1]);
                                Horario1.setProperty("Hor_tipo", "horarios");
                                Horario1.setProperty("Hor_salon", Salon2); 
                                ResourceIterator<Node> providers2 = graphDb.findNodes(NodeType.Usuario);
                                while (providers2.hasNext()) {
                                    final Node recordNode2 = providers2.next();               
                                    if (recordNode2.getProperty("Usu_correo").toString().equals(correoProfesor))
                                    {   
                                        recordNode2.createRelationshipTo(Horario1, RelationType.Pertenece_a);
                                    }
                                    else {
                                        System.out.println("No encontrado "  + recordNode2.getProperty("Usu_correo"));
                                    }
                                }

                                tx.success();                                
                            }                                                                    
                            respuesta = true;
                    }                 
            }
            catch (NullPointerException NullPointerexcepcion){
            System.out.println("Error en DAOHorario, Función CREAR horario, Excepción NullPointer : " + NullPointerexcepcion);
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
