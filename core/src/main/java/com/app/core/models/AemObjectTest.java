package com.app.core.models;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.Model;

import com.adobe.acs.commons.models.injectors.annotation.AemObject;
import com.day.cq.wcm.api.Page;

@Model(adaptables = SlingHttpServletRequest.class)
public class AemObjectTest {

	// Injects currentPage using ScriptVariable annotation
	@AemObject
	Page currentPage;

	public String getPagePath() {
		return currentPage.getPath();
	}
}