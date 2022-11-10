package kodlama.io.Course.business.concretes;

import kodlama.io.Course.business.Requests.CourseRequest;
import kodlama.io.Course.business.Responses.CourseResponse;
import kodlama.io.Course.business.abstracts.ICourseService;
import kodlama.io.Course.dataAccess.abstracts.ICourserepository;
import kodlama.io.Course.entities.concretes.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CourseManager implements ICourseService {

     ICourserepository ICourserepository;


    public CourseManager(ICourserepository ICourserepository)
    {
        this.ICourserepository = ICourserepository;
    }

    @Override
    public List<CourseResponse> getAll() {
        List<Language> cours = ICourserepository.findAll();
       List<CourseResponse> courseResponses= new ArrayList<CourseResponse>();

       for(Language language : cours){
           CourseResponse responseitem=new CourseResponse();
           responseitem.setId(language.getId());
           responseitem.setName((language.getLanguagename()));
           courseResponses.add(responseitem);
       }
       return courseResponses;
    }

    @Override
    public CourseResponse getResponsebyId(int id) {
        Language language = ICourserepository.findById(id);
        CourseResponse courseResponse=new CourseResponse();
        courseResponse.setName(language.getLanguagename());
        courseResponse.setId(id);

        return courseResponse;
    }

    @Override
    public void add(CourseRequest courseRequest) throws Exception {
       IsValid(courseRequest.getName());
        Language language =new Language();
       language.setLanguagename(courseRequest.getName());

       ICourserepository.save(language);
    }

    @Override
    public void delete(int id) {
      ICourserepository.deleteById(id);
    }

    @Override
    public void update(CourseRequest courseRequest, int id) throws Exception {
        IsValid(courseRequest.getName());
        Language language = ICourserepository.findById(id);
        language.setLanguagename((courseRequest.getName()));

        ICourserepository.save(language);
    }
    private void IsValid(String name) throws Exception {
        Language isExist= ICourserepository.findBylanguagename(name);
        if (isExist!=null){
            throw new Exception("Bu isim zaten Var!!!");
        }
        if(name.isBlank()){
            throw new Exception(("İsim boş geçilemez"));
        }
    }
    @Override
    public Language getbyId(int id) {
       return ICourserepository.findById(id);
    }
}
