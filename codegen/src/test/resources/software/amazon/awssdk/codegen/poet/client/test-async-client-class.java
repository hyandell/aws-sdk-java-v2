package software.amazon.awssdk.services.json;

import java.util.concurrent.CompletableFuture;
import javax.annotation.Generated;
import software.amazon.awssdk.AmazonServiceException;
import software.amazon.awssdk.annotation.SdkInternalApi;
import software.amazon.awssdk.async.AsyncRequestProvider;
import software.amazon.awssdk.async.AsyncResponseHandler;
import software.amazon.awssdk.client.AsyncClientHandler;
import software.amazon.awssdk.client.AwsAsyncClientParams;
import software.amazon.awssdk.client.ClientExecutionParams;
import software.amazon.awssdk.client.ClientHandlerParams;
import software.amazon.awssdk.client.SdkAsyncClientHandler;
import software.amazon.awssdk.http.HttpResponseHandler;
import software.amazon.awssdk.http.async.SdkHttpResponseHandler;
import software.amazon.awssdk.protocol.json.JsonClientMetadata;
import software.amazon.awssdk.protocol.json.JsonErrorResponseMetadata;
import software.amazon.awssdk.protocol.json.JsonErrorShapeMetadata;
import software.amazon.awssdk.protocol.json.JsonOperationMetadata;
import software.amazon.awssdk.protocol.json.SdkJsonProtocolFactory;
import software.amazon.awssdk.services.json.model.APostOperationRequest;
import software.amazon.awssdk.services.json.model.APostOperationResponse;
import software.amazon.awssdk.services.json.model.APostOperationWithOutputRequest;
import software.amazon.awssdk.services.json.model.APostOperationWithOutputResponse;
import software.amazon.awssdk.services.json.model.InvalidInputException;
import software.amazon.awssdk.services.json.model.StreamingInputOperationRequest;
import software.amazon.awssdk.services.json.model.StreamingInputOperationResponse;
import software.amazon.awssdk.services.json.model.StreamingOutputOperationRequest;
import software.amazon.awssdk.services.json.model.StreamingOutputOperationResponse;
import software.amazon.awssdk.services.json.transform.APostOperationRequestMarshaller;
import software.amazon.awssdk.services.json.transform.APostOperationResponseUnmarshaller;
import software.amazon.awssdk.services.json.transform.APostOperationWithOutputRequestMarshaller;
import software.amazon.awssdk.services.json.transform.APostOperationWithOutputResponseUnmarshaller;
import software.amazon.awssdk.services.json.transform.StreamingInputOperationRequestMarshaller;
import software.amazon.awssdk.services.json.transform.StreamingInputOperationResponseUnmarshaller;
import software.amazon.awssdk.services.json.transform.StreamingOutputOperationRequestMarshaller;
import software.amazon.awssdk.services.json.transform.StreamingOutputOperationResponseUnmarshaller;

/**
 * Internal implementation of {@link JsonAsyncClient}.
 *
 * @see JsonAsyncClient#builder()
 */
@Generated("software.amazon.awssdk:codegen")
@SdkInternalApi
final class DefaultJsonAsyncClient implements JsonAsyncClient {
    private final AsyncClientHandler clientHandler;

    private final SdkJsonProtocolFactory protocolFactory;

    protected DefaultJsonAsyncClient(AwsAsyncClientParams clientParams) {
        this.clientHandler = new SdkAsyncClientHandler(new ClientHandlerParams().withAsyncClientParams(clientParams)
                                                                                .withClientParams(clientParams).withCalculateCrc32FromCompressedDataEnabled(false));
        this.protocolFactory = init();
    }

    /**
     * <p>
     * Performs a post operation to the query service and has no output
     * </p>
     *
     * @param aPostOperationRequest
     * @return A Java Future containing the result of the APostOperation operation returned by the service. <br/>
     *         The CompletableFuture returned by this method can be completed exceptionally with the following
     *         exceptions.
     *         <ul>
     *         <li>InvalidInputException The request was rejected because an invalid or out-of-range value was supplied
     *         for an input parameter.</li>
     *         <li>SdkBaseException Base class for all exceptions that can be thrown by the SDK (both service and
     *         client). Can be used for catch all scenarios.</li>
     *         <li>SdkClientException If any client side error occurs such as an IO related failure, failure to get
     *         credentials, etc</li>
     *         <li>JsonException Base class for all service exceptions. Unknown exceptions will be thrown as an instance
     *         of this</li >
     *         <ul>
     * @sample JsonAsyncClient.APostOperation
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/json-service-2010-05-08/APostOperation" target="_top">AWS
     *      API Documentation</a>
     */
    @Override
    public CompletableFuture<APostOperationResponse> aPostOperation(APostOperationRequest aPostOperationRequest) {

        HttpResponseHandler<APostOperationResponse> responseHandler = protocolFactory.createResponseHandler(
                new JsonOperationMetadata().withPayloadJson(true), new APostOperationResponseUnmarshaller());

        HttpResponseHandler<AmazonServiceException> errorResponseHandler = createErrorResponseHandler();

        return clientHandler.execute(new ClientExecutionParams<APostOperationRequest, APostOperationResponse>()
                                             .withMarshaller(new APostOperationRequestMarshaller(protocolFactory)).withResponseHandler(responseHandler)
                                             .withErrorResponseHandler(errorResponseHandler).withInput(aPostOperationRequest));
    }

