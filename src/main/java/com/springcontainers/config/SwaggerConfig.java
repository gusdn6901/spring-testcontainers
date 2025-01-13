package com.springcontainers.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
    info = @Info(
        title = "Spring Containers API",
        description = "API for Spring Containers Test",
        version = "1.0"
    )
)
public class SwaggerConfig {}
