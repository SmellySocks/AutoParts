// js module
export function toolbox() {
//exports.toolbox = function() { // module in nodejs style

    // some sample function - this function will not be exported
    let validateName = function(regex){
        this.each(function () {
            let elem = $( this );
            if(regex.test(elem.text())){
                elem.removeClass('invalid')
                return false;
            }
            else{
                elem.addClass('invalid')
                return true;
            }
        })
    };

    return {
        validate:function(x){
            if (x.selector) {
                document.querySelectorAll(x.selector).forEach(
                    (element) => {
                        element.innerHTML = validateName(element.innerHTML);
                    }
                );
                return {};
            } else {
                return validateName(x);
            }
        }
    };
};