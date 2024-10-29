package br.com.iago.restap.dao;

import br.com.iago.restap.domain.Funcionario;
import org.springframework.stereotype.Repository;

@Repository
public class FuncionarioDaoImpl extends AbstractDao<Funcionario, Long> implements  FuncionarioDao{
    @Override
    public void delete(long id) {

    }

    @Override
    public Funcionario findById(long id) {
        return null;
    }
}
