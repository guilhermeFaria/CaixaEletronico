package br.com.hyperclass.caixaeletronico.config;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.hyperclass.caixaeletronico.domain.caixa.CaixaEletronico;
import br.com.hyperclass.caixaeletronico.domain.caixa.Nota;
import br.com.hyperclass.caixaeletronico.domain.caixa.ValorNota;
import br.com.hyperclass.caixaeletronico.domain.contacorrente.ContaCorrente;

/**
 * A classe <code>SpringContextConfiguration<code> é onde fica a configuração
 * do contexto do Spring da aplicação.
 * 
 * @author Guilherme Faria
 *
 * @version 1.0.0 26/09/2016
 * 
 */
@Configuration
public class SpringContextConfiguration {
	
	@Bean
	public CaixaEletronico caixaEletronico() {
		return new CaixaEletronico(carregarNotas(), carregarContas());
	}

	private List<ContaCorrente> carregarContas() {
		List<ContaCorrente> list = new ArrayList<>(4);
		list.add(new ContaCorrente("54125-9", 10854.78));
		list.add(new ContaCorrente("25214-8", 1050.99));
		list.add(new ContaCorrente("88452-1", 7696.00));
		list.add(new ContaCorrente("15935-7", 412.13));
		return list;
	}

	private Map<ValorNota, List<Nota>> carregarNotas() {
		final Map<ValorNota, List<Nota>> map = new EnumMap<>(ValorNota.class);
		map.put(ValorNota.UM, carregarListaNotas(3, ValorNota.UM));
		map.put(ValorNota.DOIS, carregarListaNotas(5, ValorNota.DOIS));
		map.put(ValorNota.DEZ, carregarListaNotas(2, ValorNota.DEZ));
		map.put(ValorNota.VINTE, carregarListaNotas(4, ValorNota.VINTE));
		map.put(ValorNota.CINQUENTA, carregarListaNotas(5, ValorNota.CINQUENTA));
		map.put(ValorNota.CEM, carregarListaNotas(10, ValorNota.CEM));
		return map;
		
	}
	
	private List<Nota> carregarListaNotas(final int quantidade, final ValorNota valorNota) {
		final List<Nota> list = new LinkedList<>();
		for (int i = 0; i < quantidade; i++) {
			list.add(new Nota(valorNota));
		}
		return list;
	}
}