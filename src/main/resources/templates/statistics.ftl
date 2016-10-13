<#include "/header.ftl">

<body>
<div class="loader"></div>
<div class="demo-layout mdl-layout mdl-js-layout mdl-layout--fixed-drawer mdl-layout--fixed-header">

<#include "/navbar.ftl">
<#include "/sidebar.ftl">


    <main class="mdl-layout__content mdl-color--grey-100">
        <div class="mdl-grid demo-content">

            <div class="demo-card-wide mdl-card mdl-shadow--2dp" style="display: inline-block; width: 800px">
                <table>
                    <tr>
                        <th>#{totalR} Rents</th>
                    </tr>
                    <tr>
                        <th>Rent Id</th>
                        <th>Equipment</th>
                        <th>Start Date</th>
                        <th>Promised Date</th>
                        <th>Borrower</th>
                        <th>Status</th>
                    </tr>
                <#list rents?sort_by("promisedDate") as rent>
                    <tr>
                        <th>${rent.getRentId()}</th>
                        <td>${rent.getEquipment().getEquipmentName()}</td>
                        <td>${rent.getStartDate()}</td>
                        <td>${rent.getPromisedDate()}</td>
                        <td>${rent.getBorrower().getFirstName()} ${rent.getBorrower().getLastName()}</td>
                        <#if rent.isActive()>
                            <td>OUT</td>
                        <#else>
                            <td>RETURNED</td>
                        </#if>
                    </tr>
                </#list>
                </table>
            </div>

            <div class="demo-card-wide mdl-card mdl-shadow--2dp" style="display: inline-block; width: 800px">
                <table>
                    <tr>
                        <th>#{totalT} Transactions</th>
                    </tr>
                    <tr>
                        <th>Transaction Id</th>
                        <th>Date</th>
                        <th>Total Price</th>
                        <th>Borrower Id</th>
                        <th>Borrower Name</th>
                        <th>Equipment Id</th>
                        <th>Equipment Name</th>
                    </tr>
                <#list receipts?sort_by("startDate") as receipt>
                    <tr>
                        <th>${receipt.getTransactionId()}</th>
                        <td>${receipt.getTransactionDate()}</td>
                        <td>${receipt.getTotalPrice()}</td>
                        <td>${receipt.getBorrower().getIdentificationNumber()}</td>
                        <td>${receipt.getBorrower().getFirstName()} ${receipt.getBorrower().getLastName()}</td>
                        <td>${receipt.getEquipment().getEquipmentId()}</td>
                        <td>${receipt.getEquipment().getEquipmentName()}</td>
                    </tr>
                </#list>
                </table>
            </div>

        </div>
    </main>
</div>


</body>