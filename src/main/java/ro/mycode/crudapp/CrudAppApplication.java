package ro.mycode.crudapp;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ro.mycode.crudapp.masina.models.Masina;
import ro.mycode.crudapp.masina.repository.MasinaRepo;
import ro.mycode.crudapp.masina.view.View;

import java.beans.Transient;
import java.util.Arrays;
import java.util.Optional;

@SpringBootApplication
@Slf4j
public class CrudAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudAppApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(MasinaRepo masinaRepo , View view){
		return  args->{
	//view.play();
//			Optional<Masina> masina=masinaRepo.findMasinaByMarcaAndModel("Q",1999);
//			if(masina.isPresent()){
//				System.out.println(masina.get());
//			}else{
//
//				System.out.println("Masina nu exista");
//			}




		};
	}

}
