package br.com.zuco.model.service;

import java.util.List;

import br.com.zuco.dto.EstiloDTO;

public interface EstiloService {

	public EstiloDTO salvar(EstiloDTO estiloDTO);
	
	public EstiloDTO atualizar(EstiloDTO estiloDTO);
	
	public void excluir(Long id);
	
	public List<EstiloDTO> buscarTodos();
	
	public EstiloDTO buscarPorId(Long id);
}
