package br.com.iago.restap.dao;

import br.com.iago.restap.domain.Departamento;

import java.util.List;

public interface DepartamentoDao {
    void save(Departamento departamento);
    void update(Departamento departamento);
    void delete(long id);
    Departamento findById(long id);
    List<Departamento> findAll();
}
