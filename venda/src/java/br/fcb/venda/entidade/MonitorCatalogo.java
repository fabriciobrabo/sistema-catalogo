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
@Table(name = "monitor_catalogo")
@XmlRootElement
@SequenceGenerator(name = "venda_sequence_monitor_catalogo", sequenceName = "venda_sequence_monitor_catalogo")
@NamedQueries({
    @NamedQuery(name = "MonitorCatalogo.findAll", query = "SELECT m FROM MonitorCatalogo m"),
    @NamedQuery(name = "MonitorCatalogo.findById", query = "SELECT m FROM MonitorCatalogo m WHERE m.id = :id")})
public class MonitorCatalogo implements Serializable {
//    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "venda_sequence_monitor_catalogo")
    @Column(name = "id")
    private Integer id;
    
    @JoinColumn(name = "monitor", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Monitor monitor;
    
    @JoinColumn(name = "catalogo", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Catalogo catalogo;

    public MonitorCatalogo() {
    }

    public MonitorCatalogo(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Monitor getMonitor() {
        return monitor;
    }

    public void setMonitor(Monitor monitor) {
        this.monitor = monitor;
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
        if (!(object instanceof MonitorCatalogo)) {
            return false;
        }
        MonitorCatalogo other = (MonitorCatalogo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.fcb.venda.entidade.MonitorCatalogo[ id=" + id + " ]";
    }
    
}
