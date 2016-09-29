package br.com.hyperclass.caixaeletronico.restapi.serializers;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;

import br.com.hyperclass.caixaeletronico.domain.contacorrente.eventos.EventoTransacional;

public class TransferenciaSerializer implements Serializer {

	@Override
	public void serializer(EventoTransacional evento, JsonGenerator generator) throws IOException {
		// TODO Auto-generated method stub

	}

}
