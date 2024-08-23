let container=document.getElementById("seccont")


document.querySelector('.card-number-input').oninput = () =>{
    document.querySelector('.card-number-box').innerText = document.querySelector('.card-number-input').value;
}

document.querySelector('.card-holder-input').oninput = () =>{
    document.querySelector('.card-holder-name').innerText = document.querySelector('.card-holder-input').value;
}

document.querySelector('.month-input').oninput = () =>{
    document.querySelector('.exp-month').innerText = document.querySelector('.month-input').value;
}

document.querySelector('.year-input').oninput = () =>{
    document.querySelector('.exp-year').innerText = document.querySelector('.year-input').value;
}

document.querySelector('.cvv-input').onmouseenter = () =>{
    document.querySelector('.front').style.transform = 'perspective(1000px) rotateY(-180deg)';
    document.querySelector('.back').style.transform = 'perspective(1000px) rotateY(0deg)';
}

document.querySelector('.cvv-input').onmouseleave = () =>{
    document.querySelector('.front').style.transform = 'perspective(1000px) rotateY(0deg)';
    document.querySelector('.back').style.transform = 'perspective(1000px) rotateY(180deg)';
}

document.querySelector('.cvv-input').oninput = () =>{
    document.querySelector('.cvv-box').innerText = document.querySelector('.cvv-input').value;
}




    let form=document.querySelector("form")
    form.addEventListener("submit",(e)=>{
        e.preventDefault()
        if(form.cninp.value===""&&form.chinp.value===""){
            console.log("somthing wrong")
            container.innerHTML=null
            popup1.classList.add("openpopup1")
        }
        // else{
        //     console.log("done");
        //     // openpopup()
        //     container.innerHTML=null
        //     popup.classList.add("openpopup")
        // }

            else{
                container.innerHTML=null
                popup3.classList.add("openpopup3")
                popup2.classList.add("openpopup2")
            }


    })


    function closepopup1(){
        popup1.classList.remove("openpopup1")
        window.location.reload()
    }
    // function closepopup2(){
    //     let otp=document.getElementById("otp")
    //     let otpval=otp.value
    //     if(otpval==="1234"){
    //         // window.location.reload()
    //         container.innerHTML=null
    //         popup1.classList.add("openpopup")
           
    //     }
    //     // else if(otpval==1234){
    //     //     openpopup()
    //     // }
    // }
    let otpbtn=document.getElementById("okbtn2")
    otpbtn.addEventListener("click",()=>{
        console.log("ok")
        let otp=document.getElementById("otp").value
        // let otpval=otp.value
        if(otp==="1234"){
            // window.location.reload()
            container.innerHTML=null
            popup2.classList.remove("openpopup2")
            popup.classList.add("openpopup")
           
        }
        else{
            popup3.classList.remove("openpopup3")
            popup4.classList.add("openpopup4")
        }
    })



    let otpbtn4=document.getElementById("okbtn4")
    otpbtn4.addEventListener("click",()=>{
        popup4.classList.remove("openpopup4")
        

    })