package br.com.hyperclass.caixaeletronico.restapi.wrappers;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import br.com.hyperclass.caixaeletronico.restapi.deserializers.TransferenciaDeserializer;
/**
 * 
 * @author Guilherme Faria
 *
 * @version
 */

@JsonDeserialize(using=TransferenciaDeserializer.class)
public class TransferenciaWrapper {
	private final String numeroConta;
	private final double valor;
	
	public TransferenciaWrapper(final String numeroConta, final double valor) {
		this.numeroConta = numeroConta;
		this.valor = valor;
	}
	
	public String getNumeroConta() {
		return numeroConta;
	}
	
	public double getValor() {
		return valor;
	}
	
}