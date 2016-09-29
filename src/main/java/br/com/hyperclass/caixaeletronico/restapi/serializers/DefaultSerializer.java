package br.com.hyperclass.caixaeletronico.restapi.serializers;

import java.io.IOException;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonGenerator;

import br.com.hyperclass.caixaeletronico.domain.contacorrente.eventos.EventoTransacional;
/**
 * A classe <code>DefaultSerializer<code> é reponsavel por serializar
 * os valores padrões<data><operacao><valor>
 * 
 * @author Guilherme Faria
 *
 * @version 1.0.0 28/09/2016
 */

@Component
public class DefaultSerializer implements Serializer {

	protected void serializeDefaultValues(final EventoTransacional evento, final JsonGenerator generator) throws IOException {
		generator.writeNumberField("Data", evento.getData().getTime());
		generator.writeObjectField("operacao", evento.getTipo());
		generator.writeNumberField("valor", evento.getValor());
	}
	
	@Override
	public void serialize(final EventoTransacional evento, final JsonGenerator generator) throws IOException {
		generator.writeStartObject();
		serializeDefaultValues(evento, generator);
		generator.writeEndObject();
		
	}
}