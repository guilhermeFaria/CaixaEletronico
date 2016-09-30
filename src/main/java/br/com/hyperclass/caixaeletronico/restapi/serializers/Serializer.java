package br.com.hyperclass.caixaeletronico.restapi.serializers;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;

import br.com.hyperclass.caixaeletronico.domain.contacorrente.eventos.EventoTransacional;
/**
 * 
 * @author Guilherme Faria
 *
 * @version 1.0.0 28/06/2016
 */
public interface Serializer {
	
	public void serialize(EventoTransacional evento, JsonGenerator generator) throws IOException;
}