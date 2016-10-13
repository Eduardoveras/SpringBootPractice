<#include "/header.ftl">

<body>
<div class="loader"></div>
<div class="demo-layout mdl-layout mdl-js-layout mdl-layout--fixed-drawer mdl-layout--fixed-header">

<#include "/navbar.ftl">
<#include "/sidebar.ftl">


    <main class="mdl-layout__content mdl-color--grey-100">

        <div style="height: 600px; width: 800px;">
            <div class="demo-card-wide mdl-card mdl-shadow--2dp" style="display: block; width: 600px;">
                <table>
                    <tr>
                        <th>Equipment Legend (Total: ${totalE})</th>
                    </tr>
                    <tr>
                        <th>Key</th>
                        <th>Name</th>
                        <th>SubFamily</th>
                        <th>Quantity</th>
                    </tr>
                <#list equipments?sort_by("equipmentName") as equipment>
                    <tr>
                        <td>${equipment.getEquipmentId()}</td>
                        <td>${equipment.getEquipmentName()}</td>
                        <td>${equipment.getSubFamily().getSubFamilyName()}</td>
                        <#if equipment.getStock() gt 0 >
                            <td>${equipment.getStock()}</td>
                        <#else>
                            <td>OUT OF STOCK</td>
                        </#if>
                    </tr>
                </#list>
                </table>
            </div>

            <div class="demo-card-wide mdl-card mdl-shadow--2dp" style="display: block; width: 600px">
                <table>
                    <tr>
                        <th>Clients</th>
                    </tr>
                    <tr>
                        <th>Id Number</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                    </tr>
                <#list clients?sort_by("lastName") as client>
                    <tr>
                        <td>${client.getIdentificationNumber()}</td>
                        <td>${client.getFirstName()}</td>
                        <td>${client.getLastName()}</td>
                    </tr>
                </#list>
                </table>
            </div>
        </div>

    </main>
</div>


</body>