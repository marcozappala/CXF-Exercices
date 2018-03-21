package services;

import java.util.Map;

import javax.jws.WebService;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import adapters.StudentMapAdapter;
import model.Student;

@WebService
public interface HelloStudent {
  public String hello(String name);

  public String helloStudent(Student student);

  @XmlJavaTypeAdapter(StudentMapAdapter.class)
  public Map<Integer, Student> getStudents();
}
