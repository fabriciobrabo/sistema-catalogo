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
@Table(name = "parceiro_representante")
@XmlRootElement
@SequenceGenerator(name = "venda_sequence_parceiro_representante", sequenceName = "venda_sequence_parceiro_representante")
@NamedQueries({
    @NamedQuery(name = "ParceiroRepresentante.findAll", query = "SELECT p FROM ParceiroRepresentante p"),
    @NamedQuery(name = "ParceiroRepresentante.findById", query = "SELECT p FROM ParceiroRepresentante p WHERE p.id = :id")})
public class ParceiroRepresentante implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "venda_sequence_parceiro_representante")
    @Column(name = "id")
    private Integer id;
    
    @JoinColumn(name = "representante", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Representante representante;
    
    @JoinColumn(name = "parceiro", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Parceiro parceiro;

    public ParceiroRepresentante() {
    }

    public ParceiroRepresentante(Integer id) {
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

    public Parceiro getParceiro() {
        return parceiro;
    }

    public void setParceiro(Parceiro parceiro) {
        this.parceiro = parceiro;
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
        if (!(object instanceof ParceiroRepresentante)) {
            return false;
        }
        ParceiroRepresentante other = (ParceiroRepresentante) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.fcb.venda.entidade.ParceiroRepresentante[ id=" + id + " ]";
    }
    
}
