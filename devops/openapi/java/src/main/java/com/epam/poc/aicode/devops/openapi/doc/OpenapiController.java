package com.epam.poc.aicode.devops.openapi.doc;


import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping("/v3/api-docs")
public class OpenapiController {

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public StreamingResponseBody getOpenApiJson() throws IOException {
        ClassPathResource resource = new ClassPathResource("static/generatedOpenApi.json");
        InputStream inputStream = resource.getInputStream();
        return outputStream -> {
            int nRead;
            byte[] data = new byte[1024];
            while ((nRead = inputStream.read(data, 0, data.length)) != -1) {
                outputStream.write(data, 0, nRead);
            }
            inputStream.close();
        };
    }
}
