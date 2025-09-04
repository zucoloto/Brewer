package br.com.zuco.model.service;

import static br.com.zuco.mapper.ObjectDozerMapper.parseListObjects;
import static br.com.zuco.mapper.ObjectDozerMapper.parseObject;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.zuco.dto.EstiloDTO;
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
	public EstiloDTO salvar(EstiloDTO estiloDTO) {
		_log.info("[Executando:" + Thread.currentThread().getStackTrace()[1].getMethodName() + "]");
		
		var estilo = parseObject(estiloDTO, Estilo.class);
		EstiloDTO estiloDTOSalvar = parseObject(estiloRepository.save(estilo), EstiloDTO.class);
		
		_log.info("[Registro salvo!]");
		return estiloDTOSalvar;
	}

	@Override
	@Transactional
	public EstiloDTO atualizar(EstiloDTO estiloDTO) {
		_log.info("[Executando:" + Thread.currentThread().getStackTrace()[1].getMethodName() + "]");
		
		Estilo estilo = estiloRepository.findById(estiloDTO.getEstiloId())
				.orElseThrow(() -> new ResourceNotFoundException("Nenhum registro encontrado!"));
		estilo.setEstiloNome(estiloDTO.getEstiloNome());

		EstiloDTO estiloDTOSalvar = parseObject(estiloRepository.save(estilo), EstiloDTO.class);
		
		_log.info("[Registro atualizado!]");
		return estiloDTOSalvar;
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
	public List<EstiloDTO> buscarTodos() {
		_log.info("[Executando:" + Thread.currentThread().getStackTrace()[1].getMethodName() + "]");
		
		return parseListObjects(estiloRepository.findAll(), EstiloDTO.class);
	}

	@Override
	public EstiloDTO buscarPorId(Long id) {
		_log.info("[Executando:" + Thread.currentThread().getStackTrace()[1].getMethodName() + "]");
		
		var entity = estiloRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Nenhum registro encontrado!"));
		return parseObject(entity, EstiloDTO.class);
	}

}
