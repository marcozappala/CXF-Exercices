import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;

import org.junit.Before;
import org.junit.Test;

import services.HelloStudent;
import services.HelloStudentImpl;

import static org.junit.Assert.assertEquals;

public class StudentTest {
  private static QName SERVICE_NAME
      = new QName("http://deployment/", "HelloStudent");
  private static QName PORT_NAME
      = new QName("http://introduction.cxf.zap.com/", "ZaPort");

  private Service service;
  private HelloStudent helloStudentProxy;
  private HelloStudentImpl helloStudentImpl;

  {
    service = Service.create(SERVICE_NAME);
    String endpointAddress = "http://localhost:8080/hellostudent";
    service.addPort(PORT_NAME, SOAPBinding.SOAP11HTTP_BINDING, endpointAddress);
  }

  @Before
  public void reinstantiateMarcoInstances() {
    helloStudentImpl = new HelloStudentImpl();
    helloStudentProxy = service.getPort(PORT_NAME, HelloStudent.class);
  }

  @Test
  public void whenUsingHelloMethod_thenCorrect() {
    String endpointResponse = helloStudentProxy.hello("Marco");
    String localResponse = helloStudentImpl.hello("Marco");
    assertEquals(localResponse, endpointResponse);
  }

}
