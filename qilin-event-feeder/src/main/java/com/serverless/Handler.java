package com.serverless;

import com.amazonaws.services.cloudwatch.AmazonCloudWatch;
import com.amazonaws.services.cloudwatch.AmazonCloudWatchClientBuilder;
import com.amazonaws.services.cloudwatch.model.*;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import org.apache.log4j.Logger;

import java.util.Map;
import java.util.Random;

public class Handler implements RequestHandler<Map<String, Object>, ApiGatewayResponse> {

	private static final Logger LOG = Logger.getLogger(Handler.class);

	@Override
	public ApiGatewayResponse handleRequest(Map<String, Object> input, Context context) {
		LOG.info("received: " + input);
		final AmazonCloudWatch cw =
				AmazonCloudWatchClientBuilder.defaultClient();
		Dimension dimension = new Dimension()
				.withName("FeederInstance")
				.withValue("qilin-metrics-feeder");

		MetricDatum datum = new MetricDatum()
				.withMetricName("Lazy_Metrics")
				.withUnit(StandardUnit.None)
				.withValue(new Random().nextDouble() * 10)
				.withDimensions(dimension);

		PutMetricDataRequest request = new PutMetricDataRequest()
				.withNamespace("Qilin/Metrics")
				.withMetricData(datum);

		PutMetricDataResult response = cw.putMetricData(request);

		return ApiGatewayResponse.builder()
				.setStatusCode(200)
				.setObjectBody(response)
				.build();
	}
}
