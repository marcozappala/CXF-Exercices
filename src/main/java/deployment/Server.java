package deployment;

import javax.xml.ws.Endpoint;

import services.HelloStudent;
import services.HelloStudentImpl;

public class Server {
    public static void main(String args[]) throws InterruptedException {
        HelloStudent implementor = new HelloStudentImpl();
        String address = "http://localhost:8080/zap";
        Endpoint.publish(address, implementor);
        Thread.sleep(60 * 1000);        
        System.exit(0);
    }
}
