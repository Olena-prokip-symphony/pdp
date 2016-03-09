package ws;


import javax.jws.WebParam;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class CurrentTimeServiceImpl implements CurrentTimeService {
    
    public XMLGregorianCalendar getCurrentTime(
            @WebParam(partName = "timeZoneId", name = "timeZoneId", targetNamespace = "http://localhost:8088/cts")
            String timeZoneId) {

        XMLGregorianCalendar gregorianCalendar;

        try {
            gregorianCalendar = getXmlGregorianCalendar(timeZoneId);
        } catch (DatatypeConfigurationException e) {
            throw new RuntimeException(e);
        }

        return gregorianCalendar;
    }

    private XMLGregorianCalendar getXmlGregorianCalendar(String id) throws DatatypeConfigurationException {
        TimeZone timeZone;

        if (!"".equals(id)) {
            timeZone = TimeZone.getTimeZone(id);
        } else {
            timeZone = TimeZone.getDefault();
        }

        GregorianCalendar gregorianCalendar = new GregorianCalendar(timeZone);

        return DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);
    }
}
