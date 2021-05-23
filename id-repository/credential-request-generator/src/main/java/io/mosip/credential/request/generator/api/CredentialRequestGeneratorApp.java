package io.mosip.credential.request.generator.api;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;

import io.mosip.idrepository.core.helper.RestHelper;
import io.mosip.idrepository.core.security.IdRepoSecurityManager;
import io.mosip.idrepository.core.util.DummyPartnerCheckUtil;
import io.mosip.kernel.dataaccess.hibernate.config.HibernateDaoConfig;

/**
 * The Class CredentialRequestGeneratorApp.
 *
 * @author Sowmya
 */
@SpringBootApplication(exclude = HibernateDaoConfig.class)
@Import(value = { java.lang.String.class, DummyPartnerCheckUtil.class, RestHelper.class, IdRepoSecurityManager.class })
@ComponentScan(basePackages = { "io.mosip.credential.request.generator.*", "io.mosip.idrepository.core.*",
		"${mosip.auth.adapter.impl.basepackage}" }, excludeFilters = @ComponentScan.Filter(type = FilterType.REGEX, pattern = {
				"io.mosip.kernel.biometrics.*", "io.mosip.idrepository.core.entity",
				"io.mosip.kernel.dataaccess.hibernate.config.HibernateDaoConfig" }))
@EnableBatchProcessing
@EnableScheduling
public class CredentialRequestGeneratorApp {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(CredentialRequestGeneratorApp.class, args);
	}
}
