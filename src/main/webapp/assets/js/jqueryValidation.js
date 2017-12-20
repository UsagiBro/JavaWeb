const REGEX_NAME = new RegExp("([a-zA-Zа-яА-Яё]){2,64}");
const REGEX_EMAIL = new RegExp("^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$");
const REGEX_PASSWORD = new RegExp("(\\w|\\d){5,16}");
const NAME_SELECTOR = '#name';
const SURNAME_SELECTOR = '#surname';
const EMAIL_SELECTOR = '#email';
const PASSWORD_SELECTOR = '#password';
const PASSWORD_REPEAT_SELECTOR = "#passwordRepeat";

$(document).ready(function() {

    var nameInput = $(NAME_SELECTOR);
    var surnameInput = $(SURNAME_SELECTOR);
    var emailInput = $(EMAIL_SELECTOR);
    var passwordInput = $(PASSWORD_SELECTOR);
    var passwordRepeatInput = $(PASSWORD_REPEAT_SELECTOR);

    $(document).on('submit', "#registrationForm", function(){
            var name = nameInput.val();
            var surname = surnameInput.val();
            var email = emailInput.val();
            var password = passwordInput.val();
            var passwordRepeat = passwordRepeatInput.val();
            var result = true;
            $("#nameErr").hide();
            $("#surnameErr").hide();
            $("#emailErr").hide();
            $("#passwordErr").hide();
            $("#passwordRepeatErr").hide();
            if(!REGEX_NAME.test(name)){
                $("#nameErr").show();
                result = false;
            }
            if(!REGEX_NAME.test(surname)){
                $("#surnameErr").show();
                result = false;
            }
            if(!REGEX_EMAIL.test(email)){
                $("#emailErr").show();
                result = false;
            }
            if(!REGEX_PASSWORD.test(password)){
                $("#passwordErr").show();
                result = false;
            }
            if(!(password === passwordRepeat)){
                $("#passwordRepeatErr").show();
                result = false;
            }
            return result;
    });
});

