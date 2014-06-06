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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ufrastic
 */
@Entity
@Table(name = "catalogo")
@XmlRootElement
@SequenceGenerator(name = "venda_sequence_catalogo", sequenceName = "venda_sequence_catalogo")
@NamedQueries({
    @NamedQuery(name = "Catalogo.findAll", query = "SELECT c FROM Catalogo c"),
    @NamedQuery(name = "Catalogo.findById", query = "SELECT c FROM Catalogo c WHERE c.id = :id"),
    @NamedQuery(name = "Catalogo.findByNome", query = "SELECT c FROM Catalogo c WHERE c.nome = :nome")})
public class Catalogo implements Serializable {
//    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "venda_sequence_catalgo")
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "nome")
    private String nome;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "catalogo")
    private List<MonitorCatalogo> monitorCatalogoList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "catalogo")
    private List<ParceiroCatalogo> parceiroCatalogoList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "catalogo")
    private List<RepresentanteCatalogo> representanteCatalogoList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "catalogo")
    private List<RevendedorCatalogo> revendedorCatalogoList;

    public Catalogo() {
    }

    public Catalogo(Integer id) {
        this.id = id;
    }

    public Catalogo(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
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

    @XmlTransient
    public List<MonitorCatalogo> getMonitorCatalogoList() {
        return monitorCatalogoList;
    }

    public void setMonitorCatalogoList(List<MonitorCatalogo> monitorCatalogoList) {
        this.monitorCatalogoList = monitorCatalogoList;
    }

    @XmlTransient
    public List<ParceiroCatalogo> getParceiroCatalogoList() {
        return parceiroCatalogoList;
    }

    public void setParceiroCatalogoList(List<ParceiroCatalogo> parceiroCatalogoList) {
        this.parceiroCatalogoList = parceiroCatalogoList;
    }

    @XmlTransient
    public List<RepresentanteCatalogo> getRepresentanteCatalogoList() {
        return representanteCatalogoList;
    }

    public void setRepresentanteCatalogoList(List<RepresentanteCatalogo> representanteCatalogoList) {
        this.representanteCatalogoList = representanteCatalogoList;
    }

    @XmlTransient
    public List<RevendedorCatalogo> getRevendedorCatalogoList() {
        return revendedorCatalogoList;
    }

    public void setRevendedorCatalogoList(List<RevendedorCatalogo> revendedorCatalogoList) {
        this.revendedorCatalogoList = revendedorCatalogoList;
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
        if (!(object instanceof Catalogo)) {
            return false;
        }
        Catalogo other = (Catalogo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.fcb.venda.entidade.Catalogo[ id=" + id + " ]";
    }
    
}
