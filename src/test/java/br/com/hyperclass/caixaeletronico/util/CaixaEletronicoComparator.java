package br.com.hyperclass.caixaeletronico.util;

import org.json.JSONException;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.skyscreamer.jsonassert.JSONCompareResult;
import org.skyscreamer.jsonassert.comparator.DefaultComparator;

public class CaixaEletronicoComparator extends DefaultComparator {

	public CaixaEletronicoComparator(JSONCompareMode mode) {
		super(mode);
		super.compareValues(prefix, expectedValue, actualValue, result);
	}
	
	
	@Override
	public void compareValues(String prefix, Object expectedValue, Object actualValue, JSONCompareResult result)
			throws JSONException {
		result.passed();
	}
	
}