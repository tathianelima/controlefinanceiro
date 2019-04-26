package br.com.tathiane;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.tathiane.domain.Categoria;
import br.com.tathiane.repositories.CategoriaRepository;

@SpringBootApplication
public class ControlefinanceiroApplication implements CommandLineRunner{   // CommandLineRunner - implementar alguma ação quando a execução começar

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(ControlefinanceiroApplication.class, args);
		
		
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria alimentacao = new Categoria(null, "Alimentação");
		Categoria lazer = new Categoria(null, "Lazer");
		
		categoriaRepository.saveAll(Arrays.asList(alimentacao,lazer));
	}

}
