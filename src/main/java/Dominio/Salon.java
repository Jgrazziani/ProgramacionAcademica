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
@XmlRootElement(name="salon")
public class Salon extends ENTIDAD{
    public int sal_id;
    public String sal_nombre;
    public Huella sal_huella;
    public List<Horario> sal_horario;

    public Salon() {
        this.sal_id = 0;
        this.sal_nombre = null;
        this.sal_huella = null;
        this.sal_horario = null;
    }
    
    public Salon(int sal_id, String sal_nombre, Huella sal_huella, List<Horario> sal_horario) {
        this.sal_id = sal_id;
        this.sal_nombre = sal_nombre;
        this.sal_huella = sal_huella;
        this.sal_horario = sal_horario;
    }

       @XmlElement(required=true)
    public int getSal_id() {
        return sal_id;
    }

    public void setSal_id(int sal_id) {
        this.sal_id = sal_id;
    }

       @XmlElement(required=true)
    public String getSal_nombre() {
        return sal_nombre;
    }

    public void setSal_nombre(String sal_nombre) {
        this.sal_nombre = sal_nombre;
    }

       @XmlElement(required=true)
    public Huella getSal_huella() {
        return sal_huella;
    }

    public void setSal_huella(Huella sal_huella) {
        this.sal_huella = sal_huella;
    }

       @XmlElement(required=true)
    public List<Horario> getSal_horario() {
        return sal_horario;
    }

    public void setSal_horario(List<Horario> sal_horario) {
        this.sal_horario = sal_horario;
    }
    @Override
    public String toString() {
        return "Salon{" + '"'+"sal_id"+'"'+":"+ sal_id + ","+'"'+"sal_nombre"+'"'+":"+'"'+ sal_nombre +'"'+ ","+'"'+"sal_huella"+'"'+":"+'"'+sal_huella +'"'+ ","+'"'+"sal_horario" +'"'+":"+'"'+ sal_horario + '"'+'}';
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
        hash = 29 * hash + this.sal_id;
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
        final Salon other = (Salon) obj;
        if (this.sal_id != other.sal_id) {
            return false;
        }
        if (!Objects.equals(this.sal_nombre, other.sal_nombre)) {
            return false;
        }
        if (!Objects.equals(this.sal_huella, other.sal_huella)) {
            return false;
        }
        if (!Objects.equals(this.sal_horario, other.sal_horario)) {
            return false;
        }
        return true;
    }
    
}
