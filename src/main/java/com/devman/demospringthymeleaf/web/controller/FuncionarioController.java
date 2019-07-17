package com.devman.demospringthymeleaf.web.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.devman.demospringthymeleaf.model.Cargo;
import com.devman.demospringthymeleaf.model.Funcionario;
import com.devman.demospringthymeleaf.model.UF;
import com.devman.demospringthymeleaf.service.CargoService;
import com.devman.demospringthymeleaf.service.FuncionarioService;

@Controller
@RequestMapping("/funcionarios")
public class FuncionarioController {

	@Autowired
	private FuncionarioService funcionarioService;

	@Autowired
	private CargoService cargoService;

	@GetMapping("/cadastrar")
	public String cadastrar(Funcionario funcionario) {
		return "funcionario/cadastro";
	}

	@PostMapping("/salvar")
	public String salvar(@Valid Funcionario funcionario,BindingResult result, RedirectAttributes atrr) {
		if(result.hasErrors()) {
			return "funcionario/cadastro";
		}
		funcionarioService.salvar(funcionario);
		atrr.addFlashAttribute("success", "Funcionario cadastrado com sucesso.");
		return "redirect:/funcionarios/cadastrar";
	}

	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id,ModelMap model) {
		model.addAttribute("funcionario", funcionarioService.findById(id));
		return "funcionario/cadastro";
	}

	@PostMapping("/editar")
	public String editar(@Valid Funcionario funcionario,BindingResult result, RedirectAttributes atrr) {
		if(result.hasErrors()) {
			return "funcionario/cadastro";
		}
		funcionarioService.salvar(funcionario);
		atrr.addFlashAttribute("success", "Funcionario atualizado com sucesso.");
		return "redirect:/funcionarios/cadastrar";
	}



	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("funcionarios", funcionarioService.findAll());
		return "/funcionario/lista";
	}

	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id,ModelMap model) {
		funcionarioService.delete(id);
		model.addAttribute("success", "Funcionario excluído com sucesso");
		return listar(model);
	}
	@GetMapping("/buscar/nome")
	public String listaFuncionarioPorNome(@RequestParam("nome") String nome,ModelMap model) {
		model.addAttribute("funcionarios", funcionarioService.buscarPorNome(nome));
		return "/funcionario/lista";
	}
	@GetMapping("/buscar/cargo")
	public String listarFuncionarioPorCargo(@RequestParam("id") String id,ModelMap model) {
		model.addAttribute("funcionarios", funcionarioService.buscarPorCargo(Long.valueOf(id)));
		return "/funcionario/lista";
	}
	@GetMapping("/buscar/data")
	public String listarFuncionarioPorData(@RequestParam("entrada") @DateTimeFormat(iso = ISO.DATE ) LocalDate entrada, @DateTimeFormat(iso = ISO.DATE )@RequestParam("saida") LocalDate saida,ModelMap model) {
		model.addAttribute("funcionarios", funcionarioService.buscarPorData( entrada, saida));
		return "/funcionario/lista";
	}


	@ModelAttribute("cargos")
	public List<Cargo> listarCargos(){
		return cargoService.findAll();
	}
	@ModelAttribute("ufs")
	public UF[] listarUfs(){
		return UF.values();
	}
}
