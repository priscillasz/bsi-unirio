// const form = document.querySelector("form"),
//     passField = form.querySelector(".create-password"),
//     passInput = passField.querySelector(".password"),
//     cPassField = form.querySelector(".confirm-password"),
//     cPassInput = cPassField.querySelector(".cPassword");
//
// // Hide and show password
// const eyeIcons = document.querySelectorAll(".show-hide");
//
// eyeIcons.forEach((eyeIcon) => {
//     eyeIcon.addEventListener("click", () => {
//         const pInput = eyeIcon.parentElement.querySelector("input"); //getting parent element of eye icon and selecting the password input
//         if (pInput.type === "password") {
//             eyeIcon.classList.replace("bx-hide", "bx-show");
//             return (pInput.type = "text");
//         }
//         eyeIcon.classList.replace("bx-show", "bx-hide");
//         pInput.type = "password";
//     });
// });
//
// // Password Validation
// function createPass() {
//     const passPattern =
//         /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/;
//
//     if (!passInput.value.match(passPattern)) {
//         return passField.classList.add("invalid"); //adding invalid class if password input value do not match with passPattern
//     }
//     passField.classList.remove("invalid"); //removing invalid class if password input value matched with passPattern
// }
//
// // Confirm Password Validtion
// function confirmPass() {
//     if (passInput.value !== cPassInput.value || cPassInput.value === "") {
//         return cPassField.classList.add("invalid");
//     }
//     cPassField.classList.remove("invalid");
// }
//
// // Calling Funtion on Form Sumbit
// form.addEventListener("submit", (e) => {
//     e.preventDefault(); //preventing form submitting
//     createPass();
//     confirmPass();
//
//     //calling function on key up
//     passInput.addEventListener("keyup", createPass);
//     cPassInput.addEventListener("keyup", confirmPass);
//
//     if (
//         !passField.classList.contains("invalid") &&
//         !cPassField.classList.contains("invalid")
//     ) {
//         location.href = form.getAttribute("action");
//     }
// });


function validateForm() {
    //collect form data in JavaScript variables
    var pw1 = document.getElementById("pswd1").value;
    var pw2 = document.getElementById("pswd2").value;

    if(pw1 != pw2) {
        document.getElementById("message2").innerHTML = "As senhas não são iguais.";
        return false;
    }
    // else {
    //     alert ("Your password created successfully");
    //     document.write("JavaScript form has been submitted successfully");
    // }
}