package com.app.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.ExporterOption;
import org.apache.sling.models.annotations.Model;

import javax.inject.Inject;
import javax.inject.Named;

@Model(adaptables = Resource.class, resourceType = { "aem63/components/content/allField" }, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
@Exporter(name = "jackson", extensions = "json", options = { @ExporterOption(name = "SerializationFeature.WRITE_DATES_AS_TIMESTAMPS", value = "true") })
public class ExporterDemo {

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