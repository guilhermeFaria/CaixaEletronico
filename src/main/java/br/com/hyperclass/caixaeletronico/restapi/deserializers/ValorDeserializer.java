package br.com.hyperclass.caixaeletronico.restapi.deserializers;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import br.com.hyperclass.caixaeletronico.restapi.wrappers.ValorWrapper;
/**
 * A classe <code>ValorWrapperDeserializer</code> é a classe responsavel por fazer a deserialização
 * do objeto Json e pegar as informações e passar estes dados para a classe que o chama.
 * 
 * @author Guilherme Faria
 *
 * @version
 */
public class ValorDeserializer extends JsonDeserializer<ValorWrapper>{

	@Override
	public ValorWrapper deserialize(final JsonParser jsonParser, final DeserializationContext deserializationContext)
			throws IOException, JsonProcessingException {
		ObjectCodec oc = jsonParser.getCodec();
        JsonNode node = oc.readTree(jsonParser);
		
        return new ValorWrapper(node.get("valor").asDouble());
	}

}
