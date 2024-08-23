



console.log("hii-----------------")

fetch('http://localhost:1999/getallusers') // Change the URL to your actual endpoint
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok ' + response.statusText);
            }
            return response.json();
        })
        .then(data => {
            // console.log(data);

            finddata(data)
            document.getElementById('output').textContent = JSON.stringify(data, null, 2);
        })
        .catch(error => {
            // console.error('There was a problem with the fetch operation:', error);
        });

        function finddata(data){
            // console.log(data);

            data.forEach(element =>{
                console.log(element.mobileNo)
            });

        }