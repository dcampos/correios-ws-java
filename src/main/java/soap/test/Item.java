package soap.test;

import java.math.BigDecimal;

public class Item {
    private String peso;
    private BigDecimal altura;
    private BigDecimal largura;
    private BigDecimal comprimento;
    private String descricao;

    public Item(String descricao, String peso, BigDecimal altura, BigDecimal largura, BigDecimal comprimento) {
        this.peso = peso;
        this.altura = altura;
        this.largura = largura;
        this.descricao = descricao;
        this.comprimento = comprimento;
    }

    /**
     * @return the altura
     */
    public BigDecimal getAltura() {
        return altura;
    }

    /**
     * @param altura the altura to set
     */
    public void setAltura(BigDecimal altura) {
        this.altura = altura;
    }

    /**
     * @return the peso
     */
    public String getPeso() {
        return peso;
    }

    /**
     * @param peso the peso to set
     */
    public void setPeso(String peso) {
        this.peso = peso;
    }

    /**
     * @return the largura
     */
    public BigDecimal getLargura() {
        return largura;
    }

    /**
     * @param largura the largura to set
     */
    public void setLargura(BigDecimal largura) {
        this.largura = largura;
    }

    /**
     * @return the comprimento
     */
    public BigDecimal getComprimento() {
        return comprimento;
    }

    /**
     * @param comprimento the comprimento to set
     */
    public void setComprimento(BigDecimal comprimento) {
        this.comprimento = comprimento;
    }

	public String getDescricao() {
		return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}