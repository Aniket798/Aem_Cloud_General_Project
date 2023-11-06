$(document).on("dialog-ready dialog-submit", function () {
    $("foundation-autocomplete[data-cq-dialog-xf-variation-validate='true']").on('change',xfvariationValidator);
})
function xfvariationValidator() {
    let error = false;
    const pageType = $(this).attr("data-pageType")
    if(pageType){
        $.ajax({
            async: false,
            type: "GET",
            url: this.value + "/jcr:content/sling:resourceType.json",
            contentType: "application/json"
        }).success(function (res) {
            const resType = res["sling:resourceType"];
            if(!resType || (resType && !resType.endsWith(pageType))){
                error = true;
            }
        }).error(function () { 
            error = true;
        })
    }
    if(error){
        validateComponentError($(this), $(this).attr("data-message"));
    }
    else {
        validateComponentError($(this), null);
    }

}
function validateComponentError(elem, errorMessage){
    elem.setCustomValidity(errorMessage);
    elem.checkValidity();
    elem.validationMessage();
    elem.updateErrorUI();
}