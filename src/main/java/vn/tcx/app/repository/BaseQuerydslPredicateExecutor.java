package vn.tcx.app.repository;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseQuerydslPredicateExecutor<T> extends QuerydslPredicateExecutor<T>{

}
