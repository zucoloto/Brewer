package br.com.zuco.dto;

import java.io.Serializable;
import java.util.Objects;

public class EstiloDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long estiloId;
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
		if (!(obj instanceof EstiloDTO))
			return false;
		EstiloDTO other = (EstiloDTO) obj;
		return Objects.equals(estiloId, other.estiloId);
	}

	@Override
	public String toString() {
		return "EstiloDTO [estiloId=" + estiloId + ", estiloNome=" + estiloNome + "]";
	}

}
