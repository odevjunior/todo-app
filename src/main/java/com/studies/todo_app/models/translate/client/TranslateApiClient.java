package com.studies.todo_app.models.translate.client;

import com.studies.todo_app.models.translate.TranslateRequestEntity;
import com.studies.todo_app.models.translate.TranslateResponseEntity;
import feign.HeaderMap;
import feign.Headers;
import feign.RequestLine;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.Map;

public interface TranslateApiClient {

    @RequestLine("POST /translator/html")
    TranslateResponseEntity translate(@RequestBody TranslateRequestEntity body, @HeaderMap Map<String, String> headers);


}
