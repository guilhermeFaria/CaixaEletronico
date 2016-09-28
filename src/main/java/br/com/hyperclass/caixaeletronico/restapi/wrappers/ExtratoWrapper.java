package br.com.hyperclass.caixaeletronico.restapi.wrappers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.com.hyperclass.caixaeletronico.domain.contacorrente.eventos.EventoTransacional;
import br.com.hyperclass.caixaeletronico.restapi.serializers.ExtratoWrapperSerializer;

@JsonSerialize(using= ExtratoWrapperSerializer.class)
public class ExtratoWrapper {
	
	private List<EventoTransacional> eventos = new ArrayList<EventoTransacional>();
	
	public ExtratoWrapper(List<EventoTransacional> evento) {
		this.eventos.addAll(evento);
	}
	
	public List<EventoTransacional> eventos() {
		return Collections.unmodifiableList(eventos);
	}
	
	
}
