package exercice03;

public class ProductService {
    private final ProductApiClient productApiClient;

    public ProductService(ProductApiClient productApiClient) {
        this.productApiClient = productApiClient;
    }

    public Product getProduct(String productId) {
        try {
            return productApiClient.getProduct(productId);
        } catch (Exception e) {
            // Gérer l'exception ici
            return null; // Retourner null ou jeter une autre exception selon votre logique
        }
    }
}


