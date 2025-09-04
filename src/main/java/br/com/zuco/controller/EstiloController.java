package br.com.zuco.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.zuco.dto.EstiloDTO;
import br.com.zuco.model.service.EstiloService;

@RestController
@RequestMapping("/estilo")
public class EstiloController {

	@Autowired
	EstiloService estiloService;
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public EstiloDTO salvar(@RequestBody EstiloDTO estilo) {
		return estiloService.salvar(estilo);
	}
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public EstiloDTO atualizar(@RequestBody EstiloDTO estilo) {
		return estiloService.atualizar(estilo);
	}
	
	@DeleteMapping(value = "/{estiloId}")
	public ResponseEntity<?> excluir(@PathVariable("estiloId") Long id) {
		estiloService.excluir(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<EstiloDTO> buscarTodos() {
		return estiloService.buscarTodos();
	}

	@GetMapping(value = "/{estiloId}", produces = MediaType.APPLICATION_JSON_VALUE) 
	public EstiloDTO buscarPorId(@PathVariable("estiloId") Long id) {
		return estiloService.buscarPorId(id);
	}
}
