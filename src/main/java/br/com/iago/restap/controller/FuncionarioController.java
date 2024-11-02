package br.com.iago.restap.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.iago.restap.domain.Cargo;
import br.com.iago.restap.domain.Funcionario;
import br.com.iago.restap.domain.UF;
import br.com.iago.restap.service.CargoService;
import br.com.iago.restap.service.FuncionarioService;

@Controller
@RequestMapping("/funcionarios")
public class FuncionarioController {

	@Autowired
	private FuncionarioService funcionarioService;
	@Autowired
	private CargoService cargoService;

	@GetMapping("/cadastrar")
	public String cadastrar(Funcionario funcionario) {
		return "/funcionario/cadastro";
	}

	@GetMapping("/listar")
	public String listar(ModelMap model) {
		
		model.addAttribute("funcionarios", funcionarioService.buscarTodos());
		return "/funcionario/lista";
	}

	@PostMapping("/salvar")
	public String salvar(Funcionario funcionario, RedirectAttributes attr) {
		funcionarioService.salvar(funcionario);
		attr.addFlashAttribute("success", "Funcionario inserido com sucesso.");
		return "redirect:/funcionarios/cadastrar";
	}

	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model){
		model.addAttribute("funcionario", funcionarioService.buscarPorId(id));
		return "/funcionario/cadastro";
	}

	@PostMapping("/editar")
	public String editar (Funcionario funcionario, RedirectAttributes attr){
		funcionarioService.editar(funcionario);
		attr.addFlashAttribute("success", "Funcionario editado com suceso.");
		return "redirect:/funcionarios/cadastrar";
	}

	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, RedirectAttributes attr){
		funcionarioService.exluir(id);
		attr.addFlashAttribute("sucess", "Funcionario removido com sucesso");
		return "redirect:/funcionarios/listar";
	}

	@GetMapping("/buscar/nome")
	public String getByName(@RequestParam("nome") String nome, ModelMap model){
		model.addAttribute("funcionarios", funcionarioService.buscarporNome(nome));
		return "/funcionario/lista";
	}

	@GetMapping("/buscar/nome")
	public String getByCargo(@RequestParam("id") Long id, ModelMap model){
		model.addAttribute("funcionarios", funcionarioService.BuscarporCargo(id));
		return "/funcionario/lista";
	}

	@GetMapping("/buscar/cargo")
	public String getPorCargo(@RequestParam("id") Long id, ModelMap model) {
		model.addAttribute("funcionarios", funcionarioService.BuscarporCargo(id));
		return "/funcionario/lista";
	}

	@GetMapping("/buscar/data")
	public String getPorDatas(@RequestParam(value = "entrada", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate entrada,
							  @RequestParam(value = "saida", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate saida,
							  ModelMap model) {

		model.addAttribute("funcionarios", funcionarioService.buscarPorDatas(entrada, saida));
		return "/funcionario/lista";
	}



	@ModelAttribute("cargos")
	public List<Cargo> getCargos() {
		return cargoService.buscarTodos();

	}
	
	
	@ModelAttribute("ufs")
	public UF[] getUfs() {
		return UF.values();
	}

}
