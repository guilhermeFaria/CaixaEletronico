package br.com.hyperclass.caixaeletronico.restapi;

import org.springframework.beans.factory.annotation.Autowired;
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
import br.com.hyperclass.caixaeletronico.restapi.wrappers.NotasDisponiveisWrapper;
import br.com.hyperclass.caixaeletronico.restapi.wrappers.TransferenciaWrapper;
import br.com.hyperclass.caixaeletronico.restapi.wrappers.ValorWrapper;

/**
 * A classe <code>CaixaController</code> é responsavel por receber as
 * requisições referente aos recursos do Caixa Eletronico.
 * 
 * @author Guilherme Faria
 *
 * @version 1.0.0 26/09/2016
 */

@RestController
public class CaixaController {
	
	@Autowired
	private CaixaEletronico caixa;
	
	@RequestMapping(value = {"/","/{conta}/"}, method=RequestMethod.GET)
	public ResponseEntity<Object> welcome() {
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(value= "/{conta}/saldo", method=RequestMethod.GET)
	public ValorWrapper saldo(@PathVariable("conta") final String conta) throws CaixaEletronicoException {
		return new ValorWrapper(caixa.saldo(conta));
	}
	
	@RequestMapping(value="/{conta}/saque", method = RequestMethod.POST)
	public ResponseEntity<ValorWrapper> saque(@PathVariable("conta") final String conta, @RequestBody final ValorWrapper valorWrapper) throws CaixaEletronicoException {
		caixa.sacar(conta, valorWrapper.value());
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping(value="/{conta}/deposito")
	public ResponseEntity<ValorWrapper> deposito(@PathVariable("conta") final String conta, @RequestBody final ValorWrapper valorWrapper) throws CaixaEletronicoException {
		caixa.depositar(conta, valorWrapper.value());
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/{contaOrigem}/transferencia", method=RequestMethod.POST)
	public ResponseEntity<TransferenciaWrapper> transferencia(@PathVariable("contaOrigem") final String contaOrigem, @RequestBody final TransferenciaWrapper transferenciaWrapper) throws CaixaEletronicoException {
		caixa.transferir(contaOrigem, transferenciaWrapper.getNumeroConta(), transferenciaWrapper.getValor());
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/{conta}/extrato", method=RequestMethod.GET)
	public ExtratoWrapper extrato(@PathVariable("conta") final String conta) throws CaixaEletronicoException {
		return new ExtratoWrapper(caixa.extrato(conta));
	}
	
	@RequestMapping(value={"/notasDisponiveis","/{conta}/notasDisponiveis"}, method=RequestMethod.GET)
	public NotasDisponiveisWrapper notasDisponiveis(@PathVariable("conta") final String conta) throws CaixaEletronicoException {
		return new NotasDisponiveisWrapper(caixa.notasDisponiveis());
	}
}