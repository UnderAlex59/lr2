package ru.zverev.lr2.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.zverev.lr2.model.Response;

import java.util.UUID;

@Service
@Qualifier("ModifyOperationUidResponseService")
@Slf4j
public class ModifyOperationUidResponseService implements ModifyResponseService {
    @Override
    public Response modify(Response response) {

        UUID uuid = UUID.randomUUID();
        log.info("modify operation uid response on" + uuid);
        response.setOperationUid(uuid.toString());

        return response;

    }
}
