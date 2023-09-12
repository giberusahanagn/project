package com.xworkz.cm.repository;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.cm.entity.SignUpEntity;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class ProjectRepositoryImpl implements ProjectRepository {
	@Autowired
	private EntityManagerFactory entityManagerFactory;

	public ProjectRepositoryImpl() {
		log.info("create " + this.getClass().getSimpleName());
	}

	@Override
	public boolean save(SignUpEntity entity) {
		EntityManager manager = this.entityManagerFactory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(entity);
		transaction.commit();
		manager.close();
		return true;
	}

	@Override
	public Integer checkDuplicates(String userId, String email, long mobile) {
		EntityManager manager = this.entityManagerFactory.createEntityManager();
		try {
			Query query = manager.createNamedQuery("checkdupl");
			query.setParameter("userId", userId);
			query.setParameter("userEmail", email);
			query.setParameter("userMobile", mobile);
			int count = ((Long) query.getSingleResult()).intValue();
			log.info("duplicates value size" + count);
			return count;
		} finally {
			manager.close();
		}
	}

	@Override
	public List<SignUpEntity> signIn(String userId) {
		EntityManager manager = this.entityManagerFactory.createEntityManager();
		try {
			Query query = manager.createNamedQuery("signIn");
			query.setParameter("userId", userId);
			List<SignUpEntity> list = query.getResultList();
			return list;
		} finally {
			manager.close();
		}
	}

	@Override
	public boolean updateWrongLoginAttempts(String userId, int lockCount) {
		EntityManager entityManager = this.entityManagerFactory.createEntityManager();
		try {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			Query query = entityManager.createNamedQuery("lockCount");
			query.setParameter("lock", lockCount);
			query.setParameter("userId", userId);
			query.executeUpdate();
			entityTransaction.commit();
			return false;
		} finally {
			entityManager.close();
		}
	}

	@Override
	public List<SignUpEntity> findByEmail(String email) {
		EntityManager manager = this.entityManagerFactory.createEntityManager();
		try {
			Query query = manager.createNamedQuery("findByEmail");
			query.setParameter("email", email);
			List<SignUpEntity> list = query.getResultList();
			log.info("Total List found in repo.." + list.size());
			return list;
		} finally {
			manager.close();
		}
	}

	@Override
	public boolean updateResetPwd(String email, boolean resetPwd, String password) {
		EntityManager entityManager = this.entityManagerFactory.createEntityManager();
		try {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			Query query = entityManager.createNamedQuery("updatePassword");
			query.setParameter("resetPwd", resetPwd);
			query.setParameter("email", email);
			query.setParameter("password", password);
			query.setParameter("updatedBy", "System");
			query.setParameter("updatedDate", LocalDateTime.now());
			query.setParameter("otpRequestedTime", LocalDateTime.now().plusSeconds(120));

			query.executeUpdate();
			entityTransaction.commit();
			return false;
		} finally {
			entityManager.close();
		}

	}

	@Override
	public boolean updateConfirmPwd(String userId, boolean resetPwd, String password) {
		EntityManager entityManager = this.entityManagerFactory.createEntityManager();
		try {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			Query query = entityManager.createNamedQuery("updateConfirmPassword");
			query.setParameter("resetPwd", resetPwd);
			query.setParameter("userId", userId);
			query.setParameter("password", password);
			query.setParameter("updatedBy", userId);
			query.setParameter("updatedDate", LocalDateTime.now());
			query.executeUpdate();
			entityTransaction.commit();

			return false;
		} finally {
			entityManager.close();
		}
	}

	@Override
	public boolean updateProfile(SignUpEntity entity) {
		EntityManager manager = this.entityManagerFactory.createEntityManager();
		try {
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			manager.merge(entity);
			transaction.commit();
			return true;
		} finally {
			manager.close();
		}

	}

	@Override
	public SignUpEntity findByuserId(String userId) {
		log.info("find by id in repo.." + userId);
		EntityManager entitymanager = this.entityManagerFactory.createEntityManager();
		try {
			EntityTransaction transaction = entitymanager.getTransaction();
			transaction.begin();
			Query query = entitymanager.createNamedQuery("findByUserId");
			query.setParameter("userId", userId);
			SignUpEntity signupentity = (SignUpEntity) query.getSingleResult();
			transaction.commit();
			return signupentity;
		} finally {
			entitymanager.close();
		}
	}

	@Override
	public SignUpEntity entityByEmail(String email) {
		log.info("find by email in repo.." + email);
		EntityManager entitymanager = this.entityManagerFactory.createEntityManager();
		try {
			EntityTransaction transaction = entitymanager.getTransaction();
			transaction.begin();
			Query query = entitymanager.createNamedQuery("findByEmail");
			query.setParameter("email", email);
			SignUpEntity signupentity = (SignUpEntity) query.getSingleResult();
			transaction.commit();
			return signupentity;
		} finally {
			entitymanager.close();
		}
	}
}
