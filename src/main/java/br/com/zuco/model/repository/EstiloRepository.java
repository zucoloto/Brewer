package br.com.zuco.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zuco.model.entity.Estilo;

public interface EstiloRepository extends JpaRepository<Estilo, Long> {

	public Optional<Estilo> findByEstiloNomeIgnoreCase(String estiloNome);

}
