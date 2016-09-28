package br.com.hyperclass.caixaeletronico.restapi.serializers;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import br.com.hyperclass.caixaeletronico.domain.contacorrente.eventos.EventoTransacional;
import br.com.hyperclass.caixaeletronico.domain.contacorrente.eventos.TipoEvento;
import br.com.hyperclass.caixaeletronico.restapi.Serializer;
import br.com.hyperclass.caixaeletronico.restapi.wrappers.ExtratoWrapper;

public class ExtratoWrapperSerializer extends JsonSerializer<ExtratoWrapper>{
	private final Map<TipoEvento, Serializer> eventosSerializer;
	
	@Autowired
	public ExtratoWrapperSerializer(Map<TipoEvento, Serializer> eventoSerializer) {
		super();
		this.eventosSerializer = eventoSerializer;
	}
	
	@Override
	public void serialize(ExtratoWrapper extratoWrapper, JsonGenerator generator, SerializerProvider arg2)
			throws IOException, JsonProcessingException {
		generator.writeStartArray();
		
		for(final EventoTransacional eventos: extratoWrapper.eventos()) {			
			Serializer s = eventosSerializer.get(eventos.getTipo());
			s.serializer(eventos, generator);
		}
		generator.writeEndArray();
		
	}

}
