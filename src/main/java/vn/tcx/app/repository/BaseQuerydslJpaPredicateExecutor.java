package vn.tcx.app.repository;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.CrudMethodMetadata;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.QuerydslJpaPredicateExecutor;
import org.springframework.data.querydsl.EntityPathResolver;

public class BaseQuerydslJpaPredicateExecutor<T, ID> extends QuerydslJpaPredicateExecutor<T> implements BaseQuerydslPredicateExecutor<T>{

	public BaseQuerydslJpaPredicateExecutor(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager,
			EntityPathResolver resolver, CrudMethodMetadata metadata) {
		super(entityInformation, entityManager, resolver, metadata);
	}

}
