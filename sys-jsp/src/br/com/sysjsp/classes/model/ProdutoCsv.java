package br.com.sysjsp.classes.model;

public class ProdutoCsv {

	private Long id;
	private String revenda;
	private String cnpjRevenda;
	private String descricaoProduto;
	private String dataColeta;
	private Double valorVenda;
	private Double valorCompra;
	private Integer quantidade;
	private String unidadeMedida;
	private Long id_bandeira;
	private String tipo;
	private String estado;
	private String cidade;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRevenda() {
		return revenda;
	}

	public void setRevenda(String revenda) {
		this.revenda = revenda;
	}

	public String getCnpjRevenda() {
		return cnpjRevenda;
	}

	public void setCnpjRevenda(String cnpjRevenda) {
		this.cnpjRevenda = cnpjRevenda;
	}

	public String getDescricaoProduto() {
		return descricaoProduto;
	}

	public void setDescricaoProduto(String descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
	}

	public String getDataColeta() {
		return dataColeta;
	}

	public void setDataColeta(String dataColeta) {
		this.dataColeta = dataColeta;
	}
	
	public Double getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(Double valorVenda) {
		this.valorVenda = valorVenda;
	}

	public Double getValorCompra() {
		return valorCompra;
	}

	public void setValorCompra(Double valorCompra) {
		this.valorCompra = valorCompra;
	}

	public String getUnidadeMedida() {
		return unidadeMedida;
	}

	public void setUnidadeMedida(String unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}

	public Long getId_bandeira() {
		return id_bandeira;
	}

	public void setId_bandeira(Long id_bandeira) {
		this.id_bandeira = id_bandeira;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

}
