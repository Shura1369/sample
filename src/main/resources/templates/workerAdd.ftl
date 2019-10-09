
<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet"
          type="text/css" href="<@spring.url '/css/style.css'/>"/>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>

<div class="container">
    <fieldset>
        <legend>Add student</legend>
        <form name="worker" action="" method="POST">
            First name      :<@spring.formInput "workerForm.name" 'class ="form-control"' "text"/>
            <br> Occupation :<@spring.formInput "workerForm.occupation" 'class ="form-control"' "text"/>
            <br> Salary     :<@spring.formInput "workerForm.salary" 'class ="form-control"' "text"/>
            <br> Speciality :<@spring.formSingleSelect "workerForm.speciality" ,mavs,'class ="form-control"'/>
            <br>

            <br>
            <input type="submit" value="Create"/>
        </form>
    </fieldset>
</div>

</body>
</html>
