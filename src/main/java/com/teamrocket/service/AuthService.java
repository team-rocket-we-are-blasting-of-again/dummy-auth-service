package com.teamrocket.service;

import com.teamrocket.proto.CreateUserRequest;
import com.teamrocket.proto.CreateUserResponse;
import com.teamrocket.proto.UserGrpc.UserImplBase;
import com.teamrocket.server.GrpcServer;
import io.grpc.stub.StreamObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class AuthService extends UserImplBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserImplBase.class);

    @Override
    public void createUser(CreateUserRequest request, StreamObserver<CreateUserResponse> responseObserver) {

        LOGGER.info("Create User fired");

        CreateUserResponse.Builder responseBuilder =
                CreateUserResponse
                        .newBuilder()
                        .setId(999);

        CreateUserResponse response = responseBuilder.build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
        LOGGER.info("Response id: {}", response.getId());

    }
}
