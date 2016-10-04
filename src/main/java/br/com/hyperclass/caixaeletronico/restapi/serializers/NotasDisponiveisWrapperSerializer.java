package br.com.hyperclass.caixaeletronico.restapi.serializers;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import br.com.hyperclass.caixaeletronico.restapi.wrappers.NotasDisponiveisWrapper;
/**
 * A classe <code>NotasDisponiveisWrapperSerializer</code> é responsavel pela
 * pela serialização do objeto Json referente as Notas disponiveis no Caixa.
 * @author Guilherme Faria
 *
 * @version 1.0.0 30/09/2016
 */
public class NotasDisponiveisWrapperSerializer extends JsonSerializer<NotasDisponiveisWrapper> {

	@Override
	public void serialize(NotasDisponiveisWrapper notasDisponiveisWrapper, JsonGenerator generator, SerializerProvider serializerProvider)
			throws IOException {
		generator.writeStartObject();
		generator.writeEndObject();
		
		
	}
	
	
	

}
