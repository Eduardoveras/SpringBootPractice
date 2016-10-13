<#include "/header.ftl">

<body>
<div class="loader"></div>
<div class="demo-layout mdl-layout mdl-js-layout mdl-layout--fixed-drawer mdl-layout--fixed-header">

<#include "/navbar.ftl">
<#include "/sidebar.ftl">


    <main class="mdl-layout__content mdl-color--grey-100">


        <!--LOGIN BOX-->
        <div class="mdl-grid demo-content" style="display: inline-block; width: 500px; margin: auto;">
            <div class="mdl-cell mdl-cell--4-col">
                <div class="demo-card-wide mdl-card mdl-shadow--2dp">
                    <form action="/addNewEquipment" METHOD="POST" >
                        <div class="mdl-card__title">
                            <h2 class="mdl-card__title-text">Register Equipment #${inventory}</h2>
                        </div>
                        <div class="mdl-card__supporting-text">
                            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                <input class="mdl-textfield__input" type="text" id="name" name="name">
                                <label class="mdl-textfield__label" >Name</label>
                            </div>
                        </div>
                        <div class="mdl-card__supporting-text">
                            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                <input class="mdl-textfield__input" type="text" id="subfamily" name="subfamily">
                                <label class="mdl-textfield__label" >Sub-Family</label>
                            </div>
                        </div>
                        <div class="mdl-card__supporting-text">
                            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                <input class="mdl-textfield__input" type="number" id="stock" name="stock">
                                <label class="mdl-textfield__label" >Stock</label>
                            </div>
                        </div>


                        <div class="mdl-card__actions mdl-card--border">
                            <input class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent" type="submit" value="Register">
                        </div>

                    </form>
                </div>
            </div>



            <table class="mdl-data-table mdl-js-data-table mdl-data-table--selectable mdl-shadow--2dp" style="width: 600px; margin: 8px">
                <h3>Sub-Families</h3>
                <tr>
                    <th>Key</th>
                    <th>Name</th>
                    <th>SubFamily</th>
                    <th>Family</th>
                    <th>Quantity</th>
                </tr>
            <#list equipments?sort_by("equipmentId") as equipment>
                <tr>
                    <td>${equipment.getEquipmentId()}</td>
                    <td>${equipment.getEquipmentName()}</td>
                    <td>${equipment.getSubFamily().getSubFamilyName()}</td>
                    <td>${equipment.getSubFamily().getFamily().getFamilyName()}</td>
                    <td>${equipment.getStock()}</td>
                </tr>
            </#list>
            </table></div>



            <table class="mdl-data-table mdl-js-data-table mdl-data-table--selectable mdl-shadow--2dp" style="width: 600px; margin: 8px">
                <h3>Sub-Families</h3>
                <tr>
                    <th>Key</th>
                    <th>Name</th>
                    <th>Family</th>
                </tr>
            <#list subfamilies?sort_by("family") as subfamily>
                <tr>
                    <td>${subfamily.getSubFamilyKey()}</td>
                    <td>${subfamily.getSubFamilyName()}</td>
                    <td>${subfamily.getFamily().getFamilyName()}</td>
                </tr>
            </#list>
            </table>

    </div>

        <!--END LOGIN BOX-->


    </main>
</div>


</body>