<#import "parts/common.ftl" as c>

<@c.page>
    <h3>${userChannel.username}</h3>
<div>${type}</div>
    <ul class="list-group">
    <#list subs as sub>
        <li class="list-group-item"><a href="/user-messages/${sub.id}">${sub.username}</a></li>
    </#list>
    </ul>
</@c.page>