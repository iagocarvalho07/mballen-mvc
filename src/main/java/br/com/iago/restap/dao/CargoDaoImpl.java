package br.com.iago.restap.dao;

import br.com.iago.restap.domain.Cargo;
import org.springframework.stereotype.Repository;

@Repository
public class CargoDaoImpl  extends AbstractDao<Cargo, Long> implements CargoDao{
    @Override
    public void delete(long id) {

    }

    @Override
    public Cargo findById(long id) {
        return null;
    }
}
