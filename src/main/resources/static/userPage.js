$(async function() {
    await thisUser();
});
async function thisUser() {
    fetch("http://localhost:8080/api/user")
        .then(res => res.json())
        .then(data => {
            $('#headerUsername').append(data.username);
            let roles = data.roles.map(role => role.name.substring(5).concat(" ")).toString().replaceAll(",", "");
            $('#headerRoles').append(roles);

            let user = `$(
            <tr>
                <td>${data.id}</td>
                <td>${data.username}</td>
                <td>${data.firstName}</td>
                <td>${data.lastName}</td>
                <td>${data.phoneNumber}</td>
                <td>${roles}</td>)`;
            $('#userPanelBody').append(user);
        })
}