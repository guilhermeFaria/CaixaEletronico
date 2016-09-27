package br.com.hyperclass.caixaeletronico.restapi.serializers;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
public @interface Teste {

	public abstract String value() default "";
	public abstract String outroValor() default "";
}