package com.joy.insapi.request;


import com.joy.insapi.manager.IGConfig;

public abstract class InsBaseRequest<R extends InsBaseResponseData> {
	protected InsRequestCallBack<R> mInsRequestCallBack;


	protected String getRequestUrl() {
		return IGConfig.API_V1 + getActionUrl();
	}

	protected abstract String getActionUrl();
	abstract void execute();

	public void execute(InsRequestCallBack<R> insRequestCallBack) {
		this.mInsRequestCallBack = insRequestCallBack;
		execute();
	}


}
