package br.com.iago.restap.dao;

import br.com.iago.restap.domain.Cargo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class CargoDaoImpl extends AbstractDao<Cargo, Long> implements CargoDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void delete(long id) {
		Cargo cargo = findById(id);
		if (cargo != null) {
			entityManager.remove(cargo);
		}
	}

	@Override
	public Cargo findById(long id) {
		return entityManager.find(Cargo.class, id);
	}
}
