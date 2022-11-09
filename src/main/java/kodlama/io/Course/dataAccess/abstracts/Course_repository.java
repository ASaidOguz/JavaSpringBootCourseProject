package kodlama.io.Course.dataAccess.abstracts;

import kodlama.io.Course.entities.concretes.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface Course_repository extends JpaRepository<Course, Integer> {
    @Modifying
    @Query(value = "UPDATE ProgrammingLanguage pl set pl.name = ?1 where pl.id = ?2", nativeQuery = true)
    void update(String newName, int id);

    Course findById(int id);
}
