package br.com.hyperclass.caixaeletronico.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.hyperclass.caixaeletronico.config.SpringContextConfigurationTest;
import br.com.hyperclass.caixaeletronico.config.WebConfiguration;
import br.com.hyperclass.caixaeletronico.domain.caixa.CaixaEletronicoException;
import br.com.hyperclass.caixaeletronico.domain.caixa.CaixaEletronicoTest;
import br.com.hyperclass.caixaeletronico.domain.contacorrente.ContaCorrente;
import br.com.hyperclass.caixaeletronico.restapi.CaixaController;
import br.com.hyperclass.caixaeletronico.restapi.wrappers.ExtratoWrapper;
import br.com.hyperclass.caixaeletronico.restapi.wrappers.ValorWrapper;
import br.com.hyperclass.caixaeletronico.util.CaixaEletronicoComparator;

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
		final MvcResult result = mockMvc.perform(get("/54125-9/extrato")).andReturn();
		final String resultHttp = result.getResponse().getContentAsString();
		
		JSONAssert.assertEquals(extrato, resultHttp, new CaixaEletronicoComparator(mode));
		
	}
	
	@Test
	public void saldoTest() throws Exception {
		final ObjectMapper objectMapper = new ObjectMapper();
		final ContaCorrente conta = caixaTest.getContaCorrente("54125-9");
		conta.creditar(100);
		conta.creditar(100);
		conta.sacar(150);
		final String saldo = objectMapper.writeValueAsString(new ValorWrapper(conta.saldo()));
		final MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/54125-9/saldo")).andReturn();
		final String resultHttp = result.getResponse().getContentAsString();
		
		JSONAssert.assertEquals(resultHttp, saldo, true);
	}
	
	@Test
	public void saqueTest() throws Exception {
		final ObjectMapper objectMapper = new ObjectMapper();
		final ContaCorrente conta = caixaTest.getContaCorrente("54125-9");
		conta.creditar(1000);
		final String valor = objectMapper.writeValueAsString(new ValorWrapper(100.0));
		
		final MvcResult result = mockMvc.perform(post("/54125-9/saque")
				.content(valor)
				.contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andReturn();
		
		final int resulHttp = result.getResponse().getStatus();
		
		Assert.assertEquals(HttpStatus.OK.value(), resulHttp );
	}
	
	@Test
	public void depositoTest() throws Exception {
		final ObjectMapper objectMapper = new ObjectMapper();
		final ContaCorrente conta = caixaTest.getContaCorrente("54125-9");
		conta.creditar(1000);
		final String valor = objectMapper.writeValueAsString(new ValorWrapper(100.0));
		final MvcResult result = mockMvc.perform(post("/54125-9/deposito")
				.content(valor)
				.contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andReturn();
		
		final String valorEsperado = "{'valor':100.0}";
		
		final int resulHttp = result.getResponse().getStatus();
		Assert.assertEquals(HttpStatus.OK.value(), resulHttp );
		JSONAssert.assertEquals(valorEsperado, result, true);
	}	
	
	@Test
	public void transferenciaTest() throws CaixaEletronicoException {
		final ObjectMapper objectMapper = new ObjectMapper();
		final ContaCorrente conta = caixaTest.getContaCorrente("54125-9");
		
	}
	
}