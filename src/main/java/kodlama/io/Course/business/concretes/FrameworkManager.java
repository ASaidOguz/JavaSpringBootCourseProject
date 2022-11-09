package kodlama.io.Course.business.concretes;

import kodlama.io.Course.business.abstracts.IFrameworkService;
import kodlama.io.Course.dataAccess.abstracts.FrameWorkRepository;
import kodlama.io.Course.entities.concretes.FrameWork;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FrameworkManager implements IFrameworkService {

    private FrameWorkRepository frameworkRepository;



    @Autowired
    public FrameworkManager(FrameWorkRepository frameworkRepository) {
        this.frameworkRepository = frameworkRepository;
    }



    @Override
    public void add(FrameWork frameWork) {
        this.frameworkRepository.save(frameWork);
    }

    @Override
    public void delete(int id) {
        this.frameworkRepository.deleteById(id);
    }

    @Override
    public List<FrameWork> getAll() {
        return this.frameworkRepository.findAll();
    }
}
