package br.com.iago.restap.dao;

import br.com.iago.restap.domain.Departamento;
import br.com.iago.restap.domain.Funcionario;

import java.util.List;

public interface FuncionarioDao {
    void save(Funcionario funcionario);
    void update(Funcionario funcionario);
    void delete(long id);
    Funcionario findById(long id);
    List<Funcionario> findAll();
}
