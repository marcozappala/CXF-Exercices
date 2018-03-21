package adapters;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import model.Student;
import model.StudentMapImpl;

public class StudentMapAdapter
    extends XmlAdapter<StudentMapImpl, Map<Integer, Student>> {
  public StudentMapImpl marshal(Map<Integer, Student> boundMap) throws Exception {
    StudentMapImpl valueMap = new StudentMapImpl();
    for (Map.Entry<Integer, Student> boundEntry : boundMap.entrySet()) {
      StudentMapImpl.StudentEntry valueEntry  = new StudentMapImpl.StudentEntry();
      valueEntry.setStudent(boundEntry.getValue());
      valueEntry.setId(boundEntry.getKey());
      valueMap.getEntries().add(valueEntry);
    }
    return valueMap;
  }

  public Map<Integer, Student> unmarshal(StudentMapImpl valueMap) throws Exception {
    Map<Integer, Student> boundMap = new LinkedHashMap<Integer, Student>();
    for (StudentMapImpl.StudentEntry studentEntry : valueMap.getEntries()) {
      boundMap.put(studentEntry.getId(), studentEntry.getStudent());
    }
    return boundMap;
  }
}
