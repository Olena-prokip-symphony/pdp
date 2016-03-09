package ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;


@WebService(targetNamespace = "http://localhost:8088/cts", name = "CurrentTimeService")
@XmlSeeAlso({ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface CurrentTimeService {

    @WebResult(name = "currentTime", targetNamespace = "http://localhost:8088/cts", partName = "currentTime")
    @WebMethod(action = "http://localhost:8088/cts")
    public javax.xml.datatype.XMLGregorianCalendar getCurrentTime(
        @WebParam(partName = "timeZoneId", name = "timeZoneId", targetNamespace = "http://localhost:8088/cts")
        java.lang.String timeZoneId
    );
}
