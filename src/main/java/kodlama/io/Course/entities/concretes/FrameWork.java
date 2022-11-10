package kodlama.io.Course.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;


@Table(name="frameworks")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class FrameWork {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;


    @ManyToOne
    @JoinColumn(name = "course_id")
    @JsonIgnore
    private Language language;

}
