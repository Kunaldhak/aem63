package com.app.core;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;

import com.adobe.cq.social.scf.ClientUtilities;
import com.adobe.cq.social.scf.QueryRequestInfo;
import com.adobe.cq.social.scf.SocialComponent;
import com.adobe.cq.social.scf.SocialComponentFactory;
import com.adobe.cq.social.scf.core.AbstractSocialComponentFactory;

public class handleBar extends AbstractSocialComponentFactory implements SocialComponentFactory{
@Override
public String getSupportedResourceType() {
   return "aem63/components/content/handlebar_POC";
}

@Override
public SocialComponent getSocialComponent(Resource resource, ClientUtilities clientUtilities, QueryRequestInfo queryRequestInfo) {
	// TODO Auto-generated method stub
	 return (SocialComponent) new handleBar();
}

@Override
public SocialComponent getSocialComponent(Resource arg0) {
	// TODO Auto-generated method stub
	return (SocialComponent) new handleBar();
}

@Override
public SocialComponent getSocialComponent(Resource arg0, SlingHttpServletRequest arg1) {
	// TODO Auto-generated method stub
	return (SocialComponent) new handleBar();
}
 

}