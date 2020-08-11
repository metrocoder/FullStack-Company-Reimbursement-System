// Table row template
/* <tr>
    <td class="text-center">CATEGORY</td>
    <td class="text-center">Employee Notes</td>
    <td class="text-center">Amount</td>
    <td class="text-center">  
    <!-- Button to Open the Modal -->
    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">
        Open modal
    </button>
</td>
</tr> */
var employeeId;
var reimbursementId;
async function populateManagerTable()
{
    let tableBody = document.getElementById("tableBody");

    let response = await fetch(`http://ec2-3-16-56-22.us-east-2.compute.amazonaws.com:7070/reimbursements?managerId=${JSON.parse(localStorage.getItem("data"))[0].mgid}`);
    let info = await response.json();

    for (let index = 0; index < info.length; index++) {
        const element = info[index];
        
        let cData = await fetchCategoryData(element.cid);
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
    employeeId = eid;
    let eData = await fetchEmployeeData(eid);
    let modalCard = document.getElementById("modalCard");

    modalCard.innerHTML =`
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
    reimbursementId = rid;
    let modalAmount = document.getElementById("modalAmount");
    let modalCategory = document.getElementById("modalCategory");
    let modalNotes = document.getElementById("modalNotes");
    let thumbsUp = document.getElementById("thumbsUp");
    let thumbsDown = document.getElementById("thumbsDown");
    let modalComment = document.getElementById("modalCommentManager");

    let rData = await fetchReimbursementById(rid);
    let cData = await fetchCategoryData(rData.cid);
    // let cElement = cData[0];

    modalAmount.innerHTML = `$ ${rData.amount}`;
    modalCategory.innerHTML = `${cData.title}`;
    modalNotes.innerHTML = `${rData.employee_note}`;
    modalComment.textContent = `${rData.manager_note}`;

    if(rData.status === 0)
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
     
async function statusUpdate(status)
{
    let managerNote = document.getElementById("modalCommentManager").value;
    let myHeaders = new Headers();
    myHeaders.append("Content-Type", "application/json");

    let rData = await fetchReimbursementById(reimbursementId);
    rData.manager_note = managerNote;
    if (status === "approved")
        rData.status = 1;
    else
        rData.status = 0;
    let raw = JSON.stringify(rData);

    let requestOptions = 
    {
        method: 'POST',
        headers: myHeaders,
        body: raw,
        redirect: 'follow'
    };

    await fetch("http://ec2-3-16-56-22.us-east-2.compute.amazonaws.com:7070/reimbursement", requestOptions)

    location.reload();
}
       
function cleanTable()
{
    let tableBody = document.getElementById("tableBody");

    tableBody.innerHTML = "";
}