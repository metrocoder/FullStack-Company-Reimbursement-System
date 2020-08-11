// Table row template
{/* <tr>
          <td class="text-center">CATEGORY</td>
          <td class="text-center">Employee Notes</td>
          <td class="text-center">Amount</td>
          <td class="text-center">  
            <!-- Button to Open the Modal -->
            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">
              Open modal
            </button>
        </td>
        </tr> */}

async function populateEmployeeTable()
{
    let tableBody = document.getElementById("tableBody");

    let response = await fetch(`http://ec2-3-16-56-22.us-east-2.compute.amazonaws.com:7070/reimbursements?employeeId=${JSON.parse(localStorage.getItem("data"))[0].eid}`);
    let info = await response.json();

    for (let index = 0; index < info.length; index++) {
        const element = info[index];
        // console.log(element);
        
        let cData = await fetchCategoryData(element.cid);
        // let cElement = cData[0];
        // console.log(cData);
        tableBody.innerHTML += `
            <tr>
                <td class="text-center">${cData.title}</td>
                <td class="text-center" style="word-wrap: break-word;">${element.employee_note}</td>
                <td class="text-center">${element.amount}</td>
                <td class="text-center">  
                    <!-- Button to Open the Modal -->
                    <button onclick="populateEmployeeModal(${element.eid},${element.rid});" type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">
                        Open modal
                    </button>
                </td>
            </tr>
        `;
    }
}


// Modal Employee Card Template
/* <img class="card-img-top" src="https://robohash.org/johndoe/?set=set2" alt="Card image">
<div class="card-body">
    <h4 class="card-title">John Doe</h4>
    <p class="card-text">Some example text.</p>
</div> 
*/
async function populateEmployeeModal(eid,rid) {
    // Using the employee id and reimbursement id we have all we need to display
    populateEmployeeCard(eid);
    populateModalReimbursementDetails(rid);
    return;
}

async function fetchCategoryData(cid)
{
    let response = await fetch(`http://ec2-3-16-56-22.us-east-2.compute.amazonaws.com:7070/expense-category/${cid}`);
    let info = await response.json();
    return info;
}

async function fetchReimbursementById(rid)
{
    let response = await fetch(`http://ec2-3-16-56-22.us-east-2.compute.amazonaws.com:7070/reimbursement/${rid}`);
    let info = await response.json();
    return info;
}

async function fetchEmployeeData(eid)
{
    let response = await fetch(`http://ec2-3-16-56-22.us-east-2.compute.amazonaws.com:7070/employee/${eid}`);
    let info = await response.json();
    return info;
}

async function populateEmployeeCard(eid) 
{
    let eData = await fetchEmployeeData(eid);
    let modalCard = document.getElementById("modalCard");
    // let element = eData[0];

    modalCard.innerHTML +=`
        <img class="card-img-top" src="${eData.image_url}" alt="Card image">
        <div class="card-body">
            <h4 class="card-title">${eData.name}</h4>
            <p class="card-text">Email: ${eData.email}</p>
        </div> 
    `;
    return;
}

async function populateModalReimbursementDetails(rid)
{
    let modalAmount = document.getElementById("modalAmount");
    let modalCategory = document.getElementById("modalCategory");
    let modalNotes = document.getElementById("modalNotes");
    let thumbsUp = document.getElementById("thumbsUp");
    let thumbsDown = document.getElementById("thumbsDown");
    let modalComment = document.getElementById("modalComment");

    let rData = await fetchReimbursementById(rid);
    // let element = rData[0];
    // console.log(rData);
    let cData = await fetchCategoryData(rData.cid);
    // let cElement = cData[0];

    modalAmount.innerHTML = `$ ${rData.amount}`;
    modalCategory.innerHTML = `${cData.title}`;
    modalNotes.innerHTML = `${rData.employee_note}`;
    modalComment.innerHTML = `${rData.manager_note}`;
    // console.log(rData.manager_note);

    if(cData.status === 0)
    {
        thumbsUp.style.color = "gray"
        thumbsDown.style.color = "red"
    }
    else
    {
        thumbsUp.style.color = "green"
        thumbsDown.style.color = "gray"
    }


    return;
}

// Reimbursement bullet Template
/* <div class="form-check">
<label class="form-check-label" for="radio1">
    <input type="radio" class="form-check-input" id="radio1" name="optradio" value="option1" checked>Option 1
</label>
</div> */
async function populateBullets()
{
    let catBullets = document.getElementById("catBullets");
    let response = await fetch(`http://ec2-3-16-56-22.us-east-2.compute.amazonaws.com:7070/expense-categories`);
    let info = await response.json();

    for (let index = 0; index < info.length; index++) {
        const element = info[index];
        

        catBullets.innerHTML += `
            <div class="form-check">
                <label class="form-check-label" for="${element.cid}">
                <input type="radio" class="form-check-input" id="${element.cid}" name="optradio" value="${element.title}" checked>${element.title}
            </div> 
        `;
    }

}

async function uploadNewReimbursement()
{
    // let catBullets = document.getElementById("catBullets");
    let employee_note = document.getElementById("rComment").value;
    let rAmount = document.getElementById("amount").value;
    var myHeaders = new Headers();
    myHeaders.append("Content-Type", "application/json");

    let categoryRadio = document.forms[0];
    let selection;
    for (let index = 0; index < categoryRadio.length; index++) {
        const element = categoryRadio[index];

        if( element.checked)
        {
            selection = element.id;
        }
        
    }

    console.log(selection);

    var raw = JSON.stringify({"rid":0,
    "amount":rAmount,
    "submit_date":"2020-01-02",
    "status":0,
    "status_date":"2000-01-01",
    "employee_note": `${employee_note}`,
    "manager_note":"",
    "cid":selection,
    "eid": JSON.parse(localStorage.getItem("data"))[0].eid
});

    var requestOptions = {
    method: 'PUT',
    headers: myHeaders,
    body: raw,
    redirect: 'follow'
    };

    let response = await fetch("http://ec2-3-16-56-22.us-east-2.compute.amazonaws.com:7070/reimbursement", requestOptions)
    
    location.reload();

}