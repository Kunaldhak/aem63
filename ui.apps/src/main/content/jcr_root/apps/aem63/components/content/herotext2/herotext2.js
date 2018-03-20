"use strict";
use(["/libs/wcm/foundation/components/utils/AuthoringUtils.js"], function (AuthoringUtils) {
    var CONST = {
       PROP_TITLE: "jcr:Heading",
	PROP_DESCRIPTION: "jcr:description"
    }

    var hero = {}
    
    //Get the title text
    hero.text = properties.get(CONST.PROP_TITLE)
            || pageProperties.get(CONST.PROP_TITLE);

     hero.description = properties.get(CONST.PROP_DESCRIPTION)
            || pageProperties.get(CONST.PROP_DESCRIPTION);

	return hero;
});