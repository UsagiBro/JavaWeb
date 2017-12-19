
function validate() {

      var login = document.getElementById('login').value;
      var email = document.getElementById('email').value;
      var password = document.getElementById('password').value;

      if (!checkLogin(login)) {
        document.getElementById("loginErr").innerHTML="user login must contain only letters and be longer than 3 symbols";
        return false;
      }

      if (!checkEmail(email)) {
        document.getElementById("emailErr").innerHTML="Type valid email";
        return false;
      }

      if (!checkPassword(password)) {
        document.getElementById("passwordErr").innerHTML='Password can consist of letters and numbers and' +
        'must be longer than 4 symbols';
        return false;
      }

}

function checkLogin(login) {
    var regex = new RegExp("(\\w){3,16}");
    return regex.test(login);
}

function checkEmail(email) {
    var regex = new RegExp("^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$");
    return regex.test(email);
}

function checkPassword(password) {
    var regex = new RegExp("(\\w|\\d){5,16}");
    return regex.test(password);
}
