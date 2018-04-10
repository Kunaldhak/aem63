package com.app.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

import javax.inject.Inject;
import javax.inject.Named;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class GenericModelDemo {

	@Inject
	String textArea;
	
	@Inject
	String textfield;
	
	@Inject
	String userpicker;
	
	@Inject
	String listItems;
	
	@Inject
	String datePicker;
	
	@Inject
	String CheckValue;


	@Inject
	@Named("sling:resourceType")
	String slingResourceType;
	

	public String getTextArea() {
		return textArea;
	}


	public String getTextfield() {
		return textfield;
	}


	public String getUserpicker() {
		return userpicker;
	}


	public String getListItems() {
		return listItems;
	}


	public String getDatePicker() {
		return datePicker;
	}


	public String getCheckValue() {
		return CheckValue;
	}




	public String getSlingResourceType() {
		return slingResourceType;
	}


}