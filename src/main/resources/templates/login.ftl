<#import "parts/common.ftl" as c>
<#import "parts/auth.ftl" as a>

<@c.page>
    Login page
    ${message?ifExists}
    <@a.auth "/login" false/>
</@c.page>