package br.com.hyperclass.caixaeletronico.restapi.deserializers;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import br.com.hyperclass.caixaeletronico.restapi.wrappers.TransferenciaWrapper;
/**
 * A classe <code>TransferenciaDeserializer</code> é a classe responsavel por fazer a deserialização
 * do objeto Json e pegar as informações e passar estes dados para a classe que o chama.
 * 
 * @author Guilherme Faria
 *
 * @version 1.0.0 29/09/2016
 */
public class TransferenciaDeserializer extends JsonDeserializer<TransferenciaWrapper> {

	@Override
	public TransferenciaWrapper deserialize(JsonParser jsonParser, DeserializationContext arg1)
			throws IOException {
		ObjectCodec oc = jsonParser.getCodec();
        JsonNode node = oc.readTree(jsonParser);
        return new TransferenciaWrapper(node.get("contaDestino").asText(), node.get("valor").asDouble());
	}
	

}
