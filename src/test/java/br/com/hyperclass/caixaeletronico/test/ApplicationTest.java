package br.com.hyperclass.caixaeletronico.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.hyperclass.caixaeletronico.config.SpringContextConfigurationTest;
import br.com.hyperclass.caixaeletronico.config.WebConfiguration;
import br.com.hyperclass.caixaeletronico.domain.caixa.CaixaEletronicoException;
import br.com.hyperclass.caixaeletronico.domain.caixa.CaixaEletronicoTest;
import br.com.hyperclass.caixaeletronico.domain.contacorrente.ContaCorrente;
import br.com.hyperclass.caixaeletronico.restapi.CaixaController;
import br.com.hyperclass.caixaeletronico.restapi.wrappers.ExtratoWrapper;
import br.com.hyperclass.caixaeletronico.restapi.wrappers.ValorWrapper;

/**
 * 
 * @author Guilherme Faria
 *
 * @version 1.0.0 04/10/2016
 */
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringContextConfigurationTest.class, WebConfiguration.class})
public class ApplicationTest {
	private MockMvc mockMvc;
	
	@Autowired
	private CaixaController controller;
	
	@Autowired
	@Qualifier("caixaEletronicoTest")
	private CaixaEletronicoTest caixaTest;
	
	@Before
	public void setupApplication() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}

	@Test
	public void extratoTest() throws Exception {
		final ObjectMapper objectMapper = new ObjectMapper();
		final ContaCorrente conta = caixaTest.getContaCorrente("54125-9");
		conta.creditar(100);
		conta.sacar(50);
		conta.creditar(20);
		final String extrato = objectMapper.writeValueAsString(new ExtratoWrapper(conta.extrato()));
		mockMvc.perform(get("/54125-9/extrato"))
			.andExpect(status().isOk())
			.andExpect(content().string(extrato));	
	}
	
	@Test
	public void saldoTest() throws Exception {
		final ObjectMapper objectMapper = new ObjectMapper();
		final ContaCorrente conta = caixaTest.getContaCorrente("54125-9");
		conta.creditar(100);
		conta.creditar(100);
		conta.sacar(150);
		final String saldo = objectMapper.writeValueAsString(new ValorWrapper(conta.saldo()));
		
		mockMvc.perform(MockMvcRequestBuilders.get("/54125-9/saldo"))
			.andExpect(status().isOk())
			.andExpect(content().string(saldo));	
	}
	
	@Test
	public void saqueTest() throws Exception {
		final ObjectMapper objectMapper = new ObjectMapper();
		final ContaCorrente conta = caixaTest.getContaCorrente("54125-9");
		conta.creditar(100);
		conta.creditar(100);
		final String saldo = objectMapper.writeValueAsString(new ExtratoWrapper(conta.extrato()));
		
		
		mockMvc.perform(post("/54125-9/saque"))
		//	.contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
		//	.content(json)
			.andExpect(status().isOk())
			.andExpect(content().string(saldo));	
	}	
}