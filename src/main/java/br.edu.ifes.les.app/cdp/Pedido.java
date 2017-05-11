package br.edu.ifes.les.app.cdp;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by paulosantosjunior on 11/05/17.
 */
public class Pedido {

    private int codigo;
    private Date dataPedido;
    private Date dataPagamento;
    private BigDecimal valorTotal;

    public Pedido(int codigo, Date dataPedido, Date dataPagamento, BigDecimal valorTotal){
        this.codigo = codigo;
        this.dataPedido = dataPedido;
        this.dataPagamento = dataPagamento;
        this.valorTotal = valorTotal;
    }

    private List<Item> itens = new ArrayList<Item>();


    public void adicionarItem(Item item){
        itens.add(item);
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }
}
