package vn.tcx.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.tcx.app.entity.Authority;

/**
 * Spring Data JPA repository for the {@link Authority} entity.
 */
public interface AuthorityRepository extends JpaRepository<Authority, String> {
}
