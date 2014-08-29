/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.fcb.venda.entidade;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ufrastic
 */
@Entity
@Table(name = "pedido")
@XmlRootElement
@SequenceGenerator(name = "venda_sequence_pedido", sequenceName = "venda_sequence_pedido")
@NamedQueries({
    @NamedQuery(name = "Pedido.findAll", query = "SELECT p FROM Pedido p"),
    @NamedQuery(name = "Pedido.findById", query = "SELECT p FROM Pedido p WHERE p.id = :id"),
    @NamedQuery(name = "Pedido.findByStatus", query = "SELECT p FROM Pedido p WHERE p.status = :status"),
    @NamedQuery(name = "Pedido.findByDataCadastrado", query = "SELECT p FROM Pedido p WHERE p.dataCadastrado = :dataCadastrado"),
    @NamedQuery(name = "Pedido.findByDataPedido", query = "SELECT p FROM Pedido p WHERE p.dataPedido = :dataPedido"),
    @NamedQuery(name = "Pedido.findByComicaoRevendedor", query = "SELECT p FROM Pedido p WHERE p.comicaoRevendedor = :comicaoRevendedor"),
    @NamedQuery(name = "Pedido.findByComicaoMonitor", query = "SELECT p FROM Pedido p WHERE p.comicaoMonitor = :comicaoMonitor"),
    @NamedQuery(name = "Pedido.findByComicaoRepresentante", query = "SELECT p FROM Pedido p WHERE p.comicaoRepresentante = :comicaoRepresentante"),
    @NamedQuery(name = "Pedido.findByTotalBruto", query = "SELECT p FROM Pedido p WHERE p.totalBruto = :totalBruto"),
    @NamedQuery(name = "Pedido.findByTotalLiquido", query = "SELECT p FROM Pedido p WHERE p.totalLiquido = :totalLiquido")})
public class Pedido implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "venda_sequence_pedido")
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "status")
    private String status;
    
    @Column(name = "data_cadastrado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCadastrado;
    
    @Column(name = "data_pedido")
    @Temporal(TemporalType.DATE)
    private Date dataPedido;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "comicao_revendedor")
    private BigDecimal comicaoRevendedor;
    
    @Column(name = "comicao_monitor")
    private BigDecimal comicaoMonitor;
    
    @Column(name = "comicao_representante")
    private BigDecimal comicaoRepresentante;
    
    @Column(name = "total_bruto")
    private BigDecimal totalBruto;
    
    @Column(name = "total_liquido")
    private BigDecimal totalLiquido;
    
    @JoinColumn(name = "representante", referencedColumnName = "id")
    @ManyToOne
    private Representante representante;
    
    @JoinColumn(name = "monitor", referencedColumnName = "id")
    @ManyToOne
    private Monitor monitor;
    
    @JoinColumn(name = "revendedor", referencedColumnName = "id")
    @ManyToOne
    private Revendedor revendedor;
    
    @OneToMany(mappedBy = "pedido")
    private List<ItemPedido> itemPedidoList;

    public Pedido() {
    }

    public Pedido(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDataCadastrado() {
        return dataCadastrado;
    }

    public void setDataCadastrado(Date dataCadastrado) {
        this.dataCadastrado = dataCadastrado;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public BigDecimal getComicaoRevendedor() {
        return comicaoRevendedor;
    }

    public void setComicaoRevendedor(BigDecimal comicaoRevendedor) {
        this.comicaoRevendedor = comicaoRevendedor;
    }

    public BigDecimal getComicaoMonitor() {
        return comicaoMonitor;
    }

    public void setComicaoMonitor(BigDecimal comicaoMonitor) {
        this.comicaoMonitor = comicaoMonitor;
    }

    public BigDecimal getComicaoRepresentante() {
        return comicaoRepresentante;
    }

    public void setComicaoRepresentante(BigDecimal comicaoRepresentante) {
        this.comicaoRepresentante = comicaoRepresentante;
    }

    public BigDecimal getTotalBruto() {
        return totalBruto;
    }

    public void setTotalBruto(BigDecimal totalBruto) {
        this.totalBruto = totalBruto;
    }

    public BigDecimal getTotalLiquido() {
        return totalLiquido;
    }

    public void setTotalLiquido(BigDecimal totalLiquido) {
        this.totalLiquido = totalLiquido;
    }

    public Representante getRepresentante() {
        return representante;
    }

    public void setRepresentante(Representante representante) {
        this.representante = representante;
    }

    public Monitor getMonitor() {
        return monitor;
    }

    public void setMonitor(Monitor monitor) {
        this.monitor = monitor;
    }

    public Revendedor getRevendedor() {
        return revendedor;
    }

    public void setRevendedor(Revendedor revendedor) {
        this.revendedor = revendedor;
    }

    @XmlTransient
    public List<ItemPedido> getItemPedidoList() {
        return itemPedidoList;
    }

    public void setItemPedidoList(List<ItemPedido> itemPedidoList) {
        this.itemPedidoList = itemPedidoList;
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
        if (!(object instanceof Pedido)) {
            return false;
        }
        Pedido other = (Pedido) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.fcb.venda.entidade.Pedido[ id=" + id + " ]";
    }
    
}
