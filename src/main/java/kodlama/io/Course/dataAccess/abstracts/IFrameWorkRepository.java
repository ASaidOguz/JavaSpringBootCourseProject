package kodlama.io.Course.dataAccess.abstracts;

import kodlama.io.Course.entities.concretes.FrameWork;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
public interface IFrameWorkRepository extends JpaRepository<FrameWork,Integer> {
    FrameWork findById(int id);

}
