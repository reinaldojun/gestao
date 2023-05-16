package com.project.gestao.domain.exceptions;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ErrorMessage {
	private int statusCode;
	@Builder.Default
	private LocalDateTime timestamp = LocalDateTime.now();
	private String message;
	private String description;
}
