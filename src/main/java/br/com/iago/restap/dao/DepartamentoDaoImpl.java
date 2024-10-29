package br.com.iago.restap.dao;

import br.com.iago.restap.domain.Departamento;
import org.springframework.stereotype.Repository;

@Repository
public class DepartamentoDaoImpl extends AbstractDao<Departamento, Long> implements DepartamentoDao{
    @Override
    public void delete(long id) {

    }

    @Override
    public Departamento findById(long id) {
        return null;
    }
}
