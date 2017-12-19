const REGEX_LOGIN = new RegExp("(\\w){3,16}");
const REGEX_EMAIL = new RegExp("^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$");
const REGEX_PASSWORD = new RegExp("(\\w|\\d){5,16}");
const LOGIN_SELECTOR = '#login';
const EMAIL_SELECTOR = '#email';
const PASSWORD_SELECTOR = '#password';

$(document).ready(function() {

    var loginInput = $(LOGIN_SELECTOR);
    var emailInput = $(EMAIL_SELECTOR);
    var passwordInput = $(PASSWORD_SELECTOR);

    $(document).on('submit', "#registrationForm", function(){
            var login = loginInput.val();
            var email = emailInput.val();
            var password = passwordInput.val();
            var result = true;
            $("#loginErr").hide();
            $("#emailErr").hide();
            $("#passwordErr").hide();
            if(!REGEX_LOGIN.test(login)){
                $("#loginErr").show();
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
            return result;
    });
});
