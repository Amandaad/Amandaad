package com.amanda.backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class TaskRequest {

    @NotBlank(message = "O título é obrigatório")
    @Size(max = 120, message = "O título deve ter no máximo 120 caracteres")
    private String title;

    @Size(max = 300, message = "A descrição deve ter no máximo 300 caracteres")
    private String description;

    private boolean completed;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
