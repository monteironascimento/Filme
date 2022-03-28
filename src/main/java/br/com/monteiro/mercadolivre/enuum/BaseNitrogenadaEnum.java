package br.com.monteiro.mercadolivre.enuum;

public enum BaseNitrogenadaEnum{
    
    A(1),
    T(2),
    C(3),
    G(4);

    private Integer descricao;

    BaseNitrogenadaEnum(Integer descricao) {
        this.descricao = descricao;
    }

    public Integer getDescricao() {
        return descricao;
    }
    
}