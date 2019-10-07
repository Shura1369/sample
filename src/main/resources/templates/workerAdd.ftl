
<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet"
          type="text/css" href="<@spring.url '/css/style.css'/>"/>
</head>
<body>

<div>
    <fieldset>
        <legend>Add student</legend>
        <form name="student" action="" method="POST">
            First name      :<@spring.formInput "workerForm.name" "" "text"/>
            <br> Occupation :<@spring.formInput "workerForm.occupation" "" "text"/>
            <br> Salary     :<@spring.formInput "workerForm.salary" "" "text"/>
            <br>

            <br>
            <input type="submit" value="Create"/>
        </form>
    </fieldset>
</div>

</body>
</html>
