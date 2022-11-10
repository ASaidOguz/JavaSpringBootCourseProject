package kodlama.io.Course.dataAccess.abstracts;

import kodlama.io.Course.entities.concretes.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



@Repository
public interface ICourserepository extends JpaRepository<Language, Integer> {

  Language findById(int id);
  Language findBylanguagename(String name);
}
