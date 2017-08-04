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
                x = x+20;
            }
        }
        return x;
    }
    private int secuenciay(int vuelta,int valor){
        int x;
        if (vuelta == 1){
            x= 19;
        }else{        
            x = valor;            
            for (int i = 1 ; i<vuelta;i++){
                x = x+20;
            }
        }
        return x;
    }    
    private List<String> listado(List<String> horarios){
        System.out.println("Listado "+ horarios.size()/20);
        int materias = horarios.size()/20;
     
        return horarios;
    }
    @Override
    public boolean CrearHorario(String horarios) {
        System.out.println("horario " + horarios);
        boolean respuesta = false;
        String id= "";
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
                    //System.out.println("STRING "+str[i] + " i: " + i + " Lomgitud "+ str[i].length());
                }
                int numeroMaterias = contarMaterias(str);  
                    List<String> HorarioDias = new ArrayList<>();
                    List<String> Dias = new ArrayList<>();
                    String correoProfesor = "";
                    int InicioVuelta = 0;
                    String HoraInicio="";
                    String HoraFin="";
                    String Salon="";
                    String Dia = "";
                    for (int p = 1; p<=numeroMaterias;p++)
                    {   //valor = valor +1;
                        System.out.println("materia: "+p);
                        //int y = 19;
                        //int h = 20;                         
                        //y = secuenciay(p,y);
                        //h = secuenciax(p,h); 
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
                        //for ( int x= h; x<=y; x++){                   
                            //System.out.println("Vuelta: "+p + " " +str[x] );
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
                            tx.success();
                            respuesta = true;
                        //}
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
