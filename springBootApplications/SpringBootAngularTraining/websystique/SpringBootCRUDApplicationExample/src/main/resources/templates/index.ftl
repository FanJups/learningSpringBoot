<#import "spring.ftl" as spring />

<!DOCTYPE html>

 
<html lang="en" ng-app="crudApp">
    <head>

        <#if title??>
            <title>${title}</title>
        </#if>
        
        
        <link rel="stylesheet" type="text/css" href="<@spring.url '/css/bootstrap.css'/>"/>
        <link rel="stylesheet" type="text/css" href="<@spring.url '/css/app.css'/>"/>
    
    </head>
    <body>
 
        <div ui-view></div>
        <script src="<@spring.url '/js/lib/angular.min.js'/>"></script>
        <script src="<@spring.url '/js/lib/angular-ui-router.min.js'/>"></script>
        <script src="<@spring.url '/js/lib/localforage.min.js'/>"></script>
        <script src="<@spring.url '/js/lib/ngStorage.min.js'/>"></script>
        <script src="<@spring.url '/js/app/app.js'/>"></script>
        <script src="<@spring.url '/js/app/UserService.js'/>"></script>
        <script src="<@spring.url '/js/app/UserController.js'/>"></script>
        
       
        
    </body>
</html>