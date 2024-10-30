package br.com.iago.restap.service;

import java.util.List;

import br.com.iago.restap.domain.Departamento;

public interface DepartamentoService {
    void salvar(Departamento departamento);
    void editar(Departamento departamento);
    void exluir(Long id);
    Departamento findById(Long id);
    List<Departamento> findAll();

    boolean depertamentoTemCargos(Long id);
}
