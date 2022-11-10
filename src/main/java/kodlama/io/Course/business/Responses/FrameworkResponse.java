package kodlama.io.Course.business.Responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FrameworkResponse {
    private int id;
    private int courseId;
    private String coursename;
    private String name;
}
