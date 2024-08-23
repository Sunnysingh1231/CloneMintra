let dproduct = document.getElementsByClassName("dproduct")[0]

let allProduct = document.getElementsByClassName("allProduct")[0]
let datasec = document.getElementsByClassName("datasec")[0]

let AddProduct = document.getElementsByClassName("addproduct")[0]
let addpro = document.getElementsByClassName("addpro")[0]

let updateProducts = document.getElementsByClassName("updateProducts")[0]
let modifypro = document.getElementsByClassName("modifypro")[0]

// --fetch data from api and print on the All product page------------------------

allProduct.addEventListener("click", function(e){
    
    addpro.classList.remove("active_addpro")
    modifypro.classList.remove("active_modifypro")
    e.preventDefault()
    datasec.classList.add("active_dform")
    findAllProductFromAPI()

})

AddProduct.addEventListener("click", function(e){
    e.preventDefault();
    datasec.classList.remove("active_dform")
    modifypro.classList.remove("active_modifypro")

    addpro.classList.add("active_addpro")
})

updateProducts.addEventListener("click", function(e){

    datasec.classList.remove("active_dform")
    addpro.classList.remove("active_addpro")

    e.preventDefault();
    modifypro.classList.add("active_modifypro")
})

//  all product tbody section-----------------------

        function appenddata(data){
            dproduct.innerHTML = null
            data.forEach((element,index) => {

                let row = document.createElement("tr")

                let c1=document.createElement("td");
                c1.innerText=index+1+" / "+element.id;

                let c2=document.createElement("td");
                c2.innerText=element.product_image;

                let c3=document.createElement("td");
                c3.innerText=element.brand_name;

                let c4=document.createElement("td");
                c4.innerText=element.category;

                let c5=document.createElement("td");
                c5.innerText=element.type;

                let c6=document.createElement("td");
                c6.innerText=element.market_price;

                let c7=document.createElement("td");
                c7.innerText=element.sale_price;

                let c8=document.createElement("td");

                let c9=document.createElement("button");
                c9.innerText="Delete";

                c9.addEventListener("click",function(e){
                    deleteProductFromAPI(element.id)                    
                })

                c8.append(c9)
        
                row.append(c1,c2,c3,c4,c5,c6,c7,c8)
                dproduct.append(row)
            });
        }


        function findAllProductFromAPI(){
            fetch('http://localhost:1999/findallproduct') // Change the URL to your actual endpoint
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok ' + response.statusText);
            }
            return response.json();
        })
        .then(data => {
            // console.log(data);
            appenddata(data)
            document.getElementById('output').textContent = JSON.stringify(data, null, 2);
        })
        .catch(error => {
            // console.error('There was a problem with the fetch operation:', error);
        });
        }

//-------Delete method from API--------------------------------------------------------------

        async function deleteProductFromAPI(id) {
            try {
                let res = await fetch(`http://localhost:1999/deletproductebyid/${id}`, {
                    method: 'DELETE',
                    headers: {
                        'Content-Type': 'application/json'
                    }
                });
        
                // Check if the response status is OK (200-299)
                if (!res.ok) {
                    throw new Error(`Error: ${res.status} ${res.statusText}`);
                }
        
                // Parse the JSON response
                let data = await res.json();
                console.log(id);
                document.getElementById('output').textContent = JSON.stringify(data, null, 2);
            } catch (error) {
                console.error('There was a problem with the delete operation:', error);
            }
        }

// ----------Add New Product Section------------------------------------------------

let form = document.getElementsByClassName("add1")[0];

form.addEventListener("submit", function(e){
    e.preventDefault();
    
    let ProDetail = {
        product_image : form.add3.value,
        brand_name : form.add4.value,
        category : form.add5.value,
        type : form.add6.value,
        market_price : form.add7.value,
        sale_price : form.add8.value
    }

    addNewProductInAPI(ProDetail)

    
})

async function addNewProductInAPI(ProDetail) {
    try {
        let res = await fetch(`http://localhost:1999/addnewproduct`, {
            method: 'POST',
            body:JSON.stringify(ProDetail),
            headers: {
                'Content-Type': 'application/json'
            }
        });

        // Check if the response status is OK (200-299)
        if (!res.ok) {
            throw new Error(`Error: ${res.status} ${res.statusText}`);
        }

        // Parse the JSON response
        let data = await res.json();
        console.log(data);
        document.getElementById('output').textContent = JSON.stringify(data, null, 2);
    } catch (error) {
        // console.error('There was a problem with the delete operation:', error);
    }
    alert("Product Added successfully")
}

// <!-- -------Modify Product Section-------------------------------------------------------- -->

let mod3 = document.getElementsByClassName("mod2")[0]
let modbutton = document.getElementsByClassName("mod4")[0]

let mod11Form = document.getElementsByClassName("mod11")[0]

let Product_Image = document.getElementById("mod5")
let Brand_Name = document.getElementById("mod6")
let Category = document.getElementById("mod7")
let Type = document.getElementById("mod8")
let Market_Price = document.getElementById("mod9")
let Sale_Price = document.getElementById("mod10")
let id = []

modbutton.addEventListener("click",function(){
    let a = mod3.value;
    id.push(a)

    fetch(`http://localhost:1999/findproductbyid/${id}`) // Change the URL to your actual endpoint
    .then(response => {
        if (!response.ok) {
            throw new Error('Network response was not ok ' + response.statusText);
        }
        return response.json();
    })
    .then(data => {
        console.log(data);
        findmModifydata(data);
        document.getElementById('output').textContent = JSON.stringify(data, null, 2);
    })
    .catch(error => {
        console.error('There was a problem with the fetch operation:', error);
    });

    function findmModifydata(data){
        Product_Image.value = data.product_image;
        Brand_Name.value = data.brand_name;
        Category.value = data.category;
        Type.value = data.type;
        Market_Price.value = data.market_price;
        Sale_Price.value = data.sale_price;
    }


})

mod11Form.addEventListener("submit",function(e){
    e.preventDefault();
    let updateData = {
        product_image : mod11Form.mod5.value,
        brand_name : mod11Form.mod6.value,
        category : mod11Form.mod7.value,
        type : mod11Form.mod8.value,
        market_price : mod11Form.mod9.value,
        sale_price : mod11Form.mod10.value
    }

    console.log(+id[0]);
    updateProductInAPI(updateData,id)
})

async function updateProductInAPI(updateData,id) {
    try {
        let res = await fetch(`http://localhost:1999/updateproductbyid/${id}`, {
            method: 'PATCH',
            body:JSON.stringify(updateData),
            headers: {
                'Content-Type': 'application/json'
            }
        });

        // Check if the response status is OK (200-299)
        if (!res.ok) {
            throw new Error(`Error: ${res.status} ${res.statusText}`);
        }

        // Parse the JSON response
        let data = await res.json();
        console.log(data);
        document.getElementById('output').textContent = JSON.stringify(data, null, 2);
    } catch (error) {
        console.error('There was a problem with the delete operation:', error);
    }
    alert("Product Updeted successfully")
    window.location.reload();
}