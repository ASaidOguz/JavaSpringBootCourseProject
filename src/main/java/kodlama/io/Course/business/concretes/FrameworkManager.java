package kodlama.io.Course.business.concretes;

import kodlama.io.Course.business.Requests.FrameworkRequest;
import kodlama.io.Course.business.Responses.FrameworkResponse;
import kodlama.io.Course.business.abstracts.ICourseService;
import kodlama.io.Course.business.abstracts.IFrameworkService;
import kodlama.io.Course.dataAccess.abstracts.IFrameWorkRepository;
import kodlama.io.Course.entities.concretes.Language;
import kodlama.io.Course.entities.concretes.FrameWork;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class FrameworkManager implements IFrameworkService {

    IFrameWorkRepository IFrameWorkRepository;
    ICourseService iCourseService;
    @Autowired
    public FrameworkManager(IFrameWorkRepository IFrameWorkRepository, ICourseService iCourseService){
        this.IFrameWorkRepository = IFrameWorkRepository;
        this.iCourseService=iCourseService;
    }

    @Override
    public List<FrameworkResponse> getall() {
        List<FrameWork> frameWorks= IFrameWorkRepository.findAll();
        List<FrameworkResponse> frameworkResponses=new ArrayList<FrameworkResponse>();

        for(FrameWork frameWork:frameWorks){
            FrameworkResponse responseitem=new FrameworkResponse();
            responseitem.setId(frameWork.getId());
            responseitem.setName(frameWork.getName());
            responseitem.setCourseId(frameWork.getLanguage().getId());
            responseitem.setCoursename(frameWork.getLanguage().getLanguagename());

            frameworkResponses.add(responseitem);
        }
        return frameworkResponses;
    }

    @Override
    public FrameworkResponse getResponsebyId(int id) {
       FrameWork framework= IFrameWorkRepository.findById(id);
       FrameworkResponse frameworkResponse=new FrameworkResponse();
       frameworkResponse.setId(framework.getId());
       frameworkResponse.setName(framework.getName());
       frameworkResponse.setCoursename(framework.getLanguage().getLanguagename());

       return frameworkResponse;


    }

    @Override
    public void add(FrameworkRequest frameworkRequest) {
      FrameWork frameWork=new FrameWork();
      Language language =iCourseService.getbyId(frameworkRequest.getCourseId());
      frameWork.setName(frameworkRequest.getName());
      frameWork.setLanguage(language);
      IFrameWorkRepository.save(frameWork);
    }

    @Override
    public void update(FrameworkRequest frameworkRequest, int id) {
       FrameWork frameWork= IFrameWorkRepository.findById(id);
       Language updateLanguageId =iCourseService.getbyId(frameworkRequest.getCourseId());
       frameWork.setName(frameworkRequest.getName());
       frameWork.setLanguage(updateLanguageId);

       IFrameWorkRepository.save(frameWork);

    }

    @Override
    public void delete(int id) {
        IFrameWorkRepository.deleteById(id);
    }
}
