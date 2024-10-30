package br.com.iago.restap.controller;


import br.com.iago.restap.domain.Departamento;
import br.com.iago.restap.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/departamentos")
public class DepartamentoController {

    @Autowired
    private DepartamentoService departamentoService;

    @GetMapping("/cadastrar")
    public String cadastrar(Departamento departamento) {
        return "/departamento/cadastro";
    }

    @GetMapping("/listar")
    public String listar(ModelMap modelMap) {
        modelMap.addAttribute("departamentos", departamentoService.findAll());
        return "/departamento/lista";
    }

    @PostMapping("/salvar")
    public String salvar(Departamento departamento, RedirectAttributes attr) {
        departamentoService.salvar(departamento);
        attr.addFlashAttribute("success", "Departamento inserido com sucesso.");
        return "redirect:/departamentos/cadastrar";
    }

        @GetMapping("/editar/{id}")
    public String preEditar(@PathVariable Long id, ModelMap modelMap) {
        Departamento departamento =departamentoService.findById(id);
        modelMap.addAttribute("departamento",departamento );
        return "/departamento/cadastro";
    }

    @PostMapping("/editar")
    public String editar(Departamento departamento, RedirectAttributes attr) {
        departamentoService.editar(departamento);
        attr.addFlashAttribute("success", "Departamento editado com sucesso.");
        return "redirect:/departamentos/cadastrar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id, ModelMap model) {

        if (departamentoService.depertamentoTemCargos(id)) {
            model.addAttribute("fail", "Departamento não removido. Possui cargo(s) vinculado(s).");
        } else {
            departamentoService.exluir(id);
            model.addAttribute("success", "Departamento excluído com sucesso.");
        }

        return listar(model);
    }


}
