package com.joy.insapi.manager;

import android.content.Context;

public class IGCommonFieldsManager {

	private Context mContext;
	private String mCsrftoken = "";
	private String mPkID = "";

	private static class InsCommonFieldsManagerHolder {
		private static IGCommonFieldsManager INSTANCE = new IGCommonFieldsManager();
	}

	public static IGCommonFieldsManager getInstance() {
		return InsCommonFieldsManagerHolder.INSTANCE;
	}

	public void init(Context context) {
		mContext = context;
	}

	public Context getContext() {
		return mContext;
	}


	public void saveCsrftoken(String csrftoken) {
		mCsrftoken = csrftoken;
	}

	public String getCsrftoken() {
		return mCsrftoken;
	}

	public  void savePKID(String PK_ID) {
		this.mPkID = PK_ID;
	}

	public  String getPKID() {
		return mPkID;
	}

}
