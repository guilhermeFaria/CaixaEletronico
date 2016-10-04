package br.com.hyperclass.caixaeletronico.config;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import br.com.hyperclass.caixaeletronico.domain.caixa.CaixaEletronicoTest;
import br.com.hyperclass.caixaeletronico.domain.caixa.Nota;
import br.com.hyperclass.caixaeletronico.domain.caixa.ValorNota;
import br.com.hyperclass.caixaeletronico.domain.contacorrente.ContaCorrente;

/**
 * 
 * @author Guilherme Faria
 *
 * @version 1.0.0 04/10/2016
 * 
 */

@Configuration
@ComponentScan(basePackages = { "br.com.hyperclass.caixaeletronico.util"})
public class SpringContextConfigurationTest {

	@Bean
	public CaixaEletronicoTest caixaEletronicoTest() {
		return new CaixaEletronicoTest(carregarNotas(), carregarContas());
	}
	
	private List<ContaCorrente> carregarContas() {
		List<ContaCorrente> list = new ArrayList<>(1);
		list.add(new ContaCorrente("54125-9", 0.00));
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
