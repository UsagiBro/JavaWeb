
function validate() {

      var name = document.getElementById('name').value;
      var surname = document.getElementById('surname').value;
      var email = document.getElementById('email').value;
      var password = document.getElementById('password').value;
      var passwordRepeat = document.getElementById('passwordRepeat').value;

      if (!checkName(name)) {
        document.getElementById("nameErr").innerHTML="Name can contain only letters and be longer than 1 symbol";
        return false;
      }

      if (!checkName(surname)) {
        document.getElementById("surnameErr").innerHTML="Surname can contain only letters and be longer than 1 symbol";
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

      if(!(password === passwordRepeat)) {
        document.getElementById("passwordRepeatErr").innerHTML="Passwords don't match";
        result = false;
      }

}

function checkName(name) {
    var regex = new RegExp("([a-zA-Zа-яА-Яё]){2,64}");
    return regex.test(name);
}

function checkEmail(email) {
    var regex = new RegExp("^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$");
    return regex.test(email);
}

function checkPassword(password) {
    var regex = new RegExp("(\\w|\\d){5,16}");
    return regex.test(password);
}
