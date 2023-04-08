package com.xworkz.sahana.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.sahana.configuration.ArmyConfiguration;
import com.xworkz.sahana.entity.ArmyEntity;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class ArmyRepositoryImpl implements ArmyRepository {

	@Autowired
	private EntityManagerFactory factory;

	public ArmyRepositoryImpl() {
		log.info("running " + this.getClass().getSimpleName());
	}

	@Override
	public boolean save(ArmyEntity entity) {
		log.info("running save method"+entity);
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(entity);
		transaction.commit();
		manager.close();
		return true;
	}

	@Override
	public ArmyEntity findById(int id) {
		log.info("running findByID method..." + id);
		EntityManager entityManager = factory.createEntityManager();
		ArmyEntity fromDb = entityManager.find(ArmyEntity.class, id);
		entityManager.close();
		return fromDb;
	}

	@Override
	public List<ArmyEntity> searchByCountry(String country) {
		log.info("running findByID method..." + country);
		EntityManager entityManager = factory.createEntityManager();

		try {
			Query query = entityManager.createNamedQuery("findByCountry");
			query.setParameter("country", country);
			List<ArmyEntity> list = query.getResultList();
			return list;
		} finally {
			entityManager.close();
		}

	}

	@Override
	public boolean update(ArmyEntity entity) {
		log.info("running update method in repository impl");
		EntityManager manager = factory.createEntityManager();
		try {
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			manager.merge(entity);
			transaction.commit();
			return true;
		} finally {
			manager.close();
			log.info("manger.close() closed..");
		}
	}

	@Override
	public boolean delete(int id) {
		log.info("running delete method in repository impl");
		EntityManager manager = factory.createEntityManager();
	ArmyEntity entity=	manager.find(ArmyEntity.class, id);
	
		try {
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			manager.remove(entity);
			transaction.commit();
			return true;
		} finally {
			manager.close();
			log.info("manger.close() closed..");
		}
	}
}
