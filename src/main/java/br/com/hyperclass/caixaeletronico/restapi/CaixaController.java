package br.com.hyperclass.caixaeletronico.restapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.hyperclass.caixaeletronico.domain.caixa.CaixaEletronico;
import br.com.hyperclass.caixaeletronico.domain.caixa.CaixaEletronicoException;
import br.com.hyperclass.caixaeletronico.restapi.wrappers.ExtratoWrapper;
import br.com.hyperclass.caixaeletronico.restapi.wrappers.ValorWrapper;


@RestController
public class CaixaController {
	@Autowired
	@Qualifier("caixaEletronico")
	private CaixaEletronico caixa;
	
	@RequestMapping(value = "/", method=RequestMethod.GET)
	public String welcome() {
		return "Bem vindo ao Caixa Eletronico v1.0";
	}
	
	@RequestMapping(value= "{conta}/saldo", method=RequestMethod.GET)
	public ValorWrapper saldo(@PathVariable String conta) throws CaixaEletronicoException {
		return new ValorWrapper(caixa.saldo(conta));
	}
	
	@RequestMapping(value="{conta}/saque", method = RequestMethod.POST)
	public ResponseEntity saque(@PathVariable String conta, @RequestBody double valor) throws CaixaEletronicoException {
		caixa.sacar(conta, valor);
		return new ResponseEntity( HttpStatus.OK);
	}
	
	@PostMapping(value="{conta}/deposito")
	public ResponseEntity deposito(@PathVariable String conta, @RequestBody double valor) throws CaixaEletronicoException {
		caixa.depositar(conta, valor);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@RequestMapping(value="{contaOrigem}/transferencia/{contaDestino}/{valor}", method=RequestMethod.POST)
	public String transferencia(@PathVariable String contaOrigem, @PathVariable String contaDestino, @PathVariable double valor) throws CaixaEletronicoException {
		caixa.transferir(contaOrigem, contaDestino, valor);
		return "";
	}
	@RequestMapping(value="{conta}/extrato", method=RequestMethod.GET)
	public ExtratoWrapper extrato(@PathVariable String conta) throws CaixaEletronicoException {
		return new ExtratoWrapper(caixa.extrato(conta));
	}
	
	
}