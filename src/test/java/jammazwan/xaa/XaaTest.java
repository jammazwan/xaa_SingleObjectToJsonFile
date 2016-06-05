package jammazwan.xaa;

import org.apache.camel.test.spring.CamelSpringTestSupport;
import org.junit.Test;
import org.springframework.context.support.AbstractXmlApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import jammazwan.entity.City;

public class XaaTest extends CamelSpringTestSupport {

	@Override
	protected AbstractXmlApplicationContext createApplicationContext() {
		return new ClassPathXmlApplicationContext("META-INF/spring/camel-context.xml");
	}

	@Test
	public void testCityToJson() throws Exception {
		City city = new City(1, "Austin, TX", "USA", 1234567, 123, 12345);
		String reply = template.requestBody("direct:xaa", city, String.class);
		assertTrue(reply.contains("\"city\" : \"Austin, TX\""));
	}

}
