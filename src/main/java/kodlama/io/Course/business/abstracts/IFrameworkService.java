package kodlama.io.Course.business.abstracts;

import kodlama.io.Course.entities.concretes.FrameWork;

import java.util.List;

public interface IFrameworkService {
    void add(FrameWork frameWork);
    void delete(int id);
    List<FrameWork> getAll();
}
