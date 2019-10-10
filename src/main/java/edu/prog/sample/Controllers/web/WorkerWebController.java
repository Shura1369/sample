package edu.prog.sample.Controllers.web;

import edu.prog.sample.Model.Speciality;
import edu.prog.sample.Model.Worker;
import edu.prog.sample.Services.Speciality.impls.SpecialityServiceImpls;
import edu.prog.sample.Services.worker.impls.WorkerServiceImpl;
import edu.prog.sample.forms.WorkerForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import sun.util.resources.LocaleData;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequestMapping("/worker")
@CrossOrigin("*")
@Controller
public class WorkerWebController {
    @Autowired
    WorkerServiceImpl service;

    @Autowired
    SpecialityServiceImpls specialityService;


    @RequestMapping("/list")
    String showAll(Model model)
    {
        List<Worker> list = service.getAll();
        model.addAttribute("workers", list);
        return "workerList";
    }

    @RequestMapping("/delete/{id}")
    RedirectView delete(@PathVariable(value = "id") String id)
    {
        service.delete(id);
        return new RedirectView ("/worker/list");
    }

    @RequestMapping("/get/{id}")
    Worker get(@PathVariable (value = "id") String id)
    {return service.get(id);}

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String addWorker(Model model){
        WorkerForm workerForm = new WorkerForm();
        Map<String, String> mavs = specialityService.getAll().stream()
                .collect(Collectors.toMap(Speciality::getId, Speciality::getName));

        model.addAttribute("mavs", mavs);


        model.addAttribute("workerForm", workerForm);
        return "workerAdd";
    }
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    String create(Model model, @ModelAttribute("workerForm") WorkerForm workerForm)
    {
        /*String specialityId = workerForm.getSpeciality();
        Speciality speciality = */
        Worker newWorker = new Worker(workerForm.getName(), workerForm.getOccupation(),
                workerForm.getSalary(), specialityService.get(workerForm.getSpeciality()),
                LocalDate.parse(workerForm.getEmploymentDate(),DateTimeFormatter.ofPattern("MM/dd/yyyy")));
        service.create(newWorker);
        return "redirect:/worker/list";
    }


    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String updateWorker(Model model,@PathVariable("id") String id){
        Worker workerToUpdate = service.get(id);
        WorkerForm workerForm = new WorkerForm();
        workerForm.setName(workerToUpdate.getName());
        workerForm.setId(id);
        workerForm.setOccupation(workerToUpdate.getOccupation());
        workerForm.setSalary(workerToUpdate.getSalary());
        workerForm.setSpeciality(workerToUpdate.getSpeciality().getName());
        String data = workerToUpdate.getEmploymentDate().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")).toString();
                workerForm.setEmploymentDate(data);

        Map<String, String> mavs = specialityService.getAll().stream()
                .collect(Collectors.toMap(Speciality::getId, Speciality::getName));

        model.addAttribute("workerForm", workerForm);
        model.addAttribute("mavs", mavs);

        return "workerUpdate";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    String update(Model model, @ModelAttribute("workerForm") WorkerForm workerForm,
                  @PathVariable("id") String id)
    {
        Worker newWorker = new Worker(
                workerForm.getName(),
                workerForm.getOccupation(),
                workerForm.getSalary(),specialityService.get(workerForm.getSpeciality()),
                LocalDate.parse(workerForm.getEmploymentDate(), DateTimeFormatter.ofPattern("MM/dd/yyyy")));
        newWorker.setId(id);
        service.update(newWorker);
        return "redirect:/worker/list";
    }

    /*@PostMapping("/update")
    Worker update(@Valid @RequestBody Worker worker)
    {return service.update(worker);}*/
}
