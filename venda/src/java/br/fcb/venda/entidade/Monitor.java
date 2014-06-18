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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "monitor")
@XmlRootElement
@SequenceGenerator(name = "venda_sequence_monitor", sequenceName = "venda_sequence_monitor")
@NamedQueries({
    @NamedQuery(name = "Monitor.findAll", query = "SELECT m FROM Monitor m"),
    @NamedQuery(name = "Monitor.findById", query = "SELECT m FROM Monitor m WHERE m.id = :id"),
    @NamedQuery(name = "Monitor.findByNome", query = "SELECT m FROM Monitor m WHERE m.nome = :nome"),
    @NamedQuery(name = "Monitor.findBySobrenome", query = "SELECT m FROM Monitor m WHERE m.sobrenome = :sobrenome"),
    @NamedQuery(name = "Monitor.findByCpf", query = "SELECT m FROM Monitor m WHERE m.cpf = :cpf"),
    @NamedQuery(name = "Monitor.findByRg", query = "SELECT m FROM Monitor m WHERE m.rg = :rg"),
    @NamedQuery(name = "Monitor.findByCep", query = "SELECT m FROM Monitor m WHERE m.cep = :cep"),
    @NamedQuery(name = "Monitor.findByEndereco", query = "SELECT m FROM Monitor m WHERE m.endereco = :endereco"),
    @NamedQuery(name = "Monitor.findByBairro", query = "SELECT m FROM Monitor m WHERE m.bairro = :bairro"),
    @NamedQuery(name = "Monitor.findByCidade", query = "SELECT m FROM Monitor m WHERE m.cidade = :cidade"),
    @NamedQuery(name = "Monitor.findByEstado", query = "SELECT m FROM Monitor m WHERE m.estado = :estado")})
public class Monitor implements Serializable {
    @JoinColumn(name = "usuario", referencedColumnName = "id")
    @ManyToOne
    private Usuario usuario;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "venda_sequence_monitor")
    @Column(name = "id")
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "sobrenome")
    private String sobrenome;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "rg")
    private String rg;

    @Column(name = "cep")
    private String cep;

    @Column(name = "endereco")
    private String endereco;

    @Column(name = "bairro")
    private String bairro;

    @Column(name = "cidade")
    private String cidade;

    @Column(name = "estado")
    private String estado;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "monitor", orphanRemoval = true)
    private List<RepresentanteMonitor> representanteMonitorList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "monitor", orphanRemoval = true)
    private List<MonitorCatalogo> monitorCatalogoList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "monitor", orphanRemoval = true)
    private List<MonitorRevendedor> monitorRevendedorList;

    public Monitor() {
    }

    public Monitor(Integer id) {
        this.id = id;
    }

    public Monitor(Integer id, String nome, String sobrenome, String cpf, String rg, String cep, String endereco, String bairro, String cidade, String estado) {
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @XmlTransient
    public List<RepresentanteMonitor> getRepresentanteMonitorList() {
        return representanteMonitorList;
    }

    public void setRepresentanteMonitorList(List<RepresentanteMonitor> representanteMonitorList) {
        this.representanteMonitorList = representanteMonitorList;
    }

    @XmlTransient
    public List<MonitorCatalogo> getMonitorCatalogoList() {
        return monitorCatalogoList;
    }

    public void setMonitorCatalogoList(List<MonitorCatalogo> monitorCatalogoList) {
        this.monitorCatalogoList = monitorCatalogoList;
    }

    @XmlTransient
    public List<MonitorRevendedor> getMonitorRevendedorList() {
        return monitorRevendedorList;
    }

    public void setMonitorRevendedorList(List<MonitorRevendedor> monitorRevendedorList) {
        this.monitorRevendedorList = monitorRevendedorList;
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
        if (!(object instanceof Monitor)) {
            return false;
        }
        Monitor other = (Monitor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.fcb.venda.entidade.Monitor[ id=" + id + " ]";
    }

}
