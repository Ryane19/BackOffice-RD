package ControllerTest;

import com.example.api.controllers.BilletController;
import com.example.api.model.Billet;
import com.example.api.repository.BilletRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class BilletControllerTest {

    @Mock
    private BilletRepository billetRepository;

    @InjectMocks
    private BilletController billetController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllBillets() {
        // Mock data
        Billet billet1 = new Billet("Match", "VIP", 150.0);
        Billet billet2 = new Billet("Concert", "Standard", 75.0);
        List<Billet> billetList = Arrays.asList(billet1, billet2);

        // Mock repository method
        when(billetRepository.findAll()).thenReturn(billetList);

        // Call controller method
        ResponseEntity<List<Billet>> response = billetController.getAllBillets();

         //Verify the response
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(2, response.getBody().size());
        assertEquals(billet1, response.getBody().get(0));
        assertEquals(billet2, response.getBody().get(1));
    }
}
