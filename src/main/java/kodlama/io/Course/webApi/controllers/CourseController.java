package kodlama.io.Course.webApi.controllers;


import kodlama.io.Course.business.abstracts.ICourseService;
import kodlama.io.Course.entities.concretes.Course;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    private ICourseService icourseService;

    public CourseController(ICourseService _icourseService){
        this.icourseService=_icourseService;
    }

    @PostMapping("add")
    public void add(Course course){
       this.icourseService.add(course);
    }
    @PostMapping("delete")
    public void delete(int id){
        this.icourseService.delete(id);
    }
    @PostMapping("update")
    public void update(Course course){
        this.icourseService.update(course);
    }

    @GetMapping("getall")
    public List<Course> getAll(){
      return this.icourseService.getAll();
    }

    @GetMapping("/getbyid")
    public Course getbyId(int id){
        return this.icourseService.getById(id);
    }

}
