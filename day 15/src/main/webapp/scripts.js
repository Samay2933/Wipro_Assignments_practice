const btn = document.querySelector(".btn1");
const formContainer = document.querySelector(".form-container");
// console.log("btn" , btn);
// console.log("formConatainer", formContainer)


btn.addEventListener("click", () => {
    console.log("in event listner")
    if(formContainer.classList.contains("active")){
        formContainer.classList.remove("active");
    }else{
        formContainer.classList.add("active");
    }
})