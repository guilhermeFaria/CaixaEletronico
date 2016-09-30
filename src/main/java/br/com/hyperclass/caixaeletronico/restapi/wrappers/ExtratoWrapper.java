package br.com.hyperclass.caixaeletronico.restapi.wrappers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.com.hyperclass.caixaeletronico.domain.contacorrente.eventos.EventoTransacional;
import br.com.hyperclass.caixaeletronico.restapi.serializers.ExtratoWrapperSerializer;
/** 
 * 
 * @author Guilherme Faria
 *
 * @version 1.0.0 29/09/2016
 */
@JsonSerialize(using = ExtratoWrapperSerializer.class)
public class ExtratoWrapper {
	
	private final List<EventoTransacional> eventos = new ArrayList<EventoTransacional>();
	
	public ExtratoWrapper(final List<EventoTransacional> evento) {
		this.eventos.addAll(evento);
	}
	
	public final List<EventoTransacional> eventos() {
		return Collections.unmodifiableList(eventos);
	}
}