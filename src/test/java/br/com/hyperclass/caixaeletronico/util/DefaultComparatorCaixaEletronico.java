package br.com.hyperclass.caixaeletronico.util;

import org.json.JSONException;
import org.json.JSONObject;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.skyscreamer.jsonassert.JSONCompareResult;
import org.skyscreamer.jsonassert.comparator.DefaultComparator;
/**
 * 
 * @author Roberto Perillo
 * @author Guilherme Faria
 *
 * @version 1.0.0 05/10/2016
 */
public class DefaultComparatorCaixaEletronico extends DefaultComparator {

	private final String[] ignoredTerms;

	public DefaultComparatorCaixaEletronico(final JSONCompareMode mode, final String... ignoredTerms) {
		super(mode);
		this.ignoredTerms = ignoredTerms;
	}

	public DefaultComparatorCaixaEletronico(final String... ignoredTerms) {
		this(JSONCompareMode.STRICT, ignoredTerms);
	}

	@Override
	public void compareValues(String prefix, Object expectedValue, Object actualValue, JSONCompareResult result)
			throws JSONException {
		if (expectedValue.getClass().isAssignableFrom(JSONObject.class)) {
			super.compareValues(prefix, expectedValue, actualValue, result);
		} else {
			boolean found = false;
			for (final String term : ignoredTerms) {
				if (prefix.endsWith("." + term)) {
					result.passed();
					found = true;
					break;
				}
			}
			if (!found) {
				super.compareValues(prefix, expectedValue, actualValue, result);
			}
		}
	}
}