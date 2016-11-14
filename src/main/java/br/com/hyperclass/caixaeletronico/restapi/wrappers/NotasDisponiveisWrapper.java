package br.com.hyperclass.caixaeletronico.restapi.wrappers;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.com.hyperclass.caixaeletronico.domain.caixa.Nota;
import br.com.hyperclass.caixaeletronico.domain.caixa.ValorNota;
import br.com.hyperclass.caixaeletronico.restapi.serializers.NotasDisponiveisSerializer;
/**
 *A classe <code>NotasDisponiveisWrapper</code> é responsavel por contruir um modelo
 *da serialização de objeto Json relacionada as notas disponiveis do caixa
 *
 * @author Guilherme Faria
 *
 * @version 1.0.0 30/09/2016
 */
@JsonSerialize(using=NotasDisponiveisSerializer.class)
public class NotasDisponiveisWrapper {
	
	private Map<ValorNota, List<Nota>> notas;
	
	public NotasDisponiveisWrapper(Map<ValorNota, List<Nota>>notas) {
		this.notas = notas;
	}
	
	public Map<ValorNota, List<Nota>> getNotas() {
		return Collections.unmodifiableMap(notas);
	}	
}