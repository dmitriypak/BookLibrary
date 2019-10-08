package ru.projects.edu.spring.task14.booklibrary.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

  private final StoragePath storagePath;

  public WebMvcConfig(StoragePath storagePath) {
    this.storagePath = storagePath;
  }

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/images/**")
        .addResourceLocations("file:"+storagePath.getPath()+"/");
  }
}
