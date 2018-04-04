package com.app.core.models;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ScriptVariable;

import com.day.cq.wcm.api.Page;

@Model(adaptables = SlingHttpServletRequest.class)
public class TestModel {
   
/*  Script Variable: This Injector is used to get the currentPage, PageManager, Design, PageProperties etc. 
	This injector is adaptable to request.
	This injector is adaptable to SlingHttpServletRequest.*/
	
//Injects currentPage using ScriptVariable annotation)
	
    @ScriptVariable(name="currentPage")
    Page page;

    public String getPagePath() {
        return  page.getPath();
    }
}
