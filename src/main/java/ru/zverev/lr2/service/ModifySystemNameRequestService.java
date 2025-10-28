package ru.zverev.lr2.service;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.zverev.lr2.model.Request;
import ru.zverev.lr2.model.Systems;

@Service
public class ModifySystemNameRequestService implements ModifyRequestService
{
    @Override
    public void modify(Request request) {
        request.setSystemName(Systems.System_1);

        HttpEntity<Request> requestEntity = new HttpEntity<>(request);

        new RestTemplate().exchange(
                "http://localhost:8080/feedback",
                HttpMethod.POST,
                requestEntity,
                new ParameterizedTypeReference<Request>(){}
        );

    }
}
