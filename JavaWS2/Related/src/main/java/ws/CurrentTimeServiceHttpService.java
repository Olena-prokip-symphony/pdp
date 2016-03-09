package ws.cts;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;


@WebServiceClient(name = "CurrentTimeService_HttpService", 
                  wsdlLocation = "../Related/src/main/resources/CurrentTimeService.wsdl",
                  targetNamespace = "http://localhost:8088/cts") 
public class CurrentTimeServiceHttpService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://localhost:8088/cts", "CurrentTimeService_HttpService");
    public final static QName CurrentTimeServiceHttpPort = new QName("http://localhost:8088/cts", "CurrentTimeService_HttpPort");
    static {
        URL url = CurrentTimeServiceHttpService.class.getResource("../Related/src/main/resources/CurrentTimeService.wsdl");
        if (url == null) {
            java.util.logging.Logger.getLogger(CurrentTimeServiceHttpService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "../Related/src/main/resources/CurrentTimeService.wsdl");
        }       
        WSDL_LOCATION = url;
    }

    public CurrentTimeServiceHttpService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public CurrentTimeServiceHttpService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CurrentTimeServiceHttpService() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public CurrentTimeServiceHttpService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public CurrentTimeServiceHttpService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public CurrentTimeServiceHttpService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     *
     * @return
     *     returns CurrentTimeService
     */
    @WebEndpoint(name = "CurrentTimeService_HttpPort")
    public CurrentTimeService getCurrentTimeServiceHttpPort() {
        return super.getPort(CurrentTimeServiceHttpPort, CurrentTimeService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns CurrentTimeService
     */
    @WebEndpoint(name = "CurrentTimeService_HttpPort")
    public CurrentTimeService getCurrentTimeServiceHttpPort(WebServiceFeature... features) {
        return super.getPort(CurrentTimeServiceHttpPort, CurrentTimeService.class, features);
    }

}
