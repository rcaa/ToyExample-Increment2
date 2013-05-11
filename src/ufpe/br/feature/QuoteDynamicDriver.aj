package ufpe.br.feature;

import ufpe.br.util.Util;

public aspect QuoteDynamicDriver {
	
	Object around() : adviceexecution() && within(ufpe.br.feature.Quote) {
		Object ret = null;
		if (Driver.isActivated("quote")){
			ret = proceed();
		}
		else {
			try {
				ret = Util.proceedAroundCallAtAspectJ(thisJoinPoint);
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
		return ret;
	}
}