package br.com.carc2ccadastro.domain;

import br.com.carc2ccadastro.hardcode.TipoCarro;

import javax.persistence.*;

@Entity
public class Carro {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    private String marca;

    private String modelo;

    @Enumerated(EnumType.STRING)
    private TipoCarro tipo;

    private String placa;

    private String cor;

    private String descricao;
    
    private Long usuarioId;
    
    private Boolean statusCarro = Boolean.FALSE;
    
    private Long usuarioAluguelId;
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getMarca() {
        return marca;
    }
    
    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    public String getModelo() {
        return modelo;
    }
    
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    
    public TipoCarro getTipo() {
        return tipo;
    }
    
    public void setTipo(TipoCarro tipo) {
        this.tipo = tipo;
    }
    
    public String getPlaca() {
        return placa;
    }
    
    public void setPlaca(String placa) {
        this.placa = placa;
    }
    
    public String getCor() {
        return cor;
    }
    
    public void setCor(String cor) {
        this.cor = cor;
    }
    
    public String getDescricao() {
        return descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public Long getUsuarioId() {
        return usuarioId;
    }
    
    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }
    
    public Boolean getStatusCarro() {
        return statusCarro;
    }
    
    public void setStatusCarro(Boolean statusCarro) {
        this.statusCarro = statusCarro;
    }
    
    public Long getUsuarioAluguelId() {
        return usuarioAluguelId;
    }
    
    public void setUsuarioAluguelId(Long usuarioAluguelId) {
        this.usuarioAluguelId = usuarioAluguelId;
    }
}

