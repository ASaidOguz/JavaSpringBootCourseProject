package kodlama.io.Course.business.concretes;

import kodlama.io.Course.business.abstracts.ICourseService;
import kodlama.io.Course.dataAccess.abstracts.Course_repository;
import kodlama.io.Course.entities.concretes.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CourseManager implements ICourseService {

   private Course_repository courserepository;

   @Autowired
   public CourseManager(Course_repository courserepository){
       this.courserepository=courserepository;
   }


    @Override
    public void add(Course course) {
        for(Course cs:this.getAll()){
            if(cs.getCourseName().equals(course.getCourseName())
                    ||
                    course.getCourseName().isEmpty()
                    ||
                    course.getCourseName().isBlank()){
                return;
            }
        }
        this.courserepository.save(course);
    }

    @Override
    public void delete(int id) {
      this.courserepository.deleteById(id);
    }

    @Override
    public void update(Course course) {
      int id=course.getId();
      String newname= course.getCourseName();
      this.courserepository.update(newname,id);
    }

    @Override
    public List<Course> getAll() {
        return this.courserepository.findAll();
    }

    @Override
    public Course getById(int id) {
        return this.courserepository.findById(id);
    }
}
