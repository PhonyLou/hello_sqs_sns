package com.serverless;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.SQSEvent;
import org.apache.log4j.Logger;

public class Handler implements RequestHandler<SQSEvent, ApiGatewayResponse> {

	private static final Logger LOG = Logger.getLogger(Handler.class);

	@Override
	public ApiGatewayResponse handleRequest(SQSEvent event, Context context) {
		LOG.info("fdsafdsafdsafdsa");
		LOG.info("received: " + event);
//		final AmazonCloudWatch cw =
//				AmazonCloudWatchClientBuilder.defaultClient();
//		Dimension dimension = new Dimension()
//				.withName("FeederInstance")
//				.withValue("qilin-metrics-feeder");
//
//		MetricDatum datum = new MetricDatum()
//				.withMetricName("Lazy_Metrics")
//				.withUnit(StandardUnit.None)
//				.withValue(new Random().nextDouble() * 10)
//				.withDimensions(dimension);
//
//		PutMetricDataRequest request = new PutMetricDataRequest()
//				.withNamespace("Qilin/Metrics")
//				.withMetricData(datum);
//
//		PutMetricDataResult response = cw.putMetricData(request);

		return ApiGatewayResponse.builder()
				.setStatusCode(200)
				.setObjectBody("Success!!")
				.build();
	}
}
