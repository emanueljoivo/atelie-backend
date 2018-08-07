package br.edu.ufcg.ccc.daca.backend.product;

public enum ProductEndPoints {
    BASE_URL("https://api-assueria.herokuapp.com/v1"),
    PRODUCT_ALL(BASE_URL.url + "/product"),
    PRODUCT_ID(PRODUCT_ALL.url + "/{id}"),
    PRODUCT_SAVE(PRODUCT_ALL.url + "/new"),
    PRODUCT_SAVE_ALL(PRODUCT_ALL.url + "/save-all"),
    PRODUCT_UPDATE(PRODUCT_ALL.url + "/update"),
    PRODUCT_DELETE(PRODUCT_ALL.url + "/delete/{id}");

    private String url;

    ProductEndPoints(String url) {
        this.url = url;
    }
}