<#include "security.ftl">
<#import "auth.ftl" as a>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/">VTCSN</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="/">Home</a>
            </li>
            <#if user??>
            <li class="nav-item">
                <a class="nav-link" href="/main">Messages</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/user-messages/${currentUserId}">My posts</a>
            </li>
            </#if>
            <#if isAdmin>
                <li class="nav-item">
                    <a class="nav-link" href="/user">Users</a>
                </li>
            </#if>
            <#if user??>
                <li class="nav-item">
                    <a class="nav-link" href="/user/profile">Profile</a>
                </li>
            </#if>
        </ul>

        <div class="navbar-text mr-3">${name}</div>
        <@a.logout/>
    </div>
</nav>