package com.yinrj.soupstudy.webservice;

import com.yinrj.soupstudy.type.EmployeeDetailRequest;
import com.yinrj.soupstudy.type.EmployeeDetailResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

/**
 * @author Yin
 * @date 2021/1/23
 */
@Endpoint
public class EndPoint {
    private static final String NAMESPACE_URI = "http://yinrj.com/soupstudy/type";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "EmployeeDetailRequest")
    @ResponsePayload
    public EmployeeDetailResponse getEmployee(@RequestPayload EmployeeDetailRequest request) {
        EmployeeDetailResponse response = new EmployeeDetailResponse();
        response.setCode("1111");
        response.setEmail("jkljkl");
        response.setName("tttt");
        return response;
    }
}
