package com.gaurav.springbootsoapexample.endpoint;

import com.gaurav.soap.example.GetUserRequest;
import com.gaurav.soap.example.GetUserResponse;
import com.gaurav.soap.example.User;
import com.gaurav.springbootsoapexample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class UserEndPoint {
    @Autowired
    private UserService userService;

    @PayloadRoot(namespace = "http://gaurav.com/soap/example",localPart = "getUserRequest")
    @ResponsePayload
    public GetUserResponse getUserRequest(@RequestPayload GetUserRequest request){

        GetUserResponse response = new GetUserResponse();
        User user = userService.getUsers(request.getName());
        response.setUser(user);
        return response;
    }

}
