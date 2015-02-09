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
@Table(name = "representante")
@XmlRootElement
@SequenceGenerator(name = "venda_sequence_representante", sequenceName = "venda_sequence_representante")
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

    @JoinColumn(name = "usuario", referencedColumnName = "id")
    @ManyToOne
    private Usuario usuario;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "venda_sequence_representante")
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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "representante", orphanRemoval = true)
    private List<RepresentanteCatalogo> representanteCatalogoList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "representante", orphanRemoval = true)
    private List<Monitor> monitorList;

    @OneToMany(mappedBy = "representante", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pedido> pedidoList;

    @JoinColumn(name = "parceiro", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Parceiro parceiro;

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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public Parceiro getParceiro() {
        return parceiro;
    }

    public void setParceiro(Parceiro parceiro) {
        this.parceiro = parceiro;
    }

    @XmlTransient
    public List<Monitor> getMonitorList() {
        return monitorList;
    }

    public void setMonitorList(List<Monitor> monitorList) {
        this.monitorList = monitorList;
    }

    @XmlTransient
    public List<Pedido> getPedidoList() {
        return pedidoList;
    }

    public void setPedidoList(List<Pedido> pedidoList) {
        this.pedidoList = pedidoList;
    }

    @XmlTransient
    public List<RepresentanteCatalogo> getRepresentanteCatalogoList() {
        return representanteCatalogoList;
    }

    public void setRepresentanteCatalogoList(List<RepresentanteCatalogo> representanteCatalogoList) {
        this.representanteCatalogoList = representanteCatalogoList;
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
