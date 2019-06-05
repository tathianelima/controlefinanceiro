package br.com.tathiane;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.tathiane.domain.Cartao;
import br.com.tathiane.domain.Categoria;
import br.com.tathiane.domain.Comprador;
import br.com.tathiane.domain.ContaGeral;
import br.com.tathiane.domain.Credito;
import br.com.tathiane.domain.Debito;
import br.com.tathiane.domain.FaturaCredito;
import br.com.tathiane.domain.Receita;
import br.com.tathiane.domain.enums.EstadoPagamento;
import br.com.tathiane.repositories.CartaoRepository;
import br.com.tathiane.repositories.CategoriaRepository;
import br.com.tathiane.repositories.CompradorRepository;
import br.com.tathiane.repositories.ContaGeralRepository;
import br.com.tathiane.repositories.CreditoRepository;
import br.com.tathiane.repositories.DebitoRepository;
import br.com.tathiane.repositories.FaturaCreditoRepository;
import br.com.tathiane.repositories.GastoPrevistoRepository;
import br.com.tathiane.repositories.InvestimentoRepository;
import br.com.tathiane.repositories.ReceitaRepository;

@SpringBootApplication
public class ControlefinanceiroApplication implements CommandLineRunner{   // CommandLineRunner - implementar alguma ação quando a execução começar

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private CompradorRepository compradorRepository;
	@Autowired
	private CreditoRepository creditoRepository;
	@Autowired
	private CartaoRepository cartaoRepository;
	@Autowired
	private FaturaCreditoRepository faturaCreditoRepository;
	@Autowired
	private ContaGeralRepository contaGeralRepository;
	@Autowired
	private DebitoRepository debitoRepository;
	@Autowired
	private InvestimentoRepository investimentoRepository;
	@Autowired
	private GastoPrevistoRepository gastoPrevistoRepository;
	@Autowired
	private ReceitaRepository receitaRepository;
	
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(ControlefinanceiroApplication.class, args);
		
		
	}

	@Override
	public void run(String... args) throws Exception {
		

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Categoria alimentacao = new Categoria(null, "Alimentação");
		Categoria lazer = new Categoria(null, "Lazer");
		
		Comprador renan = new Comprador(null, "Renan");
		Comprador dani = new Comprador(null, "Dani");
		
		Cartao santander = new Cartao(null, "Santander");
		Cartao nuBank = new Cartao(null, "NuBank");
		
		ContaGeral junho = new ContaGeral(null, sdf.parse("01/06/2019"));
		
		Receita receitaJunho = new Receita(null, sdf.parse("01/06/2019"), 1300.00, "vencimentos", junho);
		Debito almoco = new Debito(null, sdf.parse("05/06/2019"), 7.00, "Almoço", alimentacao, junho);
		Debito blusaFrio = new Debito(null, sdf.parse("05/06/2019"), 30.00, "Blusa", lazer, junho);

		
		FaturaCredito faturaCreditoJunho = new FaturaCredito(null, sdf.parse("01/06/2019"), EstadoPagamento.PAGO, junho);
		
		Credito blusa = new Credito(null, sdf.parse("03/06/2019"), 30.99, "Blusa", lazer, dani, santander, faturaCreditoJunho);
		Credito comidas = new Credito(null, sdf.parse("02/06/2019"), 30.99, "Comidas", alimentacao, dani, nuBank, faturaCreditoJunho);
		faturaCreditoJunho.getCompras().addAll(Arrays.asList(blusa, comidas));
		
	
		contaGeralRepository.saveAll(Arrays.asList(junho));
		
		categoriaRepository.saveAll(Arrays.asList(alimentacao,lazer));
		compradorRepository.saveAll(Arrays.asList(renan, dani));
		cartaoRepository.saveAll(Arrays.asList(santander, nuBank));
		faturaCreditoRepository.saveAll(Arrays.asList(faturaCreditoJunho));
		creditoRepository.saveAll(Arrays.asList(blusa, comidas));
		debitoRepository.saveAll(Arrays.asList(almoco, blusaFrio));
		receitaRepository.saveAll(Arrays.asList(receitaJunho));
	
		
	}

}
