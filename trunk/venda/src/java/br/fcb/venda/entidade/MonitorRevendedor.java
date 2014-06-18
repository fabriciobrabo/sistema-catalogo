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
@Table(name = "monitor_revendedor")
@XmlRootElement
@SequenceGenerator(name = "venda_sequence_monitor_revendedor", sequenceName = "venda_sequence_monitor_revendedor")
@NamedQueries({
    @NamedQuery(name = "MonitorRevendedor.findAll", query = "SELECT m FROM MonitorRevendedor m"),
    @NamedQuery(name = "MonitorRevendedor.findById", query = "SELECT m FROM MonitorRevendedor m WHERE m.id = :id")})
public class MonitorRevendedor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "venda_sequence_monitor_revendedor")
    @Column(name = "id")
    private Integer id;
    
    @JoinColumn(name = "revendedor", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Revendedor revendedor;
    
    @JoinColumn(name = "monitor", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Monitor monitor;

    public MonitorRevendedor() {
    }

    public MonitorRevendedor(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Revendedor getRevendedor() {
        return revendedor;
    }

    public void setRevendedor(Revendedor revendedor) {
        this.revendedor = revendedor;
    }

    public Monitor getMonitor() {
        return monitor;
    }

    public void setMonitor(Monitor monitor) {
        this.monitor = monitor;
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
        if (!(object instanceof MonitorRevendedor)) {
            return false;
        }
        MonitorRevendedor other = (MonitorRevendedor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.fcb.venda.entidade.MonitorRevendedor[ id=" + id + " ]";
    }
    
}
