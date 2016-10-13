<#include "/header.ftl">

<body>
<div class="loader"></div>
<div class="demo-layout mdl-layout mdl-js-layout mdl-layout--fixed-drawer mdl-layout--fixed-header">

<#include "/navbar.ftl">
<#include "/sidebar.ftl">


    <main class="mdl-layout__content mdl-color--grey-100">
        <div class="mdl-grid demo-content">

                <table class="mdl-data-table mdl-js-data-table mdl-data-table--selectable mdl-shadow--2dp" style="width: 600px; margin: 8px;">
                    <tr>
                        <th>#{totalR} Active Rents</th>
                    </tr>
                    <tr>
                        <th>Rent Id</th>
                        <th>Equipment</th>
                        <th>Start Date</th>
                        <th>Promised Date</th>
                        <th>Borrower</th>
                        <th>Status</th>
                    </tr>
                <#list actives?sort_by("promisedDate") as rent>
                    <tr>
                        <th>${rent.getRentId()}</th>
                        <td>${rent.getEquipment().getEquipmentName()}</td>
                        <td>${rent.getStartDate()}</td>
                        <td>${rent.getPromisedDate()}</td>
                        <td>${rent.getBorrower().getFirstName()} ${rent.getBorrower().getLastName()}</td>
                        <#if rent.getPromisedDate() lt today>
                            <td>LATE</td>
                        <#else>
                            <td>OK</td>
                        </#if>
                    </tr>
                </#list>
                </table>

                <table class="mdl-data-table mdl-js-data-table mdl-data-table--selectable mdl-shadow--2dp" style="width: 600px; margin: 8px;">
                        <h3>#{totalR} Equipment Returns</h3>
                    <tr>
                        <th>Rent Id</th>
                        <th>Equipment</th>
                        <th>Start Date</th>
                        <th>Promised Date</th>
                        <th>Borrower</th>
                    </tr>
                <#list inactives?sort_by("startDate") as rent>
                    <tr>
                        <th>${rent.getRentId()}</th>
                        <td>${rent.getEquipment().getEquipmentName()}</td>
                        <td>${rent.getStartDate()}</td>
                        <td>${rent.getPromisedDate()}</td>
                        <td>${rent.getBorrower().getFirstName()} ${rent.getBorrower().getLastName()}</td>
                    </tr>
                </#list>
                </table>

        </div>
    </main>
</div>


</body>