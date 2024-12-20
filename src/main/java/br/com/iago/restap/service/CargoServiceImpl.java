package br.com.iago.restap.service;

import br.com.iago.restap.dao.CargoDao;
import br.com.iago.restap.domain.Cargo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CargoServiceImpl  implements CargoService{

    @Autowired
    private CargoDao cargoDao;


    @Override
    public void salvar(Cargo cargo) {
        cargoDao.save(cargo);
    }

    @Override
    public void editar(Cargo cargo) {
            cargoDao.update(cargo);
    }

    @Override
    public void exluir(Long id) {
        cargoDao.delete(id);

    }

    @Override
    @Transactional(readOnly = true)
    public Cargo buscarPorId(Long id) {
        return cargoDao.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Cargo> buscarTodos() {
        return cargoDao.findAll();
    }

    @Override
    public boolean cargoTemFuncionarios(Long id) {
        if (buscarPorId(id).getFuncionarios().isEmpty()) {
            return false;
        }
        return true;
    }
}
