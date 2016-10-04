package br.com.hyperclass.caixaeletronico.restapi.wrappers;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.com.hyperclass.caixaeletronico.domain.caixa.Nota;
import br.com.hyperclass.caixaeletronico.domain.caixa.ValorNota;
import br.com.hyperclass.caixaeletronico.restapi.serializers.NotasDisponiveisWrapperSerializer;
/**
 *A classe <code>NotasDisponiveisWrapper</code> � responsavel por contruir um modelo
 *da serializa��o de objeto Json relacionada as notas disponiveis do caixa
 *
 * @author Guilherme Faria
 *
 * @version 1.0.0 30/09/2016
 */
@JsonSerialize(using=NotasDisponiveisWrapperSerializer.class)
public class NotasDisponiveisWrapper {
	
	private Map<ValorNota, List<Nota>> notas;
	
	public NotasDisponiveisWrapper(Map<ValorNota, List<Nota>>notas) {
		this.notas = notas;
		
	}
	
	
	
}