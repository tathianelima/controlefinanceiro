package br.com.tathiane;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.tathiane.domain.CartaoDeCredito;
import br.com.tathiane.domain.Categoria;
import br.com.tathiane.domain.Comprador;
import br.com.tathiane.domain.ContaGeral;
import br.com.tathiane.domain.FaturaCredito;
import br.com.tathiane.domain.FaturaDebito;
import br.com.tathiane.domain.MovimentoCredito;
import br.com.tathiane.domain.enums.EstadoPagamento;
import br.com.tathiane.repositories.CartaoDeCreditoRepository;
import br.com.tathiane.repositories.CategoriaRepository;
import br.com.tathiane.repositories.CompradorRepository;
import br.com.tathiane.repositories.ContaGeralRepository;
import br.com.tathiane.repositories.FaturaCreditoRepository;
import br.com.tathiane.repositories.FaturaDebitoRepository;
import br.com.tathiane.repositories.MovimentoCreditoRepository;

@SpringBootApplication
public class ControlefinanceiroApplication implements CommandLineRunner{   // CommandLineRunner - implementar alguma ação quando a execução começar

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private CompradorRepository compradorRepository;
	@Autowired
	private MovimentoCreditoRepository movimentoCreditoRepository;
	@Autowired
	private CartaoDeCreditoRepository cartaoDeCreditoRepository;
	@Autowired
	private FaturaCreditoRepository faturaCreditoRepository;
	@Autowired
	private ContaGeralRepository contaGeralRepository;
	@Autowired
	private FaturaDebitoRepository faturaDebitoRepository;
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(ControlefinanceiroApplication.class, args);
		
		
	}

	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("MM/yyyy");
		
		Categoria alimentacao = new Categoria(null, "Alimentação");
		Categoria lazer = new Categoria(null, "Lazer");
		
		Comprador renan = new Comprador(null, "Renan");
		Comprador dani = new Comprador(null, "Dani");
		
		CartaoDeCredito santander = new CartaoDeCredito(null, "Santander");
		CartaoDeCredito nuBank = new CartaoDeCredito(null, "NuBank");
		
		ContaGeral junho = new ContaGeral(null, sdf.parse("06/2019"), 0.00, 0.00);
		
		FaturaDebito faturaDebitoJunho = new FaturaDebito(null, sdf.parse("06/2019"), junho);

		junho.setFaturaDebito(faturaDebitoJunho);
		
		FaturaCredito faturaCreditoJunho = new FaturaCredito(null, sdf.parse("06/2019"), 0, EstadoPagamento.NAOPAGO, junho);
		
		MovimentoCredito blusa = new MovimentoCredito(null, sdf.parse("06/2019"), 30.99, "Blusa", lazer, dani, santander, faturaCreditoJunho);
		MovimentoCredito comidas = new MovimentoCredito(null, sdf.parse("06/2019"), 30.99, "Comidas", alimentacao, dani, nuBank, faturaCreditoJunho);
		faturaCreditoJunho.getCompras().addAll(Arrays.asList(blusa, comidas));
		
	
		contaGeralRepository.saveAll(Arrays.asList(junho));
		
		categoriaRepository.saveAll(Arrays.asList(alimentacao,lazer));
		compradorRepository.saveAll(Arrays.asList(renan, dani));
		cartaoDeCreditoRepository.saveAll(Arrays.asList(santander, nuBank));
		faturaCreditoRepository.saveAll(Arrays.asList(faturaCreditoJunho));
		movimentoCreditoRepository.saveAll(Arrays.asList(blusa, comidas));
		
		faturaDebitoRepository.saveAll(Arrays.asList(faturaDebitoJunho));
		
	
		
	}

}
