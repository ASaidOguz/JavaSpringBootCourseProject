package kodlama.io.Course.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Table(name="frameworks")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class FrameWork {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="frameworks_name")
    private String FrameWorkName;


    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course ;

}
