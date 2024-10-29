package br.com.iago.restap.service;

import br.com.iago.restap.domain.Cargo;

import java.util.List;

public interface CargoService {
    void salvar(Cargo cargo);
    void editar(Cargo cargo);
    void exluir(Long id);
    Cargo buscarPorId(Long id);
    List<Cargo> buscarTodos();

    boolean cargoTemFuncionarios(Long id);
}
