/*
 * @(#)ValorTransferidoEvento.java 1.0 23/09/2016
 *
 * Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 * proprietary/confidential. Use is subject to license terms.
 */

package br.com.hyperclass.caixaeletronico.domain.contacorrente.eventos;

import br.com.hyperclass.caixaeletronico.domain.contacorrente.ContaCorrente;

/**
 * A classe <code>ValorTransferidoEvento</code> representa o evento de
 * transferência de um valor de uma conta corrente para outra conta.
 *
 * @author Roberto Perillo
 * @version 1.0 23 de set de 2016
 */
public class ValorTransferidoEvento extends EventoTransacional {

    private static final long serialVersionUID = 1L;

    public ValorTransferidoEvento(final ContaCorrente conta, final double valor, final TipoEvento tipo) {
        super(new ContextoTransferencia(conta, valor, tipo));
    }

    @Override
    public double atualizarSaldo(final double saldo) {
        return saldo + getValor();
    }
    
    @Override
    public ContextoTransferencia getSource() {
    	
       	return (ContextoTransferencia) super.getSource();
    }
}