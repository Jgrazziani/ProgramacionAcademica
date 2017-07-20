/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;
import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
/**
 *
 * @author el_je_000
 */
@XmlRootElement(name="profesor")
public class Profesor extends ENTIDAD{
    public int pro_id;
    public String pro_foto;
    public String pro_correo_nombre_usuario;
    public String pro_contraseña;
    public String pro_primer_nombre;
    public String pro_segundo_nombre;
    public String pro_primer_apellido;
    public String pro_segundo_apellido;
    public String pro_tipo;
    public String pro_acerca_de;
    public String pro_como_funciona;
    public List<Rol> pro_rol;
    public List<Preferencia> pro_preferencia;
    public List<Notificacion> pro_notificacion;
    public List<Horario> pro_horario;
    
    public Profesor() {
        this.pro_id = 0;
        this.pro_foto = null;
        this.pro_correo_nombre_usuario = null;
        this.pro_contraseña = null;
        this.pro_primer_nombre = null;
        this.pro_segundo_nombre = null;
        this.pro_primer_apellido = null;
        this.pro_segundo_apellido = null;
        this.pro_tipo = null;
        this.pro_acerca_de = null;
        this.pro_como_funciona = null;
        this.pro_rol = null;
        this.pro_preferencia = null;
        this.pro_notificacion = null;
        this.pro_horario = null;
    }

    public Profesor(int pro_id, String pro_foto, String pro_correo_nombre_usuario, String pro_contraseña, String pro_primer_nombre, String pro_segundo_nombre, String pro_primer_apellido, String pro_segundo_apellido, String pro_tipo, String pro_acerca_de, String pro_como_funciona, List<Rol> pro_rol, List<Preferencia> pro_preferencia, List<Notificacion> pro_notificacion, List<Horario> pro_horario) {
        this.pro_id = pro_id;
        this.pro_foto = pro_foto;
        this.pro_correo_nombre_usuario = pro_correo_nombre_usuario;
        this.pro_contraseña = pro_contraseña;
        this.pro_primer_nombre = pro_primer_nombre;
        this.pro_segundo_nombre = pro_segundo_nombre;
        this.pro_primer_apellido = pro_primer_apellido;
        this.pro_segundo_apellido = pro_segundo_apellido;
        this.pro_tipo = pro_tipo;
        this.pro_acerca_de = pro_acerca_de;
        this.pro_como_funciona = pro_como_funciona;
        this.pro_rol = pro_rol;
        this.pro_preferencia = pro_preferencia;
        this.pro_notificacion = pro_notificacion;
        this.pro_horario = pro_horario;
    }

       @XmlElement(required=true)
    public int getPro_id() {
        return pro_id;
    }

    public void setPro_id(int pro_id) {
        this.pro_id = pro_id;
    }

    public String getPro_foto() {
        return pro_foto;
    }

    public void setPro_foto(String pro_foto) {
        this.pro_foto = pro_foto;
    }

       @XmlElement(required=true)
    public String getPro_correo_nombre_usuario() {
        return pro_correo_nombre_usuario;
    }

    public void setPro_correo_nombre_usuario(String pro_correo_nombre_usuario) {
        this.pro_correo_nombre_usuario = pro_correo_nombre_usuario;
    }

       @XmlElement(required=true)
    public String getPro_contraseña() {
        return pro_contraseña;
    }

    public void setPro_contraseña(String pro_contraseña) {
        this.pro_contraseña = pro_contraseña;
    }

       @XmlElement(required=true)
    public String getPro_primer_nombre() {
        return pro_primer_nombre;
    }

    public void setPro_primer_nombre(String pro_primer_nombre) {
        this.pro_primer_nombre = pro_primer_nombre;
    }

    public String getPro_segundo_nombre() {
        return pro_segundo_nombre;
    }

    public void setPro_segundo_nombre(String pro_segundo_nombre) {
        this.pro_segundo_nombre = pro_segundo_nombre;
    }

       @XmlElement(required=true)
    public String getPro_primer_apellido() {
        return pro_primer_apellido;
    }

    public void setPro_primer_apellido(String pro_primer_apellido) {
        this.pro_primer_apellido = pro_primer_apellido;
    }
    
   @XmlElement(required=true)
    public String getPro_segundo_apellido() {
        return pro_segundo_apellido;
    }

    
    public void setPro_segundo_apellido(String pro_segundo_apellido) {
        this.pro_segundo_apellido = pro_segundo_apellido;
    }
    
    @XmlElement(required=true)
    public String getPro_tipo() {
        return pro_tipo;
    }

    public void setPro_tipo(String pro_tipo) {
        this.pro_tipo = pro_tipo;
    }


       @XmlElement(required=true)
    public String getPro_acerca_de() {
        return pro_acerca_de;
    }

    public void setPro_acerca_de(String pro_acerca_de) {
        this.pro_acerca_de = pro_acerca_de;
    }

