package br.com.hyperclass.caixaeletronico.config;

import org.springframework.web.WebApplicationInitializer;
/*
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
*/
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
/**
 * A classe <code>WebApplicationInitializer</code> representa a inicializa��o
 * do contexto do Spring na aplica��o.
 * 
 * @author Guilherme Faria
 *
 * @version 1.0.0 26/09/2016
 */
public class CaixaEletronicoWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer implements WebApplicationInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] { SpringContextConfiguration.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { WebConfiguration.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/*"};
	}

}