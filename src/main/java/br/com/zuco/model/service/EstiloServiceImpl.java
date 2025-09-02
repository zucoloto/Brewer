package br.com.zuco.model.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.zuco.model.entity.Estilo;
import br.com.zuco.model.repository.EstiloRepository;
import br.com.zuco.model.service.exception.ResourceNotFoundException;

@Service
public class EstiloServiceImpl implements EstiloService {

	@Autowired
	private EstiloRepository estiloRepository;
	
	private Logger _log = LoggerFactory.getLogger(this.getClass().getName());

	@Override
	@Transactional
	public Estilo salvar(Estilo entity) {
		_log.info("[Executando:" + Thread.currentThread().getStackTrace()[1].getMethodName() + "]");
		
		estiloRepository.save(entity);
		
		_log.info("[Registro salvo!]");
		return entity;
	}

	@SuppressWarnings("unused")
	@Override
	@Transactional
	public Estilo atualizar(Estilo entity) {
		_log.info("[Executando:" + Thread.currentThread().getStackTrace()[1].getMethodName() + "]");
		
		Estilo estilo = estiloRepository.findById(entity.getEstiloId())
				.orElseThrow(() -> new ResourceNotFoundException("Nenhum registro encontrado!"));
		estiloRepository.save(entity);

		_log.info("[Registro atualizado!]");
		return entity;
	}

	@Override
	@Transactional
	public void excluir(Long id) {
		_log.info("[Executando:" + Thread.currentThread().getStackTrace()[1].getMethodName() + "]");
		
		Estilo estilo = estiloRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Nenhum registro encontrado!"));
		estiloRepository.delete(estilo);

		_log.info("[Registro deletado!]");
	}

	@Override
	public List<Estilo> buscarTodos() {
		_log.info("[Executando:" + Thread.currentThread().getStackTrace()[1].getMethodName() + "]");
		
		return estiloRepository.findAll();
	}

	@Override
	public Estilo buscarPorId(Long id) {
		_log.info("[Executando:" + Thread.currentThread().getStackTrace()[1].getMethodName() + "]");
		
		return estiloRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Nenhum registro encontrado!"));
	}

}
