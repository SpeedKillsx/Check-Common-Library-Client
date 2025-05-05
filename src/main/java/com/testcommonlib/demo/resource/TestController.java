package com.testcommonlib.demo.resource;

import io.github.speedkillsx.checkcommonlib.annotation.RetryOnFailure;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api")
@Slf4j
public class TestController {

    @GetMapping("/test")
    public String test() {
        return "Hello World";
    }

    @RetryOnFailure(maxAttempts = 3, delayMs = 200, includes = {IOException.class}, excludes = {Error.class})
    @GetMapping("/retry")
    public String mathRetry() throws IOException {
        log.info("mathRetry");
        if (Math.random() < 0.85) {
            throw new IOException("Random error");
        }
        return "OK";
    }
}
