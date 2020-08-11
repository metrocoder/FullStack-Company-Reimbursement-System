function verifyUser()
{
    let classes = document.getElementById("form").className;

    if(classes.length > 1)
    {
        let email = document.getElementById("emailInput").value;
        let pass = document.getElementById("password").value;
        let emp = document.getElementById("employee").checked;
        let mgr = document.getElementById("manager").checked;

        // Store Role
        if (emp)
        {
            sessionStorage.setItem("role", "employees");
        }
        
        if (mgr)
        {
            sessionStorage.setItem("role", "managers");
        }

        // Session Store 
        storeEmail(email);
        storeShhh(pass);

        // Verify Credentials
        
        login();
        
    }
        

}

function checkStorageCapable()
{
    if (typeof(Storage) !== "undefined") 
    {
       
    } 
    else
    {
        showError();
    }
}

function showError()
{
    document.getElementById("alert").style = "display: visible;";
}

// Storage
function storeEmail(value1){
    sessionStorage.setItem('email', value1);
    
}

function storeShhh(value1){
    sessionStorage.setItem('shhh', value1);
}

async function login()
{

    document.getElementById("spinners").style.display = "visible;";
    let response = await fetch(`${document.URL}${sessionStorage.getItem("role")}?email=${sessionStorage.getItem("email")}`);
    let info = await response.json();
    localStorage.setItem("json", info);
    // document.cookie = info;
    let data = JSON.stringify(info);
    localStorage.setItem('data', data);
    document.cookie = data;
    document.getElementById("spinners").style.display = "none;";
    
    if (info[0].password === sessionStorage.getItem('shhh'))
    {
        window.location = `${document.URL}${sessionStorage.getItem("role")}.html`;
    }

    

    
}