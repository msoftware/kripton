package sqlite.quickstart.model;

import com.abubusoft.kripton.AbstractContext;
import com.abubusoft.kripton.AbstractMapper;
import com.abubusoft.kripton.annotation.BindMap;
import com.abubusoft.kripton.escape.StringEscapeUtils;
import com.abubusoft.kripton.xml.XMLParser;
import com.abubusoft.kripton.xml.XMLSerializer;
import com.abubusoft.kripton.xml.XmlPullParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.lang.Exception;
import java.lang.Override;

/**
 * This class is the shared preference binder defined for Address
 *
 * @see Address
 */
@BindMap(Address.class)
public class AddressBindMap extends AbstractMapper<Address> {
  /**
   * GeoBindMap */
  private GeoBindMap geoBindMap = AbstractContext.mapperFor(Geo.class);

  /**
   * reset shared preferences
   */
  @Override
  public int serializeOnJackson(Address object, JsonGenerator jacksonSerializer) throws Exception {
    jacksonSerializer.writeStartObject();
    int fieldCount=0;

    // Serialized Field:

    // field city (mapped with "city")
    if (object.city!=null)  {
      fieldCount++;
      jacksonSerializer.writeStringField("city", object.city);
    }

    // field geo (mapped with "geo")
    if (object.geo!=null)  {
      fieldCount++;
      jacksonSerializer.writeFieldName("geo");
      geoBindMap.serializeOnJackson(object.geo, jacksonSerializer);
    }

    // field street (mapped with "street")
    if (object.street!=null)  {
      fieldCount++;
      jacksonSerializer.writeStringField("street", object.street);
    }

    // field suite (mapped with "suite")
    if (object.suite!=null)  {
      fieldCount++;
      jacksonSerializer.writeStringField("suite", object.suite);
    }

    // field zipcode (mapped with "zipcode")
    if (object.zipcode!=null)  {
      fieldCount++;
      jacksonSerializer.writeStringField("zipcode", object.zipcode);
    }

    jacksonSerializer.writeEndObject();
    return fieldCount;
  }

  /**
   * reset shared preferences
   */
  @Override
  public int serializeOnJacksonAsString(Address object, JsonGenerator jacksonSerializer) throws Exception {
    jacksonSerializer.writeStartObject();
    int fieldCount=0;

    // Serialized Field:

    // field city (mapped with "city")
    if (object.city!=null)  {
      fieldCount++;
      jacksonSerializer.writeStringField("city", object.city);
    }

    // field geo (mapped with "geo")
    if (object.geo!=null)  {
      fieldCount++;
      jacksonSerializer.writeFieldName("geo");
      if (geoBindMap.serializeOnJacksonAsString(object.geo, jacksonSerializer)==0) {
        jacksonSerializer.writeNullField("geo");
      }
    }

    // field street (mapped with "street")
    if (object.street!=null)  {
      fieldCount++;
      jacksonSerializer.writeStringField("street", object.street);
    }

    // field suite (mapped with "suite")
    if (object.suite!=null)  {
      fieldCount++;
      jacksonSerializer.writeStringField("suite", object.suite);
    }

    // field zipcode (mapped with "zipcode")
    if (object.zipcode!=null)  {
      fieldCount++;
      jacksonSerializer.writeStringField("zipcode", object.zipcode);
    }

    jacksonSerializer.writeEndObject();
    return fieldCount;
  }

  /**
   * reset shared preferences
   */
  @Override
  public void serializeOnXml(Address object, XMLSerializer xmlSerializer, int currentEventType) throws Exception {
    if (currentEventType == 0) {
      xmlSerializer.writeStartElement("address");
    }

    // Persisted fields:

    // field city (mapped with "city")
    if (object.city!=null) {
      xmlSerializer.writeStartElement("city");
      xmlSerializer.writeCharacters(StringEscapeUtils.escapeXml10(object.city));
      xmlSerializer.writeEndElement();
    }

    // field geo (mapped with "geo")
    if (object.geo!=null)  {
      xmlSerializer.writeStartElement("geo");
      geoBindMap.serializeOnXml(object.geo, xmlSerializer, 2);
      xmlSerializer.writeEndElement();
    }

    // field street (mapped with "street")
    if (object.street!=null) {
      xmlSerializer.writeStartElement("street");
      xmlSerializer.writeCharacters(StringEscapeUtils.escapeXml10(object.street));
      xmlSerializer.writeEndElement();
    }

    // field suite (mapped with "suite")
    if (object.suite!=null) {
      xmlSerializer.writeStartElement("suite");
      xmlSerializer.writeCharacters(StringEscapeUtils.escapeXml10(object.suite));
      xmlSerializer.writeEndElement();
    }

    // field zipcode (mapped with "zipcode")
    if (object.zipcode!=null) {
      xmlSerializer.writeStartElement("zipcode");
      xmlSerializer.writeCharacters(StringEscapeUtils.escapeXml10(object.zipcode));
      xmlSerializer.writeEndElement();
    }

    if (currentEventType == 0) {
      xmlSerializer.writeEndElement();
    }
  }

