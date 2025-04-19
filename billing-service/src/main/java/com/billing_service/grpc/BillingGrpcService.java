package com.billing_service.grpc;

import billing.BillingResponse;
import billing.BillingServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@GrpcService
public class BillingGrpcService extends BillingServiceGrpc.BillingServiceImplBase {

    private static final Logger log = LoggerFactory.getLogger(BillingGrpcService.class);

    @Override
    public void createBillingAccount(billing.BillingRequest billingRequest,
                                     StreamObserver<BillingResponse> responseStreamObserver) {

        log.info("CreateBillingRequest request received {}", billingRequest.toString());

        // Business logic example save to database , perform calculates etc

        BillingResponse response = BillingResponse.newBuilder()
                .setAccountId("98765")
                .setStatus("ACTIVE")
                .build();
        responseStreamObserver.onNext(response);
        responseStreamObserver.onCompleted();
    }
}
