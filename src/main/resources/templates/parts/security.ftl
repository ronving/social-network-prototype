<#assign
known = Session.SPRING_SECURITY_CONTEXT??
>
<#if known>
    <#assign
    user = Session.SPRING_SECURITY_CONTEXT.authentication.principal
    name = user.getUsername()
    isAdmin = user.getAuthorities()?seq_contains('ADMIN')
    currentUserId = user.getId()
    >
<#else>
    <#assign
    name = "unknown"
    isAdmin = false
    id = 0
    currentUserId = -1
    >
</#if>