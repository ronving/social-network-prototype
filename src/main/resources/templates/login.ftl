<#import "parts/common.ftl" as c>
<#import "parts/auth.ftl" as a>

<@c.page>
    <#if message??>
        <div class="alert alert-info" role="alert">
            ${message}
        </div>
    </#if>
    <#if error??>
        <div class="alert alert-danger" role="alert">
            ${error}
        </div>
    </#if>
    <#if Session?? && Session.SPRING_SECURITY_LAST_EXCEPTION??>
        <div class="alert alert-danger">
            ${Session.SPRING_SECURITY_LAST_EXCEPTION.message}
        </div>
    </#if>
    <@a.auth "/login" false/>
</@c.page>