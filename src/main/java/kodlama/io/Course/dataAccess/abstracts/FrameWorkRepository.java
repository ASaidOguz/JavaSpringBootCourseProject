package kodlama.io.Course.dataAccess.abstracts;

import kodlama.io.Course.entities.concretes.FrameWork;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface FrameWorkRepository extends JpaRepository<FrameWork,Integer> {

}
