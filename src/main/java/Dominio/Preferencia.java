/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author el_je_000
 */
@XmlRootElement(name="preferencia")
public class Preferencia extends ENTIDAD{
    public int pre_id;
    public String pre_tipo;
    public String pre_nombre;
    public String pre_descripcion;
    public boolean pre_status;

    public Preferencia() {
        this.pre_id = 0;
        this.pre_tipo = null;
        this.pre_nombre = null;
        this.pre_descripcion = null;
        this.pre_status = false;
    }
        
    public Preferencia(int pre_id, String pre_tipo, String pre_nombre, String pre_descripcion, boolean pre_status) {
        this.pre_id = pre_id;
        this.pre_tipo = pre_tipo;
        this.pre_nombre = pre_nombre;
        this.pre_descripcion = pre_descripcion;
        this.pre_status = pre_status;
    }

       @XmlElement(required=true)
    public int getPre_id() {
        return pre_id;
    }

    public void setPre_id(int pre_id) {
        this.pre_id = pre_id;
    }

       @XmlElement(required=true)
    public String getPre_tipo() {
        return pre_tipo;
    }

    public void setPre_tipo(String pre_tipo) {
        this.pre_tipo = pre_tipo;
    }

       @XmlElement(required=true)
    public String getPre_nombre() {
        return pre_nombre;
    }

    public void setPre_nombre(String pre_nombre) {
        this.pre_nombre = pre_nombre;
    }

       @XmlElement(required=true)
    public String getPre_descripcion() {
        return pre_descripcion;
    }

    public void setPre_descripcion(String pre_descripcion) {
        this.pre_descripcion = pre_descripcion;
    }

       @XmlElement(required=true)
    public boolean getPre_status() {
        return pre_status;
    }

    public void setPre_status(boolean pre_status) {
        this.pre_status = pre_status;
    }
  
    @Override
    public String toString() {
        return "Preferencia{" + '"'+"pre_id"+'"'+":"+ pre_id + ","+'"'+"pre_tipo"+'"'+":"+'"'+ pre_tipo +'"'+ ","+'"'+"pre_nombre"+'"'+":"+'"'+pre_nombre +'"'+ ","+'"'+"pre_descripcion" +'"'+":"+'"'+ pre_descripcion +'"'+ ","+'"'+"pre_status" +'"'+":"+ '"'+ pre_status + '"'+'}';
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
        int hash = 7;
        hash = 31 * hash + this.pre_id;
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
        final Preferencia other = (Preferencia) obj;
        if (this.pre_id != other.pre_id) {
            return false;
        }
        if (this.pre_status != other.pre_status) {
            return false;
        }
        if (!Objects.equals(this.pre_tipo, other.pre_tipo)) {
            return false;
        }
        if (!Objects.equals(this.pre_nombre, other.pre_nombre)) {
            return false;
        }
        if (!Objects.equals(this.pre_descripcion, other.pre_descripcion)) {
            return false;
        }
        return true;
    }
    
    
}
