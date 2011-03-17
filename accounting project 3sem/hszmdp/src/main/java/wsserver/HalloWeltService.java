package wsserver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6 in JDK 6
 * Generated source version: 2.1
 *
 */
@WebServiceClient(name = "HalloWeltService", targetNamespace = "http://wsserver/", wsdlLocation = "http://192.168.0.112:8081/hszmdp/services/hallo?wsdl")
public class HalloWeltService
    extends Service
{

    private final static URL HALLOWELTSERVICE_WSDL_LOCATION;
    private final static Logger logger = Logger.getLogger(wsserver.HalloWeltService.class.getName());

    static {
        URL url = null;
        try {
            URL baseUrl;
            baseUrl = wsserver.HalloWeltService.class.getResource(".");
            url = new URL(baseUrl, "http://192.168.0.112:8081/hszmdp/services/hallo?wsdl");
        } catch (MalformedURLException e) {
            logger.warning("Failed to create URL for the wsdl Location: 'http://192.168.0.112:8081/hszmdp/services/hallo?wsdl', retrying as a local file");
            logger.warning(e.getMessage());
        }
        HALLOWELTSERVICE_WSDL_LOCATION = url;
    }

    public HalloWeltService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public HalloWeltService() {
        super(HALLOWELTSERVICE_WSDL_LOCATION, new QName("http://wsserver/", "HalloWeltService"));
    }

    /**
     *
     * @return
     *     returns HalloWelt
     */
    @WebEndpoint(name = "HalloWeltPort")
    public HalloWelt getHalloWeltPort() {
        return super.getPort(new QName("http://moneten.und.pasteten/", "HalloWeltPort"), HalloWelt.class);
    }

    /**
     *
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns HalloWelt
     */
    @WebEndpoint(name = "HalloWeltPort")
    public HalloWelt getHalloWeltPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://wsserver/", "HalloWeltPort"), HalloWelt.class, features);
    }

}
