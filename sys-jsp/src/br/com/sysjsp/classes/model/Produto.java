package br.com.sysjsp.classes.model;

public class Produto {

	private Long id;
	private String descricao;
	private Integer quantidade;
	private Double valorcompra;
	private Double valoritem;
	private Long categoria;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getValorcompra() {
		return valorcompra;
	}

	public void setValorcompra(Double valorcompra) {
		this.valorcompra = valorcompra;
	}

	public Double getValoritem() {
		return valoritem;
	}

	public void setValoritem(Double valoritem) {
		this.valoritem = valoritem;
	}

	public Long getCategoria() {
		return categoria;
	}

	public void setCategoria(Long categoria) {
		this.categoria = categoria;
	}

}
