package com.app.core.impl;

import java.util.HashMap;
import java.util.Map;

import javax.jcr.Node;
import javax.jcr.Session;
import org.apache.jackrabbit.commons.JcrUtils;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.app.core.PageCreateService;
import com.day.cq.commons.jcr.JcrConstants;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;

@Component
public class PageServiceImp implements PageCreateService {
	protected final Logger log = LoggerFactory.getLogger(this.getClass());
	private String user = "";

	private Session session;

	// Inject a Sling ResourceResolverFactory
	@Reference
	private ResourceResolverFactory resolverFactory;

	public String CreatePage(String pageName) {
		String pagePath = "/content/aem63/en";
		String templatePath = "/apps/aem63/templates/page-content";
		String pageTitle = "AEM Manual Page";
		Page newPage;
		PageManager pageManager;
		log.debug("page path : +pagePath \n");

		ResourceResolver resolver = null;

		try {

			// getting resourceResolver from ResourceResolverFactory with help of system user

			Map<String, Object> param = new HashMap<String, Object>();
			param.put(ResourceResolverFactory.SUBSERVICE, "getResourceResolver");
			resolver = resolverFactory.getServiceResourceResolver(param);

			// Invoke the adaptTo method to create a Session
			session = resolver.adaptTo(Session.class);

			// create a page manager instance
			pageManager = resolver.adaptTo(PageManager.class);

			// create a new page
			newPage = pageManager.create(pagePath, pageName, templatePath, pageTitle);
			log.debug("page is created \n ");
			if (newPage != null) {
				user = resolver.getUserID();
				//user=session.getUserID();

				Node newNode = newPage.adaptTo(Node.class);
				Node cont = newNode.getNode("jcr:content");
				if (cont != null) {
					Node rootNode = session.getRootNode();
					String path = rootNode.getPath();
					Node parNode = JcrUtils.getNodeIfExists(cont, "par");
					Node imageNode = JcrUtils.getOrCreateByPath(parNode.getPath() + "/image",JcrConstants.NT_UNSTRUCTURED, session);
					Node textNode = JcrUtils.getNodeIfExists(parNode, "text");
					imageNode.setProperty("sling:resourceType", "foundation/components/image");
					imageNode.setProperty("fileReference", "/content/dam/we-retail-screens/we-retail-instore-logo.png");
					textNode.setProperty("text", "<p>This page is created using page manager</p>");
					session.save();
				}
			}

			return pageName;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "";

	}

}