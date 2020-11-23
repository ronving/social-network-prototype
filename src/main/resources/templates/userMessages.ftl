<#import "parts/common.ftl" as c>
<#import "parts/messageEdit.ftl" as e/>

<@c.page>

    <h3>${userChannel.username}</h3>
    <#if !isCurrentUser>
        <#if isSubscriber>
            <a class="btn btn-dark" href="/user/unsubscribe/${userChannel.id}">Unsubscribe</a>
        <#else>
            <a class="btn btn-dark" href="/user/subscribe/${userChannel.id}">Subscribe</a>
        </#if>
    </#if>

    <div class="container my-3">
        <div class="row">
            <div class="col">
                <div class="card">
                    <div class="card-body">
                        <div class="card-title">Subscriptions</div>
                        <a href="/user/subscriptions/${userChannel.id}/list"><h3 class="card-text">${subscriptions}</h3></a>
                    </div>
                </div>
            </div>
            <div class="col">
                <div class="card">
                    <div class="card-body">
                        <div class="card-title">Subscribers</div>
                        <a href="/user/subscribers/${userChannel.id}/list"><h3 class="card-text">${subscribers}</h3></a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <#if isCurrentUser>
        <@e.editor "Save Changes" true />
    </#if>

    <#include "parts/messageList.ftl" />
</@c.page>