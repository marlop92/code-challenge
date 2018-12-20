package pl.mlopatka.codechallenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Import;
import pl.mlopatka.codechallenge.configurations.GlobalConfiguration;
import pl.mlopatka.codechallenge.configurations.SwaggerConfiguration;

@SpringBootConfiguration
@EnableAutoConfiguration
@Import({GlobalConfiguration.class, SwaggerConfiguration.class})
public class CodeChallengeApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodeChallengeApplication.class, args);
	}

}

