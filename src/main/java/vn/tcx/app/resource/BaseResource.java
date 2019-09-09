package vn.tcx.app.resource;

import org.springframework.beans.factory.annotation.Value;

public class BaseResource {

	@Value("${spring.application.name}")
	protected String applicationName;
	
}
