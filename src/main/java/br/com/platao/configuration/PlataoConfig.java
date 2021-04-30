package br.com.platao.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import br.com.platao.domain.Student;

@Configuration
@ComponentScan("br.com.platao.component")
public class PlataoConfig {
	
	@Bean
	public Student studentLuis() {
		return new Student ("Luis","Franco");
	}

}
