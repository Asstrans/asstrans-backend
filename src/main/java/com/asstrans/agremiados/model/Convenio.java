package com.asstrans.agremiados.model;

import com.asstrans.agremiados.enums.ZoneCity;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "TB_CONVENIOS")
public class Convenio implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 250)
    private String cnpj;

    @Enumerated(EnumType.STRING)
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

    private Boolean isActive;

//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
//    @OneToMany(mappedBy = "convenio", fetch = FetchType.LAZY)
//    @Fetch(FetchMode.SUBSELECT)
//    private Set<Requisicao> requisicoes;

    public Convenio() {
        this.isActive = true;
    }

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

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
//
//    public Set<Requisicao> getRequisicoes() {
//        return requisicoes;
//    }
//
//    public void setRequisicoes(Set<Requisicao> requisicoes) {
//        this.requisicoes = requisicoes;
//    }
}
