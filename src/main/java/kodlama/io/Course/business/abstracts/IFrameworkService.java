package kodlama.io.Course.business.abstracts;

import kodlama.io.Course.business.Requests.FrameworkRequest;
import kodlama.io.Course.business.Responses.FrameworkResponse;
import kodlama.io.Course.entities.concretes.FrameWork;

import java.util.List;

public interface IFrameworkService {
  public List<FrameworkResponse> getall();
  public FrameworkResponse getResponsebyId(int id);
  public void add(FrameworkRequest frameworkRequest);
  public void update(FrameworkRequest frameworkRequest,int id);
  public void delete(int id);
}
