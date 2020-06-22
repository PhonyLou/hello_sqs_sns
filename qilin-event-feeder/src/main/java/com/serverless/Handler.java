package com.serverless;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.SQSEvent;
import org.apache.log4j.Logger;

public class Handler implements RequestHandler<SQSEvent, ApiGatewayResponse> {

	private static final Logger LOG = Logger.getLogger(Handler.class);

	@Override
	public ApiGatewayResponse handleRequest(SQSEvent event, Context context) {
		LambdaLogger logger = context.getLogger();
		logger.log("fdsafdsafdsafdsa");
		logger.log("received: " + event);

		return ApiGatewayResponse.builder()
				.setStatusCode(200)
				.setObjectBody("Success!!")
				.build();
	}
}
