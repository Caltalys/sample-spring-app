package vn.tcx.app.service;

import java.util.Objects;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.tcx.app.config.ApplicationProperties;
import vn.tcx.app.dto.AuthorityDTO;
import vn.tcx.app.entity.Authority;
import vn.tcx.app.repository.AuthorityRepository;
import vn.tcx.app.repository.UserRepository;

@Service
@Transactional
public class AuthorityService extends BaseService{

	private final Logger log = LoggerFactory.getLogger(AuthorityService.class);
	
	private final AuthorityRepository authorityRepository;
	
	public AuthorityService(ApplicationProperties properties, AuthorityRepository authorityRepository, CacheManager cacheManager) {
		super(properties, cacheManager);
		this.authorityRepository = authorityRepository;
	}

	public Authority createAuthority(AuthorityDTO authorityDTO) {
		Authority auth = Authority.builder()
				.maVaiTro(authorityDTO.getMaVaiTro())
				.tenVaiTro(authorityDTO.getTenVaiTro())
				.moTa(authorityDTO.getMoTa())
				.build();
		authorityRepository.save(auth);
		this.clearCaches(auth);
        log.debug("Created Information for Authority: {}", auth);
        return auth;
	}

	//TODO check evict key
	private void clearCaches(Authority auth) {
		Objects.requireNonNull(cacheManager.getCache(AuthorityRepository.AUTHORITY_BY_ID_CACHE)).evict(auth.getId());
	}

	
	
}
