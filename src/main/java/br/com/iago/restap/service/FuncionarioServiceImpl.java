package br.com.iago.restap.service;

import br.com.iago.restap.dao.FuncionarioDao;
import br.com.iago.restap.domain.Funcionario;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class FuncionarioServiceImpl implements FuncionarioService {

    @Autowired
    private FuncionarioDao dao;

    @Override
    public void salvar(Funcionario funcionario) {
        dao.save(funcionario);
    }

    @Override
    public void editar(Funcionario funcionario) {
        dao.update(funcionario);
    }

    @Override
    public void exluir(Long id) {
        dao.delete(id);
    }

    @Override
    public Funcionario buscarPorId(Long id) {
        return dao.findById(id);
    }

    @Override
    public List<Funcionario> buscarTodos() {
        return dao.findAll();
    }
}