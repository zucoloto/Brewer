package br.com.zuco.model.service;

import java.util.List;

import br.com.zuco.model.entity.Estilo;

public interface EstiloService {

	public Estilo salvar(Estilo entity);
	
	public Estilo atualizar(Estilo entity);
	
	public void excluir(Long id);
	
	public List<Estilo> buscarTodos();
	
	public Estilo buscarPorId(Long id);
}
