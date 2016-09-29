package br.com.hyperclass.caixaeletronico.restapi.serializers;

import java.io.IOException;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonGenerator;

import br.com.hyperclass.caixaeletronico.domain.contacorrente.eventos.EventoTransacional;

@Component
public class TransferenciaSerializer extends DefaultSerializer {

	@Override
	public void serialize(final EventoTransacional evento, final JsonGenerator generator) throws IOException {
		generator.writeStartObject();
		serializeDefaultValues(evento, generator);
		serializeTransferingValues(evento, generator);
		generator.writeEndObject();
		
	}

	private void serializeTransferingValues(final EventoTransacional evento, final JsonGenerator generator) throws IOException {
		generator.writeNumberField("transferencia", evento.getValor());
	}
}