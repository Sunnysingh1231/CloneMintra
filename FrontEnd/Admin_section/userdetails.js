let fetchdata = document.getElementsByClassName("appendData")[0];

function jhjjguguu(){
        fetch('http://localhost:1999/findallusers') // Change the URL to your actual endpoint
    .then(response => {
        if (!response.ok) {
            throw new Error('Network response was not ok ' + response.statusText);
        }
        return response.json();
    })
    .then(data => {
        console.log(data);
        appenddata(data)
        document.getElementById('output').textContent = JSON.stringify(data, null, 2);
    })
    .catch(error => {
        // console.error('There was a problem with the fetch operation:', error);
    });
    }
    
    jhjjguguu()

        function appenddata(data){
            data.forEach((element,index) => {
                console.log(element)
                let row = document.createElement("tr")

                let c1=document.createElement("td");
                c1.innerText=index+1+" / "+element.id;

                let c2=document.createElement("td");
                c2.innerText="*****";

                let c3=document.createElement("td");
                c3.innerText=element.name;

                let c4=document.createElement("td");
                c4.innerText=element.mobileNo;

                let c5=document.createElement("td");
                c5.innerText=element.password;

                let c6=document.createElement("td");
                c6.innerText=element.email;

                let c7=document.createElement("td");
                c7.innerText=element.createdAt;

                let c8=document.createElement("button");
                c8.innerText="Delete";

                c8.addEventListener("click",function(){
                    // console.log(element.id)
                    deleteData(element.id);
                    window.location.reload();
                })
        
                row.append(c1,c2,c3,c4,c5,c6,c7,c8)
                fetchdata.append(row)
            });
        }

            // --Delete user by id--------------------------

            async function deleteData(id) {
                try {
                    let res = await fetch(`http://localhost:1999/deletebyid/${id}`, {
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
                    console.log(data);
                    document.getElementById('output').textContent = JSON.stringify(data, null, 2);
                } catch (error) {
                    console.error('There was a problem with the delete operation:', error);
                }
            }