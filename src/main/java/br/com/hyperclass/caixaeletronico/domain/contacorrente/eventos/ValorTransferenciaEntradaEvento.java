package br.com.hyperclass.caixaeletronico.domain.contacorrente.eventos;

import br.com.hyperclass.caixaeletronico.domain.contacorrente.ContaCorrente;
/**
 * A classe <code>ValorTransferenciaEntradaEvento</code> representa o evento de
 * transferência de entrada de valor de uma conta corrente para outra conta.
 * 
 * @author Guilherme Faria
 *
 * @version 1.0.0 30/09/2016
 */
public class ValorTransferenciaEntradaEvento extends ValorTransferidoEvento {

	private static final long serialVersionUID = 1L;

	public ValorTransferenciaEntradaEvento(ContaCorrente conta, double valor) {
		super(conta, valor, TipoEvento.TRANSFERENCIA_ENTRADA);
	}

	@Override
	public double atualizarSaldo(double saldo) {
		return saldo + getValor();
	}

}
