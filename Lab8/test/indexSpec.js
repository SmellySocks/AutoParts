//const {toolbox} = require("../js/toolbox.js"); // load module - nodejs style
    function validateFirstName(firstName) {
        let elem = $( this );
        var len = firstName.length;
        const regex = /^[A-Z]+[a-z]*/;
        function validate() {
            return regex.test(String(firstName.val()));
        }

        if (len == 0) {
            console.log('Name should not be empty')
            return false;
        } else if (!validate()) {
            elem.addClass('invalid');
            console.log('Names usually start with a capital and contain only letters');
            return false;
        }
        else{
            elem.removeClass('invalid');
            console.log('gituwa');
            return true;
        }
    }
    function validatePESEL(pesel){
        let elem = $( this );
        var len = pesel.length;
        const regex = /^[0-9]{11}/;
        function validate() {
            return regex.test(String(pesel.val()));
        }

        if (len == 0) {
            console.log('PESEL should not be empty')
            return false;
        } else if (!validate()) {
            elem.addClass('invalid');
            console.log('Pesel should contain 11 digits and no other characters');
            return false;
        }
        else{
            elem.removeClass('invalid');
            console.log('gituwa');
            return true;
        }

    }

    describe('Validate form', function () {
        var label;

        beforeAll(function () {
            $('body').append(`
        <div>Poprawne imię:</div>
        <input type="text" id="firstName" class="" value="Michal">
        <div>Numer:</div>
        <input type="number" id="PESEL" class="" value="960310052777">
        <div>Pesel:</div>
        <div id="pesel" class="">95011503554</div>
        <div>Nip:</div>
        <div id="nip" class="">2228881100</div>
        <div>Email:</div>
        <div id="email" class="">sadas@gmail.com</div>
        `);
        });

    beforeEach(function () {}
    );

    afterEach(function () {
        $('#mycontainer').remove();
    });

    it("should check name validation", function () {
        $(".validate").click();
        expect(validateFirstName($('#firstName'))).toBe(true);
    });
    it("should check PESEL validation", function () {
        $(".validate").click();
        expect(validateFirstName($('#firstName'))).toBe(true);
    })

});