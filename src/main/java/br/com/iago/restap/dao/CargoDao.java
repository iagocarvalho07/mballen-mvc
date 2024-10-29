package br.com.iago.restap.dao;

import br.com.iago.restap.domain.Cargo;
import br.com.iago.restap.domain.Departamento;

import java.util.List;

public interface CargoDao {

    void save(Cargo cargo);
    void update(Cargo cargo);
    void delete(long id);
    Cargo findById(long id);
    List<Cargo> findAll();
}
