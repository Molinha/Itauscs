package br.com.itauscs.model;

import javax.persistence.*;

@Entity
public class Acaunt extends AbstractEntity {

    private String acauntNumber;
    private long clientId;
    public long agencyId;
    private double acauntBalance;
    private double acauntLimit;

    public double getAcauntBalance() {
        return acauntBalance;
    }

    public void setAcauntBalance(double acauntBalance) {
        this.acauntBalance = acauntBalance;
    }

    public double getAcauntLimit() {
        return acauntLimit;
    }

    public void setAcauntLimit(double acauntLimit) {
        this.acauntLimit = acauntLimit;
    }

    public String getAcauntNumber() {
        return acauntNumber;
    }

    public void setAcauntNumber(String acauntNumber) {
        this.acauntNumber = acauntNumber;
    }

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    public long getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(long agencyId) {
        this.agencyId = agencyId;
    }
}
