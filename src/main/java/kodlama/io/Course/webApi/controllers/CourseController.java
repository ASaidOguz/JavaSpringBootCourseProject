package kodlama.io.Course.webApi.controllers;


import kodlama.io.Course.business.Requests.CourseRequest;
import kodlama.io.Course.business.Responses.CourseResponse;
import kodlama.io.Course.business.abstracts.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    private ICourseService iCourseService;
    @Autowired
    public CourseController(ICourseService iCourseService){
        this.iCourseService=iCourseService;
    }

    @GetMapping("/getall")
    public List<CourseResponse> getall(){
        return iCourseService.getAll();
    }

    @GetMapping("/getbyid/{id}")
    public CourseResponse getById(@PathVariable int id){
         return iCourseService.getResponsebyId(id);
    }

    @PostMapping("/add")
    public void add(@RequestBody CourseRequest courseRequest) throws Exception{
        iCourseService.add(courseRequest);
    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable int id){
        iCourseService.delete(id);
    }

    @PutMapping("update/{id}")
    public void update(@RequestBody CourseRequest courseRequest,int id)throws Exception{
        iCourseService.update(courseRequest,id);
    }

}
