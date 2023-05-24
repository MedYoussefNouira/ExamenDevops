package tn.esprit.spring;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//
//@SpringBootTest
//class ExamThourayaS2ApplicationTests {
//
//	@Test
//	void contextLoads() {
//	}
//
//}
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class YourClassNameTest {

    @Mock
    private VoyageurRepository voyageurRepository;

    @InjectMocks
    private YourClassName yourClass;

    @Test
    void testRecupererAll() {
        // Initialize mocks
        MockitoAnnotations.openMocks(this);

        // Create a list of mock Voyageur objects
        List<Voyageur> mockList = new ArrayList<>();
        mockList.add(new Voyageur("John Doe"));
        mockList.add(new Voyageur("Jane Smith"));

        // Set up the mock behavior
        when(voyageurRepository.findAll()).thenReturn(mockList);

        // Call the method to test
        List<Voyageur> result = yourClass.recupererAll();

        // Verify that voyageurRepository.findAll() was called
        verify(voyageurRepository).findAll();

        // Verify the expected output
        assertEquals(mockList, result);
    }
}