/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.fcb.venda.entidade;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ufrastic
 */
@Entity
@Table(name = "representante_catalogo")
@XmlRootElement
@SequenceGenerator(name = "venda_sequence_representante_catalogo", sequenceName = "venda_sequence_representante_catalogo")
@NamedQueries({
    @NamedQuery(name = "RepresentanteCatalogo.findAll", query = "SELECT r FROM RepresentanteCatalogo r"),
    @NamedQuery(name = "RepresentanteCatalogo.findById", query = "SELECT r FROM RepresentanteCatalogo r WHERE r.id = :id")})
public class RepresentanteCatalogo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "venda_sequence_representante_catalogo")
    @Column(name = "id")
    private Integer id;
    
    @JoinColumn(name = "representante", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Representante representante;
    
    @JoinColumn(name = "catalogo", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Catalogo catalogo;

    public RepresentanteCatalogo() {
    }

    public RepresentanteCatalogo(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Representante getRepresentante() {
        return representante;
    }

    public void setRepresentante(Representante representante) {
        this.representante = representante;
    }

    public Catalogo getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(Catalogo catalogo) {
        this.catalogo = catalogo;
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
        if (!(object instanceof RepresentanteCatalogo)) {
            return false;
        }
        RepresentanteCatalogo other = (RepresentanteCatalogo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.fcb.venda.entidade.RepresentanteCatalogo[ id=" + id + " ]";
    }
    
}
