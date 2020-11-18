<#import "parts/common.ftl" as c>
<#import "parts/messageEdit.ftl" as e/>

<@c.page>
    <div class="form-row">
        <div class="form-group col-md-6">
            <form method="get" action="/main" class="form-inline">
                <input type="text" name="filter" class="form-control" value="${filter?ifExists}" placeholder="Search by tag">
                <button type="submit" class="btn btn-primary ml-2">Search</button>
            </form>
        </div>
    </div>


    <@e.editor "Create Message" false />
    <#include "parts/messageList.ftl" />
</@c.page>