    /**
     * <p>
     * Performs a post operation to the query service and has modelled output
     * </p>
     *
     * @param aPostOperationWithOutputRequest
     * @return A Java Future containing the result of the APostOperationWithOutput operation returned by the service. <br/>
     *         The CompletableFuture returned by this method can be completed exceptionally with the following
     *         exceptions.
     *         <ul>
     *         <li>InvalidInputException The request was rejected because an invalid or out-of-range value was supplied
     *         for an input parameter.</li>
     *         <li>SdkBaseException Base class for all exceptions that can be thrown by the SDK (both service and
     *         client). Can be used for catch all scenarios.</li>
     *         <li>SdkClientException If any client side error occurs such as an IO related failure, failure to get
     *         credentials, etc</li>
     *         <li>JsonException Base class for all service exceptions. Unknown exceptions will be thrown as an instance
     *         of this</li >
     *         <ul>
     * @sample JsonAsyncClient.APostOperationWithOutput
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/json-service-2010-05-08/APostOperationWithOutput"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public CompletableFuture<APostOperationWithOutputResponse> aPostOperationWithOutput(
            APostOperationWithOutputRequest aPostOperationWithOutputRequest) {

        HttpResponseHandler<APostOperationWithOutputResponse> responseHandler = protocolFactory.createResponseHandler(
                new JsonOperationMetadata().withPayloadJson(true), new APostOperationWithOutputResponseUnmarshaller());

        HttpResponseHandler<AmazonServiceException> errorResponseHandler = createErrorResponseHandler();

        return clientHandler
                .execute(new ClientExecutionParams<APostOperationWithOutputRequest, APostOperationWithOutputResponse>()
                                 .withMarshaller(new APostOperationWithOutputRequestMarshaller(protocolFactory))
                                 .withResponseHandler(responseHandler).withErrorResponseHandler(errorResponseHandler)
                                 .withInput(aPostOperationWithOutputRequest));
    }

    /**
     * Some operation with a streaming input
     *
     * @param streamingInputOperationRequest
     * @param requestProvider
     *        Functional interface that can be implemented to produce the request content in a non-blocking manner. The
     *        size of the content is expected to be known up front. See {@link AsyncRequestProvider} for specific
     *        details on implementing this interface as well as links to precanned implementations for common scenarios
     *        like uploading from a file. The service documentation for the request content is as follows 'This be a
     *        stream'.
     * @return A Java Future containing the result of the StreamingInputOperation operation returned by the service.
     * @sample JsonAsyncClient.StreamingInputOperation
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/json-service-2010-05-08/StreamingInputOperation"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public CompletableFuture<StreamingInputOperationResponse> streamingInputOperation(
            StreamingInputOperationRequest streamingInputOperationRequest, AsyncRequestProvider requestProvider) {

        HttpResponseHandler<StreamingInputOperationResponse> responseHandler = protocolFactory.createResponseHandler(
                new JsonOperationMetadata().withPayloadJson(true), new StreamingInputOperationResponseUnmarshaller());

        HttpResponseHandler<AmazonServiceException> errorResponseHandler = createErrorResponseHandler();

        return clientHandler.execute(new ClientExecutionParams<StreamingInputOperationRequest, StreamingInputOperationResponse>()
                                             .withMarshaller(new StreamingInputOperationRequestMarshaller(protocolFactory))
                                             .withResponseHandler(responseHandler).withErrorResponseHandler(errorResponseHandler)
                                             .withAsyncRequestProvider(requestProvider).withInput(streamingInputOperationRequest));
    }

    /**
     * Some operation with a streaming output
     *
     * @param streamingOutputOperationRequest
     * @param asyncResponseHandler
     *        The response handler for processing the streaming response in a non-blocking manner. See
     *        {@link AsyncResponseHandler} for details on how this callback should be implemented and for links to
     *        precanned implementations for common scenarios like downloading to a file. The service documentation for
     *        the streamed content is as follows 'This be a stream'.
     * @return A future to the transformed result of the AsyncResponseHandler.
     * @sample JsonAsyncClient.StreamingOutputOperation
     * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/json-service-2010-05-08/StreamingOutputOperation"
     *      target="_top">AWS API Documentation</a>
     */
    @Override
    public <ReturnT> CompletableFuture<ReturnT> streamingOutputOperation(
            StreamingOutputOperationRequest streamingOutputOperationRequest,
            AsyncResponseHandler<StreamingOutputOperationResponse, ReturnT> asyncResponseHandler) {

        SdkHttpResponseHandler<ReturnT> responseHandler = protocolFactory.createAsyncStreamingResponseHandler(
                new StreamingOutputOperationResponseUnmarshaller(), asyncResponseHandler);

        HttpResponseHandler<AmazonServiceException> errorResponseHandler = createErrorResponseHandler();

        return clientHandler.execute(new ClientExecutionParams<StreamingOutputOperationRequest, ReturnT>()
                                             .withMarshaller(new StreamingOutputOperationRequestMarshaller(protocolFactory))
                                             .withAsyncResponseHandler(responseHandler).withErrorResponseHandler(errorResponseHandler)
                                             .withInput(streamingOutputOperationRequest));
    }

    @Override
    public void close() throws Exception {
        clientHandler.close();
    }

    private software.amazon.awssdk.protocol.json.SdkJsonProtocolFactory init() {
        return new SdkJsonProtocolFactory(new JsonClientMetadata()
                                                  .withProtocolVersion("1.1")
                                                  .withSupportsCbor(false)
                                                  .withSupportsIon(false)
                                                  .withBaseServiceExceptionClass(software.amazon.awssdk.services.json.model.JsonException.class)
                                                  .withContentTypeOverride("")
                                                  .addErrorMetadata(
                                                          new JsonErrorShapeMetadata().withErrorCode("InvalidInput").withModeledClass(InvalidInputException.class)));
    }

    private HttpResponseHandler<AmazonServiceException> createErrorResponseHandler() {
        return protocolFactory.createErrorResponseHandler(new JsonErrorResponseMetadata());
    }
}