package br.edu.ufcg.ccc.daca.backend.payload;

public class ApiResponse {
    private Boolean success;
    private String message;
    private int statusCode;
    private Object body;

    public ApiResponse(Boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public ApiResponse(Boolean success, String message, int statusCode) {
        this(success, message);
        this.statusCode = statusCode;
    }

    public ApiResponse(Boolean success, String message, int statusCode, Object body) {
        this(success, message, statusCode);
        this.body = body;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}
