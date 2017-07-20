/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import java.util.Date;
import java.util.List;

/**
 *
 * @author el_je_000
 */
public class FABRICAENTIDAD {

    public static ENTIDAD obtenerProfesor(int pro_id, String pro_foto, String pro_correo_nombre_usuario, String pro_contraseña, String pro_primer_nombre, String pro_segundo_nombre, String pro_primer_apellido, String pro_segundo_apellido, String pro_tipo, String pro_acerca_de, String pro_como_funciona, List<Rol> pro_rol, List<Preferencia> pro_preferencia, List<Notificacion> pro_notificacion, List<Horario> pro_horario) 
    {
        return new Profesor(pro_id,pro_foto,pro_correo_nombre_usuario,pro_contraseña, pro_primer_nombre,pro_segundo_nombre,pro_primer_apellido,pro_segundo_apellido,pro_tipo,pro_acerca_de,pro_como_funciona,pro_rol,pro_preferencia,pro_notificacion,pro_horario);
    }
    
    public static ENTIDAD obtenerProfesor()
    {
        return new Profesor();
    }
    public static ENTIDAD obtenerPreferencia(int pre_id, String pre_tipo, String pre_nombre, String pre_descripcion, boolean pre_status)
    {
        return new Preferencia(pre_id,pre_tipo,pre_nombre,pre_descripcion,pre_status);
    }
    
    public static ENTIDAD obtenerPreferencia()
    {
        return new Preferencia();
    }  
    public static ENTIDAD obtenerHorario(int hor_id, String hor_dia, Date hor_hora_inicio, Date hor_hora_fin, String hor_catedra, int hor_nrc_catedra, int hor_seccion_catedra, String hor_salon, List<HistoricoAsistencia> hor_asistencia, List<Profesor> hor_profesor)            
    {
        return new Horario(hor_id,hor_dia,hor_hora_inicio,hor_hora_fin,hor_catedra,hor_nrc_catedra,hor_seccion_catedra,hor_salon,hor_asistencia,hor_profesor);
    }

    public static ENTIDAD obtenerHorario()            
    {
        return new Horario();
    }
    
    
}
