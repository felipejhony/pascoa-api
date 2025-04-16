package br.com.felipe.pascoaapi.pascoa_api.domain;

public class PascoaSorte {
	
	private int id;
	private long numeroDaSorte;
	private String usuario;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getNumeroDaSorte() {
		return numeroDaSorte;
	}
	public void setNumeroDaSorte(long numeroDaSorte) {
		this.numeroDaSorte = numeroDaSorte;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
}
