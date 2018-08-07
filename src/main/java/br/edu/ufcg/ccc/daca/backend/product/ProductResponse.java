package br.edu.ufcg.ccc.daca.backend.product;

import br.edu.ufcg.ccc.daca.backend.product.Product;

public class ProductResponse {

    private Boolean success;
    private String message;
    private int statusCode;
    private Product product;

    public ProductResponse(Boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public ProductResponse(Boolean success, String message, int statusCode) {
        this(success, message);
        this.statusCode = statusCode;
    }

    public ProductResponse(Boolean success, String message, int statusCode, Product product) {
        this(success, message, statusCode);
        this.product = product;
    }

    public Product getProduct() {return product;}

    public void setProduct(Product product) { this.product = product; }

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
