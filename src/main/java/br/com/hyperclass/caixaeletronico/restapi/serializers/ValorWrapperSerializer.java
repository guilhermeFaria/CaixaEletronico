package br.com.hyperclass.caixaeletronico.restapi.serializers;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import br.com.hyperclass.caixaeletronico.restapi.wrappers.ValorWrapper;

public class ValorWrapperSerializer extends JsonSerializer<ValorWrapper>{

	@Override
	public void serialize(ValorWrapper arg0, JsonGenerator arg1, SerializerProvider arg2)
			throws IOException, JsonProcessingException {
		arg1.writeStartObject();
		arg1.writeNumberField("valor", arg0.value());
		arg1.writeEndObject();	
	}

}
