const signUpName = document.getElementById('name')
const signUpEmail = document.getElementById('email')
const signUpPass = document.getElementById('pass')
const signUpButton = document.getElementById('submit')


signUpButton.addEventListener('click', function(){
    console.log(signUpEmail.value);
     console.log(signUpPass.value);
    console.log(signUpName.value);
})

    
