package org.endeavour.uprn.match.chain;

import org.endeavour.uprn.bean.Phase;
import org.endeavour.uprn.chain.AbstractChain;

public abstract class MatchChain extends AbstractChain {
	
	public Phase getPhase() {
		return Phase.MATCHING;
	}
}
