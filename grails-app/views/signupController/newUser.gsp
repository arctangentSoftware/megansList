<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'signupController.label', default: 'SignupController')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#list-signupController" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>

        <!--TODO: Set these reviewer/property manager create options side by side using grid of flex-->
        <!--CREATE REVIEWER-->
        <div id="create-reviewer" class="content scaffold-create" role="main">
            <h1><g:message code="default.create.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${this.reviewer}">
                <ul class="errors" role="alert">
                    <g:eachError bean="${this.reviewer}" var="error">
                        <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                    </g:eachError>
                </ul>
            </g:hasErrors>
            <g:form resource="${this.reviewer}" method="POST">
                <fieldset class="form">
                    <f:all bean="reviewer"/>
                </fieldset>
                <fieldset class="buttons">
                    <g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" />
                </fieldset>
            </g:form>
        </div>

        <!--CREATE PROPERTY MANAGER-->
        <div id="create-propertyManager" class="content scaffold-create" role="main">
            <h1><g:message code="default.create.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${this.propertyManager}">
                <ul class="errors" role="alert">
                    <g:eachError bean="${this.propertyManager}" var="error">
                        <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                    </g:eachError>
                </ul>
            </g:hasErrors>
            <g:form resource="${this.propertyManager}" method="POST">
                <fieldset class="form">
                    <f:all bean="propertyManager"/>
                </fieldset>
                <fieldset class="buttons">
                    <g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" />
                </fieldset>
            </g:form>
        </div>

        <div id="login-link">
            <!--TODO: add a message to i18n message resource bundle for the first sentence and a link to 'Log in.'-->
            <h2>Aleady singed up? <a href="#" class="link">Log in.</a></h2>
        </div>
    </body>
</html>