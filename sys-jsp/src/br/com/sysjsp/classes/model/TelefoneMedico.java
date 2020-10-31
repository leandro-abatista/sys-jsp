package br.com.sysjsp.classes.model;

public class TelefoneMedico {

	private Long id;
	private String numero;
	private String tipo;
	private Long medico;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Long getMedico() {
		return medico;
	}

	public void setMedico(Long medico) {
		this.medico = medico;
	}

}
