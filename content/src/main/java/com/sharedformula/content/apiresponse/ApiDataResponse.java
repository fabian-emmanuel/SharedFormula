package com.sharedformula.content.apiresponse;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
public class ApiDataResponse<T> {
  private HttpStatus status;
  private String message;
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
  private LocalDateTime timestamp;
  private T data;

  public ApiDataResponse(HttpStatus status) {
    this.status = status;
  }
}