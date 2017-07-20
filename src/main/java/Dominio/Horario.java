/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;
import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author el_je_000
 */
@XmlRootElement(name="horario")
public class Horario extends ENTIDAD {
    public int hor_id;
    public String hor_dia;
    public Date hor_hora_inicio;
    public Date hor_hora_fin;
    public String hor_catedra;
    public int hor_nrc_catedra;
    public int hor_seccion_catedra;
    public String hor_salon;
    public List<HistoricoAsistencia> hor_asistencia;
    public List<Profesor> hor_profesor;

    public Horario() {
        this.hor_id = 0;
        this.hor_dia = null;
        this.hor_hora_inicio = null;
        this.hor_hora_fin = null;
        this.hor_catedra = null;
        this.hor_nrc_catedra = 0;
        this.hor_seccion_catedra = 0;
        this.hor_salon = null;
        this.hor_asistencia = null;
        this.hor_profesor = null;
    }
    
    
    public Horario(int hor_id, String hor_dia, Date hor_hora_inicio, Date hor_hora_fin, String hor_catedra, int hor_nrc_catedra, int hor_seccion_catedra, String hor_salon, List<HistoricoAsistencia> hor_asistencia, List<Profesor> hor_profesor) {
        this.hor_id = hor_id;
        this.hor_dia = hor_dia;
        this.hor_hora_inicio = hor_hora_inicio;
        this.hor_hora_fin = hor_hora_fin;
        this.hor_catedra = hor_catedra;
        this.hor_nrc_catedra = hor_nrc_catedra;
        this.hor_seccion_catedra = hor_seccion_catedra;
        this.hor_salon = hor_salon;
        this.hor_asistencia = hor_asistencia;
        this.hor_profesor = hor_profesor;
    }

       @XmlElement(required=true)
    public int getHor_id() {
        return hor_id;
    }

    public void setHor_id(int hor_id) {
        this.hor_id = hor_id;
    }
    
   @XmlElement(required=true)
    public String getHor_dia() {
        return hor_dia;
    }

    public void setHor_dia(String hor_dia) {
        this.hor_dia = hor_dia;
    }

       @XmlElement(required=true)
    public Date getHor_hora_inicio() {
        return hor_hora_inicio;
    }

    public void setHor_hora_inicio(Date hor_hora_inicio) {
        this.hor_hora_inicio = hor_hora_inicio;
    }
    
   @XmlElement(required=true)
    public Date getHor_hora_fin() {
        return hor_hora_fin;
    }

    public void setHor_hora_fin(Date hor_hora_fin) {
        this.hor_hora_fin = hor_hora_fin;
    }

       @XmlElement(required=true)
    public String getHor_catedra() {
        return hor_catedra;
    }

    public void setHor_catedra(String hor_catedra) {
        this.hor_catedra = hor_catedra;
    }
    
   @XmlElement(required=true)
    public int getHor_nrc_catedra() {
        return hor_nrc_catedra;
    }

    public void setHor_nrc_catedra(int hor_nrc_catedra) {
        this.hor_nrc_catedra = hor_nrc_catedra;
    }

       @XmlElement(required=true)
    public int getHor_seccion_catedra() {
        return hor_seccion_catedra;
    }

    public void setHor_seccion_catedra(int hor_seccion_catedra) {
        this.hor_seccion_catedra = hor_seccion_catedra;
    }

    public String getHor_salon() {
        return hor_salon;
    }

    public void setHor_salon(String hor_salon) {
        this.hor_salon = hor_salon;
    }

       @XmlElement(required=true)
    public List<HistoricoAsistencia> getHor_asistencia() {
        return hor_asistencia;
    }

    public void setHor_asistencia(List<HistoricoAsistencia> hor_asistencia) {
        this.hor_asistencia = hor_asistencia;
    }

       @XmlElement(required=true)
    public List<Profesor> getHor_profesor() {
        return hor_profesor;
    }

    public void setHor_profesor(List<Profesor> hor_profesor) {
        this.hor_profesor = hor_profesor;
    }
    
    @Override
    public String toString() {
        return "Horario{" + '"'+"hor_id"+'"'+":"+ hor_id + ","+'"'+"hor_dia"+'"'+":"+'"'+ hor_dia +'"'+ ","+'"'+"hor_hora_inicio"+'"'+":"+'"'+hor_hora_inicio +'"'+ ","+'"'+"hor_hora_fin" +'"'+":"+'"'+ hor_hora_fin +'"'+ ","+'"'+"hor_catedra" +'"'+":"+ '"'+hor_catedra +'"'+ ","+'"'+"hor_seccion_catedra" +'"'+":"+ '"'+hor_seccion_catedra +'"'+ ","+'"'+"hor_salon" +'"'+":"+ '"'+hor_salon +'"'+ ","+'"'+"hor_asistencia" +'"'+":"+ '"'+hor_asistencia +'"'+ ","+'"'+"hor_profesor" +'"'+":"+ '"'+hor_profesor + '"'+'}';
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
        int hash = 3;
        hash = 47 * hash + this.hor_id;
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
        final Horario other = (Horario) obj;
        if (this.hor_id != other.hor_id) {
            return false;
        }
        if (this.hor_nrc_catedra != other.hor_nrc_catedra) {
            return false;
        }
        if (this.hor_seccion_catedra != other.hor_seccion_catedra) {
            return false;
        }
        if (!Objects.equals(this.hor_dia, other.hor_dia)) {
            return false;
        }
        if (!Objects.equals(this.hor_catedra, other.hor_catedra)) {
            return false;
        }
        if (!Objects.equals(this.hor_hora_inicio, other.hor_hora_inicio)) {
            return false;
        }
        if (!Objects.equals(this.hor_hora_fin, other.hor_hora_fin)) {
            return false;
        }
        if (!Objects.equals(this.hor_salon, other.hor_salon)) {
            return false;
        }
        if (!Objects.equals(this.hor_asistencia, other.hor_asistencia)) {
            return false;
        }
        if (!Objects.equals(this.hor_profesor, other.hor_profesor)) {
            return false;
        }
        return true;
    }
    
}
