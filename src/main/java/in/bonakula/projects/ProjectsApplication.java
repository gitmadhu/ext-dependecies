package in.bonakula.projects;

import in.bonakula.projects.service.ExtensionsService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories({"in.bonakula.projects.repo"})
@ComponentScan("in.bonakula.projects")
public class ProjectsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectsApplication.class, args);

	}

	@Bean
	public CommandLineRunner getAllExtensions(ExtensionsService extensionsService){
		return (args) -> {
			extensionsService.getAllExtensions();
		};

	}

}
