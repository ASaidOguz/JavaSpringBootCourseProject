package kodlama.io.Course.business.abstracts;

import kodlama.io.Course.entities.concretes.Course;

import java.util.List;

public interface ICourseService {
    void add(Course course);
    void delete(int id);
    void update(Course course);

    List<Course> getAll();
    Course getById(int id);
}
