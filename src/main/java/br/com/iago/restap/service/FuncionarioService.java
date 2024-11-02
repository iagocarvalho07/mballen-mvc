package br.com.iago.restap.service;

import br.com.iago.restap.domain.Departamento;
import br.com.iago.restap.domain.Funcionario;

import java.time.LocalDate;
import java.util.List;

public interface FuncionarioService {
    void salvar(Funcionario funcionario);
    void editar(Funcionario funcionario);
    void exluir(Long id);
    Funcionario buscarPorId(Long id);
    List<Funcionario> buscarTodos();

    List<Funcionario> buscarporNome(String nome);

    List<Funcionario> BuscarporCargo(Long id);

    List<Funcionario> buscarPorDatas(LocalDate entrada, LocalDate saida);
}
