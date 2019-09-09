package vn.tcx.app.resource;

import java.net.URI;
import java.net.URISyntaxException;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.tcx.app.dto.AuthorityDTO;
import vn.tcx.app.entity.Authority;
import vn.tcx.app.errors.BadRequestAlertException;
import vn.tcx.app.repository.AuthorityRepository;
import vn.tcx.app.service.AuthorityService;
import vn.tcx.app.utils.HeaderUtil;

@RestController
@RequestMapping("/api")
public class AuthorityResource extends BaseResource{
	
	private final Logger log = LoggerFactory.getLogger(AuthorityResource.class);
	
	private final AuthorityRepository authorityRepository;
	
	private final AuthorityService authorityService;
	
	public AuthorityResource(AuthorityRepository authorityRepository, AuthorityService authorityService) {
		this.authorityRepository = authorityRepository;
		this.authorityService = authorityService;
	}

	@PostMapping("/authorities")
	public ResponseEntity<Authority> createAuthority(@Valid @RequestBody AuthorityDTO authorityDTO) throws URISyntaxException {
		log.debug("REST request to save AuthorityDTO : {}", authorityDTO);
		if (authorityDTO.getId() != null) {
            throw new BadRequestAlertException("A new authority cannot already have an ID", "authorityManagement", "idexists");
        } else {
        	Authority authority  = authorityService.createAuthority(authorityDTO);
        	return ResponseEntity.created(new URI("/api/authorities/" + authority.getId()))
                .headers(HeaderUtil.createAlert(applicationName,  "A authority is created with identifier " + authority.getId(), authority.getMaVaiTro()))
                .body(authority);
        }
	}
	
}
