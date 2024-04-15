import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import exercice03.ApiCallException;
import exercice03.Product;
import exercice03.ProductApiClient;
import exercice03.ProductService;
import org.junit.jupiter.api.Test;

import java.util.zip.DataFormatException;

public class ProductServiceTest {

    @Test
    public void testGetProduct_recuperationReussie() {
        ProductApiClient productApiClientMock = mock(ProductApiClient.class);
        when(productApiClientMock.getProduct("1")).thenReturn(new Product("1"));
        ProductService productService = new ProductService(productApiClientMock);
        Product product = productService.getProduct("1");

        verify(productApiClientMock).getProduct("1");
    }

    @Test
    public void testGetProduct_formatIncompatible() {
        // Arrange
        ProductApiClient productApiClientMock = mock(ProductApiClient.class);
        when(productApiClientMock.getProduct(anyString())).thenThrow(new RuntimeException(new DataFormatException("format de donnée incompatible")));
        ProductService productService = new ProductService(productApiClientMock);

        // Act & Assert
        assertThrows(RuntimeException.class, () -> productService.getProduct("2"));
    }


    @Test
    public void testGetProduct_echecsdeAPI() {
        // Arrange
        ProductApiClient productApiClientMock = mock(ProductApiClient.class);
        when(productApiClientMock.getProduct(anyString())).thenThrow(new RuntimeException(new ApiCallException("échecs d'appel d'API")));
        ProductService productService = new ProductService(productApiClientMock);

        // Act & Assert
        assertThrows(RuntimeException.class, () -> productService.getProduct("3"));
    }

}
