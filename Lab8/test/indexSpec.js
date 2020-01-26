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
        <input type="number" id="PESEL" class="" value="96031005277">
        <div>Pesel:</div>
        <input type="number" id="InvalidPESEL" class="" value="9asdfasdf">
        <div>Nip:</div>
        <input type="text" id="invalidFirstName" class="" value="2228881100">
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
        expect(validatePESEL($('#PESEL'))).toBe(true);
    });
    it("should check invalid PESEL", function () {
        $(".validate").click();
        expect(validatePESEL($('#InvalidPESEL'))).toBe(false);
    });
        it("should check invalidname validation", function () {
            $(".validate").click();
            expect(validateFirstName($('#invalidFirstName'))).toBe(false);
        });
});