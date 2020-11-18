<#import "parts/common.ftl" as c>
<#import "parts/messageEdit.ftl" as e/>

<@c.page>
    <#if isCurrentUser>
        <@e.editor "Save Changes" true />
    </#if>

    <#include "parts/messageList.ftl" />
</@c.page>