       @XmlElement(required=true)
    public String getPro_como_funciona() {
        return pro_como_funciona;
    }

    public void setPro_como_funciona(String pro_como_funciona) {
        this.pro_como_funciona = pro_como_funciona;
    }

       @XmlElement(required=true)
    public List<Rol> getPro_rol() {
        return pro_rol;
    }

    public void setPro_rol(List<Rol> pro_rol) {
        this.pro_rol = pro_rol;
    }

       @XmlElement(required=true)
    public List<Preferencia> getPro_preferencia() {
        return pro_preferencia;
    }

    public void setPro_preferencia(List<Preferencia> pro_preferencia) {
        this.pro_preferencia = pro_preferencia;
    }

    
    public List<Notificacion> getPro_notificacion() {
        return pro_notificacion;
    }

    public void setPro_notificacion(List<Notificacion> pro_notificacion) {
        this.pro_notificacion = pro_notificacion;
    }

       @XmlElement(required=true)
    public List<Horario> getPro_horario() {
        return pro_horario;
    }

    public void setPro_horario(List<Horario> pro_horario) {
        this.pro_horario = pro_horario;
    }
    
    @Override
    public String toString() {
        return "Profesor{" + '"'+"pro_id"+'"'+":"+ pro_id + ","+'"'+"pro_foto"+'"'+":"+'"'+ pro_foto +'"'+ ","+'"'+"pro_correo_nombre_usuario"+'"'+":"+'"'+pro_correo_nombre_usuario +'"'+ ","+'"'+"pro_contraseña" +'"'+":"+'"'+ pro_contraseña +'"'+ ","+'"'+"pro_primer_nombre" +'"'+":"+ '"'+pro_primer_nombre +'"'+ ","+'"'+"pro_segundo_nombre" +'"'+":"+ '"'+pro_segundo_nombre +'"'+ ","+'"'+"pro_primer_apellido" +'"'+":"+ '"'+pro_primer_apellido +'"'+ ","+'"'+"pro_segundo_apellido" +'"'+":"+ '"'+pro_segundo_apellido +'"'+ ","+'"'+"pro_tipo" +'"'+":"+ '"'+pro_tipo +'"'+ ","+'"'+"pro_acerca_de" +'"'+":"+ '"'+pro_acerca_de +'"'+ ","+'"'+"pro_como_funciona" +'"'+":"+ '"'+pro_como_funciona +'"'+ ","+'"'+"pro_rol" +'"'+":"+ '"'+pro_rol +'"'+ ","+'"'+"pro_preferencia" +'"'+":"+ '"'+pro_preferencia +'"'+ ","+'"'+"pro_notificacion" +'"'+":"+ '"'+pro_notificacion +'"'+ ","+'"'+"pro_horario" +'"'+":"+ '"'+pro_horario + '"'+'}';
    }

    public String toJson(){
    
        Gson gson = new Gson();
 
	// convert java object to JSON format,
	// and returned as JSON formatted string
	String json = gson.toJson(this);
 
	try {
		//write converted json data to a file named "file.json"
		FileWriter writer = new FileWriter("c:\\file.json");
		writer.write(json);
		writer.close();
                return json;
 
	} catch (IOException e) {
		e.printStackTrace();
	}
        
       return null;         
    } 

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.pro_id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Profesor other = (Profesor) obj;
        if (this.pro_id != other.pro_id) {
            return false;
        }
        if (!Objects.equals(this.pro_tipo , other.pro_tipo)){
            return false;
        }
        if (!Objects.equals(this.pro_foto, other.pro_foto)) {
            return false;
        }
        if (!Objects.equals(this.pro_correo_nombre_usuario, other.pro_correo_nombre_usuario)) {
            return false;
        }
        if (!Objects.equals(this.pro_contraseña, other.pro_contraseña)) {
            return false;
        }
        if (!Objects.equals(this.pro_primer_nombre, other.pro_primer_nombre)) {
            return false;
        }
        if (!Objects.equals(this.pro_segundo_nombre, other.pro_segundo_nombre)) {
            return false;
        }
        if (!Objects.equals(this.pro_primer_apellido, other.pro_primer_apellido)) {
            return false;
        }
        if (!Objects.equals(this.pro_segundo_apellido, other.pro_segundo_apellido)) {
            return false;
        }
        if (!Objects.equals(this.pro_acerca_de, other.pro_acerca_de)) {
            return false;
        }
        if (!Objects.equals(this.pro_como_funciona, other.pro_como_funciona)) {
            return false;
        }
        if (!Objects.equals(this.pro_rol, other.pro_rol)) {
            return false;
        }
        if (!Objects.equals(this.pro_preferencia, other.pro_preferencia)) {
            return false;
        }
        if (!Objects.equals(this.pro_notificacion, other.pro_notificacion)) {
            return false;
        }
        if (!Objects.equals(this.pro_horario, other.pro_horario)) {
            return false;
        }
        return true;
    }
    
    
}
