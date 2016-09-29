package br.com.hyperclass.caixaeletronico.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import br.com.hyperclass.caixaeletronico.domain.caixa.CaixaEletronico;
import br.com.hyperclass.caixaeletronico.domain.caixa.Nota;
import br.com.hyperclass.caixaeletronico.domain.caixa.ValorNota;
import br.com.hyperclass.caixaeletronico.domain.contacorrente.ContaCorrente;
import br.com.hyperclass.caixaeletronico.domain.contacorrente.eventos.TipoEvento;
import br.com.hyperclass.caixaeletronico.restapi.serializers.DefaultSerializer;
import br.com.hyperclass.caixaeletronico.restapi.serializers.Serializer;
import br.com.hyperclass.caixaeletronico.restapi.serializers.TransferenciaSerializer;

@Configuration
@ComponentScan(basePackages = {"br.com.hyperclass.domain.caixaeletronico"})
public class SpringContextConfiguration {
	private final Map<ValorNota, List<Nota>> cedulas = new HashMap<ValorNota, List<Nota>>();
	
	@Bean
	public CaixaEletronico caixaEletronico() {
		return new CaixaEletronico(carregarNotas(), carregarContas());
	}
	
	private List<ContaCorrente> carregarContas() {
		List<ContaCorrente> caixa = new ArrayList<ContaCorrente>();
		caixa.add(new ContaCorrente("54125-9", 10854.78));
		caixa.add(new ContaCorrente("25214-8", 1050.99));
		caixa.add(new ContaCorrente("88452-1",7696.00));
		caixa.add(new ContaCorrente("15935-7", 412.13));
		return caixa;
	}
	
	private Map<ValorNota, List<Nota>> carregarNotas() {
		
		for(int i = 0; i < 3; i++) {
			Nota nota = new Nota(ValorNota.CEM);
			adicionarCedulasCaixa(ValorNota.CEM, nota);
		}
		
		for(int i = 0; i < 4; i++){
			Nota nota = new Nota(ValorNota.CINQUENTA);
			adicionarCedulasCaixa(ValorNota.CINQUENTA, nota);
		}
		
		for(int i = 0; i < 20; i++){
			Nota nota = new Nota(ValorNota.VINTE);
			adicionarCedulasCaixa(ValorNota.VINTE, nota);
		}
		
		for(int i = 0; i < 10; i++){
			Nota nota = new Nota(ValorNota.DEZ);
			adicionarCedulasCaixa(ValorNota.DEZ, nota);
		}
		
		return cedulas;
	}
	private void adicionarCedulasCaixa(ValorNota valor, Nota cedula) {
		List<Nota> notasList = cedulas.get(valor);
		
		if(notasList == null){
			notasList = new ArrayList<Nota>();
		}
		
		notasList.add(cedula);
		cedulas.put(valor, notasList);
	}
	@Bean
	private Map<TipoEvento, Serializer> carregaTipos() {
		Map<TipoEvento, Serializer> eventos = new HashMap<TipoEvento, Serializer>();
		eventos.put(TipoEvento.SALDO_INICIAL, new DefaultSerializer());
		eventos.put(TipoEvento.SAQUE, new DefaultSerializer());
		eventos.put(TipoEvento.DEPOSITO, new DefaultSerializer());
		eventos.put(TipoEvento.TRANSFERENCIA_ENTRADA, new TransferenciaSerializer());
		eventos.put(TipoEvento.TRANSFERENCIA_SAIDA, new TransferenciaSerializer());
		
		return eventos;
		
		
	}
}