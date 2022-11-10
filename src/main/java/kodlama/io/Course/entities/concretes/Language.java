package kodlama.io.Course.entities.concretes;

import lombok.*;

import javax.persistence.*;
import java.util.Set;


@Table(name="courses")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Language {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name="name")
    private String languagename;
    
    @OneToMany(mappedBy= "language")
    Set<FrameWork> technologies;



    //orphanRemoval = true
    //It helps us remove child entity (SubCourses)
    // from database if we remove it from the parent’s collection (SubCourse field).
}
