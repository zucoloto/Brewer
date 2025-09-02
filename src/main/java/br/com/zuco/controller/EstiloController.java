package br.com.zuco.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.zuco.model.entity.Estilo;
import br.com.zuco.model.service.EstiloService;

@RestController
@RequestMapping("/estilo")
public class EstiloController {

	@Autowired
	EstiloService estiloService;
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Estilo salvar(@RequestBody Estilo Estilo) {
		return estiloService.salvar(Estilo);
	}
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Estilo atualizar(@RequestBody Estilo estilo) {
		return estiloService.atualizar(estilo);
	}
	
	@DeleteMapping(value = "/{estiloId}")
	public ResponseEntity<?> excluir(@PathVariable("estiloId") Long id) {
		estiloService.excluir(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Estilo> buscarTodos() {
		return estiloService.buscarTodos();
	}

	@GetMapping(value = "/{estiloId}", produces = MediaType.APPLICATION_JSON_VALUE) 
	public Estilo buscarPorId(@PathVariable("estiloId") Long id) {
		return estiloService.buscarPorId(id);
	}
}
