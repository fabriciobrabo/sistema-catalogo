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
@Table(name = "revendedor")
@XmlRootElement
@SequenceGenerator(name = "venda_sequence_revendedor", sequenceName = "venda_sequence_revendedor")
@NamedQueries({
    @NamedQuery(name = "Revendedor.findAll", query = "SELECT r FROM Revendedor r"),
    @NamedQuery(name = "Revendedor.findById", query = "SELECT r FROM Revendedor r WHERE r.id = :id"),
    @NamedQuery(name = "Revendedor.findByNome", query = "SELECT r FROM Revendedor r WHERE r.nome = :nome"),
    @NamedQuery(name = "Revendedor.findBySobrenome", query = "SELECT r FROM Revendedor r WHERE r.sobrenome = :sobrenome"),
    @NamedQuery(name = "Revendedor.findByCpf", query = "SELECT r FROM Revendedor r WHERE r.cpf = :cpf"),
    @NamedQuery(name = "Revendedor.findByRg", query = "SELECT r FROM Revendedor r WHERE r.rg = :rg"),
    @NamedQuery(name = "Revendedor.findByCep", query = "SELECT r FROM Revendedor r WHERE r.cep = :cep"),
    @NamedQuery(name = "Revendedor.findByEndereco", query = "SELECT r FROM Revendedor r WHERE r.endereco = :endereco"),
    @NamedQuery(name = "Revendedor.findByBairro", query = "SELECT r FROM Revendedor r WHERE r.bairro = :bairro"),
    @NamedQuery(name = "Revendedor.findByCidade", query = "SELECT r FROM Revendedor r WHERE r.cidade = :cidade"),
    @NamedQuery(name = "Revendedor.findByEstado", query = "SELECT r FROM Revendedor r WHERE r.estado = :estado")})
public class Revendedor implements Serializable {

    @JoinColumn(name = "usuario", referencedColumnName = "id")
    @ManyToOne
    private Usuario usuario;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "venda_sequence_revendedor")
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

    @OneToMany(mappedBy = "revendedor")
    private List<Pedido> pedidoList;

    @JoinColumn(name = "monitor", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Monitor monitor;

    public Revendedor() {
    }

    public Revendedor(Integer id) {
        this.id = id;
    }

    public Revendedor(Integer id, String nome, String sobrenome, String cpf, String rg, String cep, String endereco, String bairro, String cidade, String estado) {
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

    public Monitor getMonitor() {
        return monitor;
    }

    public void setMonitor(Monitor monitor) {
        this.monitor = monitor;
    }

    @XmlTransient
    public List<Pedido> getPedidoList() {
        return pedidoList;
    }

    public void setPedidoList(List<Pedido> pedidoList) {
        this.pedidoList = pedidoList;
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
        if (!(object instanceof Revendedor)) {
            return false;
        }
        Revendedor other = (Revendedor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.fcb.venda.entidade.Revendedor[ id=" + id + " ]";
    }

}
