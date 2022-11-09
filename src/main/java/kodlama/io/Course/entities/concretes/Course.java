package kodlama.io.Course.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Table(name="courses")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "frameworks"})
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="course_name")
    private String CourseName;

    @Column(name="description")
    private String Description;

    @OneToMany(mappedBy ="course",cascade = CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval = true)
    private List<FrameWork> frameworks;

    public Course(String _coursename,String _description){
         this.CourseName=_coursename;
         this.Description=_description;
    }
    //orphanRemoval = true
    //It helps us remove child entity (SubCourses)
    // from database if we remove it from the parent’s collection (SubCourse field).
}
