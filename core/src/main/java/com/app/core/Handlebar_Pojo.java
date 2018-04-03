package com.app.core;


import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceUtil;
import org.apache.sling.api.resource.ValueMap;

import com.adobe.cq.social.scf.ClientUtilities;
import com.adobe.cq.social.scf.QueryRequestInfo;
import com.adobe.cq.social.scf.core.BaseSocialComponent;

public class Handlebar_Pojo extends BaseSocialComponent {

	public Handlebar_Pojo(Resource resource, ClientUtilities clientUtils, QueryRequestInfo queryInfo) {
		super(resource, clientUtils);
		init(resource);
	}

	private String text;



	public String text() {
		return text;
	}


	private void init(Resource resource) {
		ValueMap valueMap = ResourceUtil.getValueMap(resource);
		this.text = valueMap.get("text", String.class);
		
	}
}