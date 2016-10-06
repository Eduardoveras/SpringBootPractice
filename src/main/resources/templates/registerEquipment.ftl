<#include "/header.ftl">

<body>
<div class="loader"></div>
<div class="demo-layout mdl-layout mdl-js-layout mdl-layout--fixed-drawer mdl-layout--fixed-header">

<#include "/navbar.ftl">
<#include "/sidebar.ftl">


    <main class="mdl-layout__content mdl-color--grey-100">


        <!--LOGIN BOX-->
        <div class="mdl-grid demo-content">
            <div class="mdl-cell mdl-cell--4-col">
                <div class="demo-card-wide mdl-card mdl-shadow--2dp">
                    <form action="#" METHOD="POST" >
                        <div class="mdl-card__title">
                            <h2 class="mdl-card__title-text">Add Client /h2>
                        </div>
                        <div class="mdl-card__supporting-text">
                            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                <input class="mdl-textfield__input" type="text" id="name" name="name">
                                <label class="mdl-textfield__label" >Name</label>
                            </div>
                        </div>
                        <div class="mdl-card__supporting-text">
                            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                <input class="mdl-textfield__input" type="text" id="sub-family" name="sub-family">
                                <label class="mdl-textfield__label" >sub-Family</label>
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
        </div>
        <!--END LOGIN BOX-->


    </main>
</div>


</body>