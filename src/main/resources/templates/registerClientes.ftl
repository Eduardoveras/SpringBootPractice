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
                    <form action="#" METHOD="POST">
                        <div class="mdl-card__title">
                            <h2 class="mdl-card__title-text">Add Client </h2>
                        </div>
                        <div class="mdl-card__supporting-text">
                            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                <input class="mdl-textfield__input" type="text" id="cedula" name="cedula">
                                <label class="mdl-textfield__label">Cedula</label>
                            </div>
                        </div>
                        <div class="mdl-card__supporting-text">
                            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                <input class="mdl-textfield__input" type="text" id="firstname" name="firstname">
                                <label class="mdl-textfield__label">First Name</label>
                            </div>
                        </div>
                        <div class="mdl-card__supporting-text">
                            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                <input class="mdl-textfield__input" type="text" id="lastname" name="lastname">
                                <label class="mdl-textfield__label">Last Name</label>
                            </div>
                        </div>
                        <div class="mdl-card__supporting-text">
                            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                <input class="mdl-textfield__input" type="text" id="telephone" name="telephone">
                                <label class="mdl-textfield__label">Telephone.</label>
                            </div>
                        </div>
                        <div class="mdl-card__supporting-text">
                            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                <input class="mdl-textfield__input" type="text" id="adress" name="adress">
                                <label class="mdl-textfield__label">Adress.</label>
                            </div>
                        </div>
                        <div class="mdl-card__actions mdl-card--border">
                            <input class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent"
                                   type="submit" value="Register">
                        </div>

                    </form>
                </div>
                <div class="demo-card-wide mdl-card mdl-shadow--2dp" >
                    <ul class="demo-list-two mdl-list">
                        <li class="mdl-list__item mdl-list__item--two-line">
                    <span class="mdl-list__item-primary-content">
                      <i class="material-icons mdl-list__item-avatar">person</i>
                      <span>Bryan Cranston</span>
                      <span class="mdl-list__item-sub-title">62 Episodes</span>
                    </span>
                                            <span class="mdl-list__item-secondary-content">
                      <span class="mdl-list__item-secondary-info">Actor</span>
                                                <a class="mdl-list__item-secondary-action" href="#"><i
                                                        class="material-icons">star</i></a>
                    </span>
                                        </li>
                                        <li class="mdl-list__item mdl-list__item--two-line">
                    <span class="mdl-list__item-primary-content">
                      <i class="material-icons mdl-list__item-avatar">person</i>
                      <span>Aaron Paul</span>
                      <span class="mdl-list__item-sub-title">62 Episodes</span>
                    </span>
                                            <span class="mdl-list__item-secondary-content">
                      <a class="mdl-list__item-secondary-action" href="#"><i class="material-icons">star</i></a>
                    </span>
                                        </li>
                                        <li class="mdl-list__item mdl-list__item--two-line">
                    <span class="mdl-list__item-primary-content">
                      <i class="material-icons mdl-list__item-avatar">person</i>
                      <span>Bob Odenkirk</span>
                      <span class="mdl-list__item-sub-title">62 Episodes</span>
                    </span>
                                            <span class="mdl-list__item-secondary-content">
                      <a class="mdl-list__item-secondary-action" href="#"><i class="material-icons">star</i></a>
                    </span>
                        </li>
                    </ul>

                </div>
            </div>
        </div>
        <!--END LOGIN BOX-->


    </main>
</div>


</body>