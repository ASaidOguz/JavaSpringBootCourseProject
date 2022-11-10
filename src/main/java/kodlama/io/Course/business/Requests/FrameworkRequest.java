package kodlama.io.Course.business.Requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FrameworkRequest {
    private int CourseId;
    private String name;
}
