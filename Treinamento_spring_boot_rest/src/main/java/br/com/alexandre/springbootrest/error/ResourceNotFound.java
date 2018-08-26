package br.com.alexandre.springbootrest.error;

public class ResourceNotFound {
    private String message;

    public ResourceNotFound(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
