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
	public ModelAndView salvar(EstiloDTO estiloDTO, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Registro NÃO cadastrado!");
			return novo(estiloDTO);
		}
		
		estiloService.salvar(estiloDTO);
		ModelAndView mv = new ModelAndView("redirect:/estilo/novo");
		return mv;
	}
	
	@PutMapping
	public ModelAndView atualizar(EstiloDTO estiloDTO) {
		estiloService.atualizar(estiloDTO);
		ModelAndView mv = new ModelAndView("redirect:/estilo");
		return mv;
	}
	
	@GetMapping("/excluir/{estiloId}")
	public ModelAndView excluir(@PathVariable("estiloId") Long id) {
		estiloService.excluir(id);
		return new ModelAndView("redirect:/estilo");
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
