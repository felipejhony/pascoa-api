package br.com.felipe.pascoaapi.pascoa_api.domain;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pascoa_sorte")
public class PascoaSorte implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "numero_sorte")
	private long numeroSorte;
	@Column(name = "usuario")
	private String usuario;
	
	public PascoaSorte() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public long getNumeroSorte() {
		return numeroSorte;
	}
	public void setNumeroSorte(long numeroSorte) {
		this.numeroSorte = numeroSorte;
	}
	@Override
	public String toString() {
		return "PascoaSorte [id=" + id + ", numeroSorte=" + numeroSorte + ", usuario=" + usuario + "]";
	}
}
