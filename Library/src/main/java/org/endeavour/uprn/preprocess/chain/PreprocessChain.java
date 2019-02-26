package org.endeavour.uprn.preprocess.chain;

import org.endeavour.uprn.bean.Phase;
import org.endeavour.uprn.chain.AbstractChain;

public abstract class PreprocessChain extends AbstractChain {
	
	public Phase getPhase() {
		return Phase.PREPROCESSING;
	}
}
