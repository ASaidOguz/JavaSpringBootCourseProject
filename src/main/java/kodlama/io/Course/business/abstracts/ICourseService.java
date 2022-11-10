package kodlama.io.Course.business.abstracts;

import kodlama.io.Course.business.Requests.CourseRequest;
import kodlama.io.Course.business.Responses.CourseResponse;
import kodlama.io.Course.entities.concretes.Language;

import java.util.List;

public interface ICourseService {
    List<CourseResponse> getAll();
    public CourseResponse getResponsebyId(int id);
    void add(CourseRequest courseRequest) throws Exception;
    void delete(int id);
    void update(CourseRequest courseRequest,int id) throws Exception;
    public Language getbyId(int id);

}
