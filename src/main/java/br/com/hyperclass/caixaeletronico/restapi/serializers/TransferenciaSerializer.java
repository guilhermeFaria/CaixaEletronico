package br.com.hyperclass.caixaeletronico.restapi.serializers;

import java.io.IOException;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonGenerator;

import br.com.hyperclass.caixaeletronico.domain.contacorrente.eventos.EventoTransacional;
import br.com.hyperclass.caixaeletronico.domain.contacorrente.eventos.ValorTransferidoEvento;
/**
 * A classe <code>TransferenciaSerializer</code> é responsavel por fazer a 
 * serialização dos eventos de transferencia de uma conta corrente
 * 
 * @author Guilherme Faria
 *
 * @version 1.0.0 29/09/2016
 */
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
		final ValorTransferidoEvento valorTransferidoEvento = (ValorTransferidoEvento) evento;
		generator.writeStringField("contaDestino", valorTransferidoEvento.getNumeroConta());
	}
}