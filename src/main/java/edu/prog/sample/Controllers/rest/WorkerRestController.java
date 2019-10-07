package edu.prog.sample.Controllers.rest;

import edu.prog.sample.Model.Worker;
import edu.prog.sample.Services.impls.WorkerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/api/worker")
@CrossOrigin("*")
@RestController
public class WorkerRestController {
    @Autowired
    WorkerServiceImpl service;



    @RequestMapping("/list")
    List<Worker> showAll()
    {return service.getAll();}

    @RequestMapping("/delete/{id}")
    Worker delete(@PathVariable (value = "id") String id)
    {return service.delete(id);}

    @RequestMapping("/get/{id}")
    Worker get(@PathVariable (value = "id") String id)
    {return service.get(id);}

    @PostMapping("/create")
    Worker create(@Valid @RequestBody Worker worker)
    {return service.create(worker);}

    @PostMapping("/update")
    Worker update(@Valid @RequestBody Worker worker)
    {return service.update(worker);}
}
