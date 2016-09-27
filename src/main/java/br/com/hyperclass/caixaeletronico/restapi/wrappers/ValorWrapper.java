package br.com.hyperclass.caixaeletronico.restapi.wrappers;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.com.hyperclass.caixaeletronico.restapi.deserializers.ValorWrapperDeserializer;
import br.com.hyperclass.caixaeletronico.restapi.serializers.ValorWrapperSerializer;

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
