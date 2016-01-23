/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bll;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Heidi
 */
@Entity
public class Hond implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String Beschrijving;
    private String Naam;
    private String Ras;
    private Integer Leeftijd;
    private String Geslacht;
    private String Foto;
    private boolean Adopteren;
    
    public Hond() {
    }
    
    public Hond(Long id, String Beschrijving, String Naam, String Ras, Integer Leeftijd, String Geslacht, String Foto, Boolean Adopteren){
     
        this.id = id;
        this.Beschrijving = Beschrijving;
        this.Naam = Naam;
        this.Ras = Ras;
        this.Leeftijd = Leeftijd;
        this.Geslacht = Geslacht;
        this.Foto = Foto;
        this.Adopteren = Adopteren;
        
    }
    
    
    
    
    
            
    
    
            

    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hond)) {
            return false;
        }
        Hond other = (Hond) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return Naam;
    }

    /**
     * @return the Beschrijving
     */
    public String getBeschrijving() {
        return Beschrijving;
    }

    /**
     * @param Beschrijving the Beschrijving to set
     */
    public void setBeschrijving(String Beschrijving) {
        this.Beschrijving = Beschrijving;
    }

    /**
     * @return the Naam
     */
    public String getNaam() {
        return Naam;
    }

    /**
     * @param Naam the Naam to set
     */
    public void setNaam(String Naam) {
        this.Naam = Naam;
    }

    /**
     * @return the Ras
     */
    public String getRas() {
        return Ras;
    }

    /**
     * @param Ras the Ras to set
     */
    public void setRas(String Ras) {
        this.Ras = Ras;
    }

    /**
     * @return the Leeftijd
     */
    public Integer getLeeftijd() {
        return Leeftijd;
    }

    /**
     * @param Leeftijd the Leeftijd to set
     */
    public void setLeeftijd(Integer Leeftijd) {
        this.Leeftijd = Leeftijd;
    }

    /**
     * @return the Geslacht
     */
    public String getGeslacht() {
        return Geslacht;
    }

    /**
     * @param Geslacht the Geslacht to set
     */
    public void setGeslacht(String Geslacht) {
        this.Geslacht = Geslacht;
    }

    /**
     * @return the Adopteren
     */
    public boolean isAdopteren() {
        return Adopteren;
    }

    /**
     * @param Adopteren the Adopteren to set
     */
    public void setAdopteren(boolean Adopteren) {
        this.Adopteren = Adopteren;
    }

    /**
     * @return the Foto
     */
    public String getFoto() {
        return Foto;
    }

    /**
     * @param Foto the Foto to set
     */
    public void setFoto(String Foto) {
        this.Foto = Foto;
    }

    public String getAdopteren() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
