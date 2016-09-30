package br.com.hyperclass.caixaeletronico.restapi.serializers;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import br.com.hyperclass.caixaeletronico.restapi.wrappers.ValorWrapper;
/**
 * A classe <code>ValorWrapperSerializer</code> é responsavel 
 * por efetuar a serialização do objeto Json.
 * 
 * @author Guilherme Faria
 *
 * @version 1.0.0
 */
public class ValorWrapperSerializer extends JsonSerializer<ValorWrapper>{

	@Override
	public void serialize(final ValorWrapper valorWrapper, final JsonGenerator generator, final SerializerProvider serializerProvider)
			throws IOException, JsonProcessingException {
		generator.writeStartObject();
		generator.writeNumberField("valor", valorWrapper.value());
		generator.writeEndObject();	
	}
}