package com.devman.demospringthymeleaf.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.devman.demospringthymeleaf.model.Cargo;
import com.devman.demospringthymeleaf.model.Departamento;
import com.devman.demospringthymeleaf.service.CargoService;
import com.devman.demospringthymeleaf.service.DepartamentoService;

@Controller
@RequestMapping("/cargos")
public class CargoController {

	@Autowired
	private CargoService cargoService;
	
	@Autowired
	private DepartamentoService departamentoService;
	
	
	@GetMapping("/cadastrar")
	public String cadastrar(Cargo cargo) {
		return "cargo/cadastro";
	}
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("cargos", cargoService.findAll());
		return "cargo/lista";
	}
	
	@PostMapping("/salvar")
	public String salvar(@Valid Cargo cargo, BindingResult result,RedirectAttributes atrr) {
		if(result.hasErrors()) {
			return "cargo/cadastro";
		}
		cargoService.salvar(cargo);
		atrr.addFlashAttribute("success", "Cargo salvo com sucesso.");
		return "redirect:/cargos/cadastrar";
	}
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id,ModelMap model) {
		model.addAttribute("cargo", cargoService.findById(id));
		return "cargo/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(@Valid Cargo cargo,  BindingResult result, RedirectAttributes atrr) {
		if(result.hasErrors()) {
			return "cargo/cadastro";
		}
		cargoService.salvar(cargo);
		atrr.addFlashAttribute("success", "Cargo atualizado com sucesso.");
		return "redirect:/cargos/cadastrar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id,ModelMap model) {
		if(cargoService.podeDeletar(id)) {
			cargoService.delete(id);
			model.addAttribute("success", "Cargo excluído com sucesso");
		}else {
			model.addAttribute("fail", "Cargo não pode ser removido. Possui funcionario(s) vinculado(s).");
		}
		return listar(model);
	}
	
	@ModelAttribute("departamentos")
	public List<Departamento> listarDepartamentos(){
		return departamentoService.findAll();
	}
}
