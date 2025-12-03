const btn = document.querySelector(".btn1");
const formContainer1 = document.querySelector(".form-container1");
const btn4 = document.querySelector(".btn4");
const formContainer4 = document.querySelector(".form-container4");
const btn6 = document.querySelector(".btn6");
const formContainer6 = document.querySelector(".form-container6");
// console.log("btn" , btn);
// console.log("formConatainer", formContainer)


btn.addEventListener("click", () => {
    console.log("in event listner")
    if(formContainer1.classList.contains("active")){
        formContainer1.classList.remove("active");
    }else{
        formContainer1.classList.add("active"); 
    }
})

btn4.addEventListener("click", () => {
    console.log("in event listner")
    if(formContainer4.classList.contains("active")){
        formContainer4.classList.remove("active");
    }else{
        formContainer4.classList.add("active"); 
    }
})

btn6.addEventListener("click", () => {
    console.log("in event listner")
    if(formContainer6.classList.contains("active")){
        formContainer6.classList.remove("active");
    }else{
        formContainer6.classList.add("active"); 
    }
})