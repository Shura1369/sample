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
        <h3>Worker list</h3>
        <table class="table table-striped table-sm">
            <thead class="thead-dark">
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>occupation</th>
                    <th>salary</th>
                    <th>delete</th>
                    <th>update</th>
                </tr>
            </thead>
            <tbody>
                <#list workers as worker>
                    <tr>
                        <td>${worker.id}</td>
                        <td>${worker.name}</td>
                        <td>${worker.occupation}</td>
                        <td>${worker.salary}</td>
                        <td>  <a href="/worker/delete/${worker.id}" type="button" class="btn btn-danger">Delete</a></td>
                        <td>  <a href="/worker/update/${worker.id}" type="button" class="btn btn-primary">Update</a></td>
                    </tr>
                </#list>
            </tbody>
        </table>
        <a href="/worker/create" type="button" class="btn btn-success">Add new worker</a>
    </div>



</body>
</html>