  /**
   * create new object instance
   */
  @Override
  public Address parseOnJackson(JsonParser jacksonParser) throws Exception {
    Address instance = new Address();
    String fieldName;
    if (jacksonParser.currentToken() == null) {
      jacksonParser.nextToken();
    }
    if (jacksonParser.currentToken() != JsonToken.START_OBJECT) {
      jacksonParser.skipChildren();
      return instance;
    }
    while (jacksonParser.nextToken() != JsonToken.END_OBJECT) {
      fieldName = jacksonParser.getCurrentName();
      jacksonParser.nextToken();

      // Parse fields:
      switch (fieldName) {
          case "city":
            // field city (mapped with "city")
            if (jacksonParser.currentToken()!=JsonToken.VALUE_NULL) {
              instance.city=jacksonParser.getText();
            }
          break;
          case "geo":
            // field geo (mapped with "geo")
            if (jacksonParser.currentToken()==JsonToken.START_OBJECT) {
              instance.geo=geoBindMap.parseOnJackson(jacksonParser);
            }
          break;
          case "street":
            // field street (mapped with "street")
            if (jacksonParser.currentToken()!=JsonToken.VALUE_NULL) {
              instance.street=jacksonParser.getText();
            }
          break;
          case "suite":
            // field suite (mapped with "suite")
            if (jacksonParser.currentToken()!=JsonToken.VALUE_NULL) {
              instance.suite=jacksonParser.getText();
            }
          break;
          case "zipcode":
            // field zipcode (mapped with "zipcode")
            if (jacksonParser.currentToken()!=JsonToken.VALUE_NULL) {
              instance.zipcode=jacksonParser.getText();
            }
          break;
          default:
            jacksonParser.skipChildren();
          break;}
    }
    return instance;
  }

  /**
   * create new object instance
   */
  @Override
  public Address parseOnJacksonAsString(JsonParser jacksonParser) throws Exception {
    Address instance = new Address();
    String fieldName;
    if (jacksonParser.getCurrentToken() == null) {
      jacksonParser.nextToken();
    }
    if (jacksonParser.getCurrentToken() != JsonToken.START_OBJECT) {
      jacksonParser.skipChildren();
      return instance;
    }
    while (jacksonParser.nextToken() != JsonToken.END_OBJECT) {
      fieldName = jacksonParser.getCurrentName();
      jacksonParser.nextToken();

      // Parse fields:
      switch (fieldName) {
          case "city":
            // field city (mapped with "city")
            if (jacksonParser.currentToken()!=JsonToken.VALUE_NULL) {
              instance.city=jacksonParser.getText();
            }
          break;
          case "geo":
            // field geo (mapped with "geo")
            if (jacksonParser.currentToken()==JsonToken.START_OBJECT || jacksonParser.currentToken()==JsonToken.VALUE_STRING) {
              instance.geo=geoBindMap.parseOnJacksonAsString(jacksonParser);
            }
          break;
          case "street":
            // field street (mapped with "street")
            if (jacksonParser.currentToken()!=JsonToken.VALUE_NULL) {
              instance.street=jacksonParser.getText();
            }
          break;
          case "suite":
            // field suite (mapped with "suite")
            if (jacksonParser.currentToken()!=JsonToken.VALUE_NULL) {
              instance.suite=jacksonParser.getText();
            }
          break;
          case "zipcode":
            // field zipcode (mapped with "zipcode")
            if (jacksonParser.currentToken()!=JsonToken.VALUE_NULL) {
              instance.zipcode=jacksonParser.getText();
            }
          break;
          default:
            jacksonParser.skipChildren();
          break;}
    }
    return instance;
  }

  /**
   * create new object instance
   */
  @Override
  public Address parseOnXml(XMLParser xmlParser, int currentEventType) throws Exception {
    Address instance = new Address();
    int eventType = currentEventType;
    boolean read=true;

    if (currentEventType == 0) {
      eventType = xmlParser.next();
    } else {
      eventType = xmlParser.getEventType();
    }
    String currentTag = xmlParser.getName().toString();
    String elementName = currentTag;
    // No attributes found

    //sub-elements
    while (xmlParser.hasNext() && elementName!=null) {
      if (read) {
        eventType = xmlParser.next();
      } else {
        eventType = xmlParser.getEventType();
      }
      read=true;
      switch(eventType) {
          case XmlPullParser.START_TAG:
            currentTag = xmlParser.getName().toString();
            switch(currentTag) {
                case "city":
                  // property city (mapped on "city")
                  instance.city=StringEscapeUtils.unescapeXml(xmlParser.getElementText());
                break;
                case "geo":
                  // property geo (mapped on "geo")
                  instance.geo=geoBindMap.parseOnXml(xmlParser, eventType);
                break;
                case "street":
                  // property street (mapped on "street")
                  instance.street=StringEscapeUtils.unescapeXml(xmlParser.getElementText());
                break;
                case "suite":
                  // property suite (mapped on "suite")
                  instance.suite=StringEscapeUtils.unescapeXml(xmlParser.getElementText());
                break;
                case "zipcode":
                  // property zipcode (mapped on "zipcode")
                  instance.zipcode=StringEscapeUtils.unescapeXml(xmlParser.getElementText());
                break;
                default:
                break;
              }
            break;
            case XmlPullParser.END_TAG:
              if (elementName.equals(xmlParser.getName())) {
                currentTag = elementName;
                elementName = null;
              }
            break;
            case XmlPullParser.CDSECT:
            case XmlPullParser.TEXT:
              // no property is binded to VALUE o CDATA break;
            default:
            break;
        }
      }
      return instance;
    }
  }
