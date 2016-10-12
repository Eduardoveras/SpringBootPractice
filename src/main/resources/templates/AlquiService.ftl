<#include "/header.ftl">

<body>
<div class="loader"></div>
<div class="demo-layout mdl-layout mdl-js-layout mdl-layout--fixed-drawer mdl-layout--fixed-header">

<#include "/navbar.ftl">
<#include "/sidebar.ftl">


    <main class="mdl-layout__content mdl-color--grey-100">

        <div class="demo-card-wide mdl-card mdl-shadow--2dp" style="display: inline-block; width: 600px; margin: auto;">
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


    </main>
</div>


</body>