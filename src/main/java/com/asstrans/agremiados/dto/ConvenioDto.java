package com.asstrans.agremiados.dto;

import com.asstrans.agremiados.enums.ZoneCity;

public class ConvenioDto {

    private Long id;
    private String cnpj;

    private ZoneCity zoneCity;

    private String stateResgistration;

    private String municipalResgistration;

    private String address;

    private String fantasyName;

    private String corporateName;

    private String responsible;

    private String tel;

    private String fax;

    private String phoneStores;

    private String referencePoint;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public ZoneCity getZoneCity() {
        return zoneCity;
    }

    public void setZoneCity(ZoneCity zoneCity) {
        this.zoneCity = zoneCity;
    }

    public String getStateResgistration() {
        return stateResgistration;
    }

    public void setStateResgistration(String stateResgistration) {
        this.stateResgistration = stateResgistration;
    }

    public String getMunicipalResgistration() {
        return municipalResgistration;
    }

    public void setMunicipalResgistration(String municipalResgistration) {
        this.municipalResgistration = municipalResgistration;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFantasyName() {
        return fantasyName;
    }

    public void setFantasyName(String fantasyName) {
        this.fantasyName = fantasyName;
    }

    public String getCorporateName() {
        return corporateName;
    }

    public void setCorporateName(String corporateName) {
        this.corporateName = corporateName;
    }

    public String getResponsible() {
        return responsible;
    }

    public void setResponsible(String responsible) {
        this.responsible = responsible;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getPhoneStores() {
        return phoneStores;
    }

    public void setPhoneStores(String phoneStores) {
        this.phoneStores = phoneStores;
    }

    public String getReferencePoint() {
        return referencePoint;
    }

    public void setReferencePoint(String referencePoint) {
        this.referencePoint = referencePoint;
    }
}
