package jammazwan.xaa;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.beans.factory.annotation.Autowired;

public class XaaRoutes extends RouteBuilder {

	@Autowired
	private XaaProcessor xaaProcessor;

	@Override
	public void configure() throws Exception {
		from("direct:xaa").marshal().json(JsonLibrary.Jackson, true).process(xaaProcessor).to("file:.");
	}
}
