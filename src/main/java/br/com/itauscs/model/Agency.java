package br.com.itauscs.model;

import javax.persistence.Entity;

@Entity
public class Agency extends AbstractEntity{

    public int numberAgency;
    public String addresAgency;

    public int getNumberAgency() {
        return numberAgency;
    }

    public void setNumberAgency(int numberAgency) {
        this.numberAgency = numberAgency;
    }

    public String getAddresAgency() {
        return addresAgency;
    }

    public void setAddresAgency(String addresAgency) {
        this.addresAgency = addresAgency;
    }


}
