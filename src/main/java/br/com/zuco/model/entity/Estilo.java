package br.com.zuco.model.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "estilo")
public class Estilo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "estilo_id")
	private Long estiloId;
	
	@Column(name = "estilo_nome")
	private String estiloNome;

	public Long getEstiloId() {
		return estiloId;
	}

	public void setEstiloId(Long estiloId) {
		this.estiloId = estiloId;
	}

	public String getEstiloNome() {
		return estiloNome;
	}

	public void setEstiloNome(String estiloNome) {
		this.estiloNome = estiloNome;
	}

	@Override
	public int hashCode() {
		return Objects.hash(estiloId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Estilo))
			return false;
		Estilo other = (Estilo) obj;
		return Objects.equals(estiloId, other.estiloId);
	}

	@Override
	public String toString() {
		return "Estilo [estiloId=" + estiloId + ", estiloNome=" + estiloNome + "]";
	}

}
