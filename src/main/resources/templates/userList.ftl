<#import "parts/common.ftl" as c>

<@c.page>
    Users List
    <table>
        <thead>
        <tr>
            <th>Name</th>
            <th>Roles</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <#list users as user>
            <tr>
                <td>${user.username}</td>
                <td><#list user.roles as role>${role}<#sep>, </#list></td>
                <td><a href="/user/${user.id}">EDIT</a></td>
                <td><a href="/user/delete/${user.id}">DELETE</a></td>
        <#else>
            No users yet.
        </#list>
        </tbody>
    </table>
</@c.page>
