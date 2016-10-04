package br.com.hyperclass.caixaeletronico.domain.caixa;

import java.util.List;
import java.util.Map;

import br.com.hyperclass.caixaeletronico.domain.contacorrente.ContaCorrente;

/**
 * 
 * @author Guilherme Faria
 *
 * @version 1.0.0 04/10/2016
 */

public class CaixaEletronicoTest extends CaixaEletronico{

	public CaixaEletronicoTest(final Map<ValorNota, List<Nota>> notas, final List<ContaCorrente> correntistas) {
		super(notas, correntistas);
	}
	
	public ContaCorrente getContaCorrente(final String contaCorrente) throws CaixaEletronicoException {
		return super.getContaCorrente(contaCorrente);
	}

}
