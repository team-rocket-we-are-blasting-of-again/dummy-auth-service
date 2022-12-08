package com.teamrocket.server;

import com.teamrocket.service.CustomerService;
import com.teamrocket.service.UserService;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class GrpcServer {

    private static final Logger LOGGER = LoggerFactory.getLogger(GrpcServer.class);

    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder
                .forPort(9000)
                .addService(new UserService()).build();

        Server customerServer = ServerBuilder
                .forPort(9066)
                .addService(new CustomerService()).build();

        server.start();
        LOGGER.info("Server started on port {}", server.getPort());


        customerServer.start();
        LOGGER.info("customerServer started on port {}", customerServer.getPort());
        customerServer.awaitTermination();  server.awaitTermination();
    }
}