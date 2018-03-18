"use strict";
use(["/libs/wcm/foundation/components/utils/AuthoringUtils.js"], function (AuthoringUtils) {
    var CONST = {
       PROP_TITLE: "jcr:title",
	PROP_DESCRIPTION: "jcr:description",
    }
    
    var hero = {}
    
    //Get the title text
    hero.text = properties.get(CONST.PROP_TITLE)
            || pageProperties.get(CONST.PROP_TITLE)
            || currentPage.name;

     hero.description = properties.get(CONST.PROP_DESCRIPTION)
            || pageProperties.get(CONST.PROP_DESCRIPTION);


    
    
    
    return hero;
});