package br.com.hyperclass.caixaeletronico.restapi.deserializers;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;

import br.com.hyperclass.caixaeletronico.domain.contacorrente.eventos.EventoTransacional;
import br.com.hyperclass.caixaeletronico.restapi.Serializer;

public class DefaultSerializer implements Serializer {

	protected void serializerDefaulSerializer(EventoTransacional evento, JsonGenerator generator) throws IOException {
		
		generator.writeNumberField("Data", evento.getData().getTime());
		generator.writeObjectField("operacao", evento.getTipo());
		generator.writeNumberField("valor", evento.getValor());
	}
	
	@Override
	public void serializer(EventoTransacional evento, JsonGenerator generator) throws IOException {
		generator.writeStartObject();
		serializerDefaulSerializer(evento, generator);
		generator.writeEndObject();
		
	}
	
	
		
}
