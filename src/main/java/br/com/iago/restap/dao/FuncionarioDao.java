package br.com.iago.restap.dao;

import br.com.iago.restap.domain.Funcionario;

import java.time.LocalDate;
import java.util.List;

public interface FuncionarioDao {
    void save(Funcionario funcionario);
    void update(Funcionario funcionario);
    void delete(long id);
    Funcionario findById(long id);
    List<Funcionario> findAll();

    List<Funcionario> findByNome(String nome);

    List<Funcionario> findByCargo(Long id);
    List<Funcionario> findByDataEntradaDataSaida(LocalDate entrada, LocalDate saida);

    List<Funcionario> findByDataEntrada(LocalDate entrada);

    List<Funcionario> findByDataSaida(LocalDate saida);
}
