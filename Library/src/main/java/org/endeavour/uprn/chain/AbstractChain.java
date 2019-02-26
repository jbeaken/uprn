package org.endeavour.uprn.chain;

import org.endeavour.uprn.bean.Address;
import org.endeavour.uprn.bean.Phase;
import org.endeavour.uprn.bean.Result;
import org.endeavour.uprn.chain.Chain;
import org.endeavour.uprn.preprocess.chain.PreprocessChain;

public abstract class AbstractChain implements Chain {
	
	private AbstractChain nextChain;
	
	
	protected void next(Address address, Result result) {
		if(nextChain != null) {
			nextChain.proceed(address, result);
		}
	}
	
	public void setNextChain(PreprocessChain nextChain) {
		this.nextChain = nextChain;
	}
}
