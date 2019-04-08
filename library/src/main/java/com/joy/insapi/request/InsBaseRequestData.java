package com.joy.insapi.request;


import com.joy.insapi.manager.utils.IGGsonUtil;

public class InsBaseRequestData {

	public String getPayLoad(){
		return  IGGsonUtil.parseBeanToStr(this);
	}

}
