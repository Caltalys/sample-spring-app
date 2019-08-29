package vn.tcx.app.config;

import javax.validation.constraints.NotNull;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.web.cors.CorsConfiguration;

import lombok.Getter;
import lombok.Setter;

@ConfigurationProperties(prefix = "app.properties", ignoreUnknownFields = false)
@PropertySources({ @PropertySource(value = "classpath:git.properties", ignoreResourceNotFound = true),
		@PropertySource(value = "classpath:META-INF/build-info.properties", ignoreResourceNotFound = true) })
@Getter
public class ApplicationProperties {

	private boolean registerUserNeedActivate = false;
	private final Cache cache = new Cache();
	private final Swagger swagger = new Swagger();
	private final Security security = new Security();
	private final CorsConfiguration cors = new CorsConfiguration();
	private final Mail mail = new Mail();

	@Getter
	public static class Cache {

		private final Ehcache ehcache = new Ehcache();

		@Getter
		@Setter
		public static class Ehcache {
			private int timeToLiveSeconds = 3600;
			private long maxEntries = 100;
		}

	}

	@Getter
	@Setter
	public static class Swagger {
		private String title = "Application API";
		private String description = "API Documentation";
		private String version = "1.0.0";
		private String host;
		private String[] protocols = {};
		private boolean useDefaultResponseMessages = true;
		private String defaultIncludePattern = "/api/.*";

	}

	@Getter
	public static class Security {

		private final ClientAuthorization clientAuthorization = new ClientAuthorization();
		private final Authentication authentication = new Authentication();
		private final RememberMe rememberMe = new RememberMe();

		@Getter
		@Setter
		public static class ClientAuthorization {
			private String accessTokenUri = null;
			private String tokenServiceId = null;
			private String clientId = null;
			private String clientSecret = null;
		}

		public static class Authentication {

			private final Jwt jwt = new Jwt();

			public Jwt getJwt() {
				return jwt;
			}

			@Getter
			@Setter
			public static class Jwt {
				private String secret = null;
				private String base64Secret = null;
				private long tokenValidityInSeconds = 1800; // 0.5 hour
				private long tokenValidityInSecondsForRememberMe = 2592000; // 30 hours;
			}
		}

		@Getter
		@Setter
		public static class RememberMe {
			@NotNull
			private String key = null;
		}
	}

	@Getter
	@Setter
	public static class Mail {

		private boolean enabled = false;
		private String from = "";
		private String baseUrl = "";

	}
}
