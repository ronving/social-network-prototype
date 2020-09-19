<#import "parts/common.ftl" as c>
<#import "parts/auth.ftl" as a>

<@c.page>
Add new user ${message}
<@a.auth "/registration"/>
</@c.page>
