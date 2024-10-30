package br.com.iago.restap.dao;

import br.com.iago.restap.domain.Departamento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class DepartamentoDaoImpl extends AbstractDao<Departamento, Long> implements DepartamentoDao {

	 @PersistenceContext
	    private EntityManager entityManager;

	    @Override
	    public void delete(long id) {
	        Departamento departamento = findById(id);
	        if (departamento != null) {
	            entityManager.remove(departamento);
	        }
	    }

	    @Override
	    public Departamento findById(long id) {
	        return entityManager.find(Departamento.class, id);
	    }

}
