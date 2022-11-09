package kodlama.io.Course.webApi.controllers;

import kodlama.io.Course.business.abstracts.IFrameworkService;
import kodlama.io.Course.entities.concretes.FrameWork;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/frameworks")
public class FrameworkController {
    private IFrameworkService iframeworkservice;

    @Autowired
    public FrameworkController(IFrameworkService _iframeservice){
        this.iframeworkservice=_iframeservice;
    }

    @GetMapping("getall")
    public List<FrameWork> getAll(){
        return this.iframeworkservice.getAll();
    }

    @PostMapping("add")
    public void add(@RequestBody FrameWork framework){
        this.iframeworkservice.add(framework);
    }

    @PostMapping("delete")
    public void delete(@RequestParam int id){
        this.iframeworkservice.delete(id);
    }
}
