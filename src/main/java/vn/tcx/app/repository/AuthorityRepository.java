package vn.tcx.app.repository;

import java.util.Optional;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import vn.tcx.app.entity.Authority;
import vn.tcx.app.entity.User;

/**
 * Spring Data JPA repository for the {@link Authority} entity.
 */
@Repository
public interface AuthorityRepository extends BaseRepository	<Authority, Long> {
	
	String AUTHORITY_BY_ID_CACHE = "authority.id";
	String AUTHORITY_BY_MA_CACHE = "authority.maVaiTro";

	@Query(value = "select a from Authority a where a.maVaiTro = :maVaiTro and a.daXoa = :daXoa")
	@Cacheable(cacheNames = AUTHORITY_BY_MA_CACHE)
	Optional<Authority> findByMaVaiTro(String maVaiTro,boolean daXoa);
	
//	@EntityGraph(attributePaths = "authorities")
//    @Cacheable(cacheNames = USERS_BY_LOGIN_CACHE)
//    Optional<User> findOneWithAuthoritiesByLogin(String login);
}
