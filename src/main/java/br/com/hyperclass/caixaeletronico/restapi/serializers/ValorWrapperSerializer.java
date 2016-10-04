package br.com.hyperclass.caixaeletronico.restapi.serializers;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import br.com.hyperclass.caixaeletronico.restapi.wrappers.ValorWrapper;
/**
 * A classe <code>ValorWrapperSerializer</code> � responsavel 
 * por efetuar a serializa��o do objeto Json.
 * 
 * @author Guilherme Faria
 *
 * @version 1.0.0 25/09/2016
 */
public class ValorWrapperSerializer extends JsonSerializer<ValorWrapper> {

	@Override
	public void serialize(final ValorWrapper valorWrapper, final JsonGenerator generator, final SerializerProvider serializerProvider)
			throws IOException {
		generator.writeStartObject();
		generator.writeNumberField("valor", valorWrapper.value());
		generator.writeEndObject();	
	}
}