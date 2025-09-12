package br.com.zuco.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.zuco.dto.EstiloDTO;
import br.com.zuco.model.service.EstiloService;
import br.com.zuco.model.service.exception.ResourceNotFoundException;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/estilo")
public class EstiloController {

	@Autowired
	EstiloService estiloService;
	
	private static final String CADASTRO_VIEW = "estilo/cadastro_estilo";
	
	@GetMapping("/novo")
	public ModelAndView novo(EstiloDTO estiloDTO) {
		return new ModelAndView(CADASTRO_VIEW);
	}
	
	@GetMapping("/editar/{estiloId}")
    public ModelAndView editar(@PathVariable("estiloId") Long id) {
		EstiloDTO estiloDTO = estiloService.buscarPorId(id);
		ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
        mv.addObject(estiloDTO);
        return mv;
    }
	
	@PostMapping
	public ModelAndView salvar(@Valid EstiloDTO estiloDTO, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			attributes.addFlashAttribute("error", true);
			attributes.addFlashAttribute("mensagem", "Registro NÃO cadastrado!");
			return novo(estiloDTO);
		}
		
		try {
			estiloService.salvar(estiloDTO);
		} catch (ResourceNotFoundException e) {
			result.rejectValue("estiloNome", e.getMessage(), e.getMessage());
			System.out.println("estiloNome: " + "e.getMessage: " + e.getMessage());
			return novo(estiloDTO);
		}
		
		attributes.addFlashAttribute("sucesso", true);
		attributes.addFlashAttribute("mensagem", "Registro cadastrado!");
		ModelAndView mv = new ModelAndView("redirect:/estilo/novo");
		return mv;
	}
	
	@PutMapping
	public ModelAndView atualizar(EstiloDTO estiloDTO, BindingResult result, RedirectAttributes attributes) {
		ModelAndView mv = new ModelAndView("redirect:/estilo");
		
		if (result.hasErrors()) {
			attributes.addFlashAttribute("error", true);
			attributes.addFlashAttribute("mensagem", "Registro NÃO atualizado!");
			return mv;
		}
		
		estiloService.atualizar(estiloDTO);
		attributes.addFlashAttribute("sucesso", true);
		attributes.addFlashAttribute("mensagem", "Registro atualizado!");
		return mv;
	}
	
	@GetMapping("/excluir/{estiloId}")
	public ModelAndView excluir(@PathVariable("estiloId") Long id, RedirectAttributes attributes) {
		ModelAndView mv = new ModelAndView("redirect:/estilo");
		
		estiloService.excluir(id);
		attributes.addFlashAttribute("sucesso", true);
		attributes.addFlashAttribute("mensagem", "Registro excluído!");
		return mv;
	}
	
	@GetMapping
	public ModelAndView buscarTodos() {
		List<EstiloDTO> listar = estiloService.buscarTodos();
        ModelAndView mv = new ModelAndView("/estilo/listar_estilo");
        mv.addObject("todosEstilos", listar);
        return mv;
	}

	@GetMapping("/{estiloId}") 
	public EstiloDTO buscarPorId(@PathVariable("estiloId") Long id) {
		System.out.println("buscarPorId");
		return estiloService.buscarPorId(id);
	}
	
}
