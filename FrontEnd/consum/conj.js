let cont = document.getElementsByClassName("da2")[0];
// document.getElementsByName()


function findallproduct(data){
    data.forEach(element => {
        
        let d1 = document.createElement("div")
        let d2 = document.createElement("div")
        let d3 = document.createElement("div")
        let d4 = document.createElement("div")

        let img1 = document.createElement("img")
        img1.setAttribute("src",element.image)

        let h3 = document.createElement("h3")
        h3.innerText = element.category

        let p1 = document.createElement("p")
        p1.innerText = "lorem -----------"

        let p2 = document.createElement("p")
        p2.innerText = element.type

        let p3 = document.createElement("p")
        p3.innerText = "Price - "+element.price+".00/-"

        let p4 = document.createElement("button")
        p4.innerText = "Add wishlist";

        let p5 = document.createElement("button")
        p5.innerText = "Add bag"

        d4.append(img1)

        d2.append(d4,h3,p1,p3)
        d3.append(p4,p5)

        d1.append(d2,d3)

        // d1.append(img1,h3,p1,p3,p4,p5)
        cont.append(d1)

    });
}


function localApi(){
    fetch("https://fakestoreapi.com/products")
  .then((res) => res.json())
  .then((json) => {

    console.log(json)
    // findallproduct(json)

    })
}
localApi();


//     function getdatafromapi(){
//         fetch('https://fakestoreapi.com/products') // Change the URL to your actual endpoint
//     .then(response => {
//         if (!response.ok) {
//             throw new Error('Network response was not ok ' + response.statusText);
//         }
//         return response.json();
//     })
//     .then(data => {
//         console.log(data);
//         findallproduct(data)
//         document.getElementById('output').textContent = JSON.stringify(data, null, 2);
//     })
//     .catch(error => {
//         console.error('There was a problem with the fetch operation:', error);
//     });
//     }
// getdatafromapi()