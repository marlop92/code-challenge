package pl.mlopatka.codechallenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import pl.mlopatka.codechallenge.configurations.GlobalConfiguration;

@SpringBootApplication
@Import(GlobalConfiguration.class)
public class CodeChallengeApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodeChallengeApplication.class, args);
	}

}

