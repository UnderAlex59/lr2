package ru.zverev.lr2.util;

import ru.zverev.lr2.model.*;

public class ResponseUtils {
    public static Response getPrefillResponse(Request request) {
        return Response.builder()
                .uid(request.getUid())
                .operationUid(request.getOperationUid())
                .code(Codes.SUCCESS)
                .errorCode(ErrorCodes.EMPTY)
                .errorMessage(ErrorMessages.EMPTY)
                .build();
    }
}
