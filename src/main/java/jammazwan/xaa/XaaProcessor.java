package jammazwan.xaa;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class XaaProcessor  implements Processor {
	
    public void process(Exchange exchange) throws Exception {
		exchange.getIn().setHeader("CamelFileName", "city.json");
	}

}
