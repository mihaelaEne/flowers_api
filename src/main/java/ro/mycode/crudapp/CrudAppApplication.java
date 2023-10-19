package ro.mycode.crudapp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ro.mycode.crudapp.masina.repository.MasinaRepo;

@SpringBootApplication
@Slf4j
public class CrudAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudAppApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(MasinaRepo masinaRepo){
		return  args->{


			  masinaRepo.getAllMarci().stream().forEach(marca->{
				  log.info(marca);
			  });//din lista acceseaza eleemnt cu elemnt si executa codul


		};


	}

}
