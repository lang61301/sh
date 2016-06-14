/**
 * 
 */
package me.paddingdun.ext.spring;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.Version;
import org.codehaus.jackson.map.DeserializationConfig.Feature;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.module.SimpleModule;
import org.springframework.stereotype.Component;

import me.paddingdun.util.DateHelper;


/**
 * 增加spring mvc 中timestamp类型的json和对象互转;
 * @author paddingdun
 *
 * 2016年2月23日
 */
@Component("customObjectMapper")  
public class CustomObjectMapper extends ObjectMapper {

	public CustomObjectMapper() {
		super();
		
		configure(Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		
		 SimpleModule module = new SimpleModule("v1.0", new Version(1, 0, 0, null));
         
	        module.addSerializer(Timestamp.class, new JsonSerializer<Timestamp>(){  
	            @Override 
	            public void serialize(Timestamp value,   
	                    JsonGenerator jsonGenerator,   
	                    SerializerProvider provider)  
	                    throws IOException, JsonProcessingException {
	            	if(value == null)
	            		jsonGenerator.writeNull();
	            	else
	            		jsonGenerator.writeString(DateHelper.format(value));  
	            }
	        });
	        module.addDeserializer(Timestamp.class, new JsonDeserializer<Timestamp>(){
	            @Override
	            public Timestamp deserialize(JsonParser jp, DeserializationContext ctxt)
	                    throws IOException, JsonProcessingException {
	            	Timestamp t = null;
	            	if(StringUtils.isNotBlank(jp.getText())){
	            		Date d = DateHelper.parseDate(jp.getText().trim());
	            		if(d != null){
	            			t = new Timestamp(d.getTime());
	            		}
	            	}
	                return t;
	                 
	            }            
	        });
	         
	        this.registerModule(module);
    }  
}
