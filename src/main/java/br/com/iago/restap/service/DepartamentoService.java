package br.com.iago.restap.service;

import br.com.iago.restap.domain.Cargo;
import br.com.iago.restap.domain.Departamento;

import java.util.List;

public interface DepartamentoService {
    void salvar(Departamento departamento);
    void editar(Departamento departamento);
    void exluir(Long id);
    Departamento findById(Long id);
    List<Departamento> findAll();

    boolean depertamentoTemCargos(Long id);
}
