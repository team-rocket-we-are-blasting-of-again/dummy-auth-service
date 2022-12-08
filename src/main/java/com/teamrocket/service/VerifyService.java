package com.teamrocket.service;

import com.teamrocket.proto.VerifyGrpc.VerifyImplBase;
import com.teamrocket.proto.VerifyUserRequest;
import com.teamrocket.proto.VerifyUserResponse;
import io.grpc.stub.StreamObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VerifyService extends VerifyImplBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(VerifyService.class);

    @Override
    public void verifyUser(VerifyUserRequest request, StreamObserver<VerifyUserResponse> responseObserver) {
        VerifyUserResponse response = VerifyUserResponse.newBuilder().build();
       // response.get

        super.verifyUser(request, responseObserver);
    }
}
