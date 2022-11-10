package kodlama.io.Course.webApi.controllers;

import kodlama.io.Course.business.Requests.FrameworkRequest;
import kodlama.io.Course.business.Responses.FrameworkResponse;
import kodlama.io.Course.business.abstracts.IFrameworkService;
import kodlama.io.Course.entities.concretes.FrameWork;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/frameworks")
public class FrameworkController {
   private IFrameworkService iFrameworkService;

   public FrameworkController(IFrameworkService iFrameworkService){
       this.iFrameworkService=iFrameworkService;
   }
   @GetMapping("/getall")
    public List<FrameworkResponse>getAll(){
       return iFrameworkService.getall();
   }

   @GetMapping("/getbyid/{id}")
    public FrameworkResponse getById(@PathVariable int id){
       return iFrameworkService.getResponsebyId(id);
   }
   @PostMapping("/add")
    public void add(@RequestBody FrameworkRequest frameworkRequest){
       iFrameworkService.add(frameworkRequest);
   }
   @PutMapping("/update/{id}")
   public void update(@RequestBody FrameworkRequest frameworkRequest ,@RequestParam int id){
        iFrameworkService.update(frameworkRequest,id);
   }
   @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id ){
       iFrameworkService.delete(id);
   }

}
