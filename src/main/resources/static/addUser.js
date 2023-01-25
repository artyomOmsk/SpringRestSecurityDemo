$(async function () {
    await newUser();
});

async function newUser() {

    const selected_options = document.querySelector("#rolesName").selectedOptions;

    const form = document.forms["formNewUser"];

    form.addEventListener('submit', addNewUser)

    function addNewUser(e) {
        e.preventDefault();
        let listRoles = [];
        for (let i = 0; i < selected_options.length; i++) {
            listRoles.push(selected_options[i].value);
        }
        fetch("http://localhost:8080/api/add", {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                firstName: form.firstName.value,
                username: form.username.value,
                lastName: form.lastName.value,
                phoneNumber: form.phoneNumber.value,
                password: form.password.value,
                roles: listRoles
            })
        }).then(() => {
            form.reset();
            allUsers();
            $('#allUsersTable').click();
        })
    }
}

