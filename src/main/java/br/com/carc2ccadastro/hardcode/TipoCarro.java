package br.com.carc2ccadastro.hardcode;

public enum TipoCarro {

    SUV("Suv"),
    HATCH("Hatch"),
    SEDAN("Sedan"),
    CONVERSIVEL("Conversivel"),
    PICAPE("Picape"),
    JIPE("Jipe");

    private String descricao;

    private TipoCarro(String descricao){
        this.descricao = descricao;
    }
}
