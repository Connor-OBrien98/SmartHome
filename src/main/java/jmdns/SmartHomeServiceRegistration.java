package jmdns;

import java.io.IOException;
import java.net.InetAddress;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

public class SmartHomeServiceRegistration {
	
	public static void main(String[] args) throws InterruptedException {

        try {

            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

            ServiceInfo light = ServiceInfo.create("_http._tcp.local.", "light", 50051, "Manage Lights");
            jmdns.registerService(light);
            ServiceInfo thermostat = ServiceInfo.create("_http._tcp.local.", "heating", 50052, "Change Temperature");
            jmdns.registerService(thermostat);
            ServiceInfo printer = ServiceInfo.create("_http._tcp.local.", "fax", 50053, "Manage Fax Machine");
            jmdns.registerService(printer);
            ServiceInfo projector = ServiceInfo.create("_http._tcp.local.", "coffee", 50054, "Manage Coffee Maker");
            jmdns.registerService(projector);
            

            Thread.sleep(25000);

            jmdns.unregisterAllServices();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}