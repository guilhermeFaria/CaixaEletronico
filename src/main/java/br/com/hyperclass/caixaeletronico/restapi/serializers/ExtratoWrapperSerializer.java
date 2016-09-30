package br.com.hyperclass.caixaeletronico.restapi.serializers;

import java.io.IOException;
import java.util.EnumMap;
import java.util.Map;

import javax.annotation.Resource;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import br.com.hyperclass.caixaeletronico.domain.contacorrente.eventos.EventoTransacional;
import br.com.hyperclass.caixaeletronico.domain.contacorrente.eventos.TipoEvento;
import br.com.hyperclass.caixaeletronico.restapi.wrappers.ExtratoWrapper;

/**
 * A classe <code>ExtratoWrapperSerializer</code> efetua a serialização dos eventos ocorrido
 * em uma conta corrente retornando todos em um objeto Json
 * 
 * @author Guilherme Faria
 *
 * @version 1.0.0 28/09/2016
 */

public class ExtratoWrapperSerializer extends JsonSerializer<ExtratoWrapper> {

	private final Map<TipoEvento, Serializer> eventosSerializer = new EnumMap<>(TipoEvento.class);

	@Override
	public void serialize(final ExtratoWrapper extratoWrapper, final JsonGenerator generator,
			final SerializerProvider provider) throws IOException {
		generator.writeStartArray();

		for (final EventoTransacional eventos : extratoWrapper.eventos()) {
			final Serializer serializer = eventosSerializer.get(eventos.getTipo());
			serializer.serialize(eventos, generator);
		}
		generator.writeEndArray();

	}

	@Resource
	public void setEventosSerializer(final Map<TipoEvento, Serializer> eventosSerializer) {
		this.eventosSerializer.putAll(eventosSerializer);
	}
}