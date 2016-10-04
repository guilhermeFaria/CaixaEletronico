package br.com.hyperclass.caixaeletronico.restapi.wrappers;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.com.hyperclass.caixaeletronico.restapi.deserializers.ValorWrapperDeserializer;
import br.com.hyperclass.caixaeletronico.restapi.serializers.ValorWrapperSerializer;
/**
 * A classe <code>ValorWrapper</code> é responsavel por contruir um modelo
 * da serialização de objeto Json.
 * @author Guilherme Faria
 *
 * @version 1.0.0 26/09/2016
 */
@JsonSerialize(using=ValorWrapperSerializer.class)
@JsonDeserialize(using=ValorWrapperDeserializer.class)
public class ValorWrapper {
	private final double value;
	
	public ValorWrapper (final double value) {
		this.value = value;
	}
	
	public double value() {
		return value;
	}
	
}
