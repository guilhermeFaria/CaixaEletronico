package br.com.hyperclass.caixaeletronico.restapi.serializers;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;

import br.com.hyperclass.caixaeletronico.domain.contacorrente.eventos.EventoTransacional;

public interface Serializer {
	
	public abstract void serializer(EventoTransacional evento, JsonGenerator generator) throws IOException;
	
}
