package br.com.iago.restap.dao;

import br.com.iago.restap.domain.Departamento;
import br.com.iago.restap.domain.Funcionario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class FuncionarioDaoImpl extends AbstractDao<Funcionario, Long> implements FuncionarioDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void delete(long id) {
        Funcionario funcionario = findById(id);
        if (funcionario != null) {
            entityManager.remove(funcionario);
        }
    }

    @Override
    public Funcionario findById(long id) {
        return entityManager.find(Funcionario.class, id);
    }

    @Override
    public List<Funcionario> findByNome(String nome) {
        return createQuery("select f from Funcionario f where f.nome like concat('%',?1,'%') ", nome);
    }

    @Override
    public List<Funcionario> findByCargo(Long id)  {

        return createQuery("select f from Funcionario f where f.cargo.id = ?1", id);
    }

    @Override
    public List<Funcionario> findByDataEntradaDataSaida(LocalDate entrada, LocalDate saida) {
        String jpql = new StringBuilder("select f from Funcionario f ")
                .append("where f.dataEntrada >= ?1 and f.dataSainda <= ?2 ")
                .append("order by f.dataEntrada asc")
                .toString();
        return createQuery(jpql, entrada, saida);
    }

    @Override
    public List<Funcionario> findByDataEntrada(LocalDate entrada) {
        String jpql = new StringBuilder("select f from Funcionario f ")
                .append("where f.dataEntrada = ?1 ")
                .append("order by f.dataEntrada asc")
                .toString();
        return createQuery(jpql, entrada);
    }

    @Override
    public List<Funcionario> findByDataSaida(LocalDate saida) {
        String jpql = new StringBuilder("select f from Funcionario f ")
                .append("where f.dataSainda = ?1 ")
                .append("order by f.dataEntrada asc")
                .toString();
        return createQuery(jpql, saida);
    }
}
