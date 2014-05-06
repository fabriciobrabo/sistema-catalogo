/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.fcb.venda.entidade;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ufrastic
 */
@Entity
@Table(name = "representante")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Representante.findAll", query = "SELECT r FROM Representante r"),
    @NamedQuery(name = "Representante.findById", query = "SELECT r FROM Representante r WHERE r.id = :id"),
    @NamedQuery(name = "Representante.findByNome", query = "SELECT r FROM Representante r WHERE r.nome = :nome"),
    @NamedQuery(name = "Representante.findBySobrenome", query = "SELECT r FROM Representante r WHERE r.sobrenome = :sobrenome"),
    @NamedQuery(name = "Representante.findByCpf", query = "SELECT r FROM Representante r WHERE r.cpf = :cpf"),
    @NamedQuery(name = "Representante.findByRg", query = "SELECT r FROM Representante r WHERE r.rg = :rg"),
    @NamedQuery(name = "Representante.findByCep", query = "SELECT r FROM Representante r WHERE r.cep = :cep"),
    @NamedQuery(name = "Representante.findByEndereco", query = "SELECT r FROM Representante r WHERE r.endereco = :endereco"),
    @NamedQuery(name = "Representante.findByBairro", query = "SELECT r FROM Representante r WHERE r.bairro = :bairro"),
    @NamedQuery(name = "Representante.findByCidade", query = "SELECT r FROM Representante r WHERE r.cidade = :cidade"),
    @NamedQuery(name = "Representante.findByEstado", query = "SELECT r FROM Representante r WHERE r.estado = :estado")})
public class Representante implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @Column(name = "sobrenome")
    private String sobrenome;
    @Basic(optional = false)
    @Column(name = "cpf")
    private String cpf;
    @Basic(optional = false)
    @Column(name = "rg")
    private String rg;
    @Basic(optional = false)
    @Column(name = "cep")
    private String cep;
    @Basic(optional = false)
    @Column(name = "endereco")
    private String endereco;
    @Basic(optional = false)
    @Column(name = "bairro")
    private String bairro;
    @Basic(optional = false)
    @Column(name = "cidade")
    private String cidade;
    @Basic(optional = false)
    @Column(name = "estado")
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "representante")
    private List<RepresentanteMonitor> representanteMonitorList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "representante")
    private List<RepresentanteCatalogo> representanteCatalogoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "representante")
    private List<ParceiroRepresentante> parceiroRepresentanteList;

    public Representante() {
    }

    public Representante(Integer id) {
        this.id = id;
    }

    public Representante(Integer id, String nome, String sobrenome, String cpf, String rg, String cep, String endereco, String bairro, String cidade, String estado) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.rg = rg;
        this.cep = cep;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @XmlTransient
    public List<RepresentanteMonitor> getRepresentanteMonitorList() {
        return representanteMonitorList;
    }

    public void setRepresentanteMonitorList(List<RepresentanteMonitor> representanteMonitorList) {
        this.representanteMonitorList = representanteMonitorList;
    }

    @XmlTransient
    public List<RepresentanteCatalogo> getRepresentanteCatalogoList() {
        return representanteCatalogoList;
    }

    public void setRepresentanteCatalogoList(List<RepresentanteCatalogo> representanteCatalogoList) {
        this.representanteCatalogoList = representanteCatalogoList;
    }

    @XmlTransient
    public List<ParceiroRepresentante> getParceiroRepresentanteList() {
        return parceiroRepresentanteList;
    }

    public void setParceiroRepresentanteList(List<ParceiroRepresentante> parceiroRepresentanteList) {
        this.parceiroRepresentanteList = parceiroRepresentanteList;
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
        if (!(object instanceof Representante)) {
            return false;
        }
        Representante other = (Representante) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.fcb.venda.entidade.Representante[ id=" + id + " ]";
    }
    
}