//import com.nal.junitmockito.CalculatorService;
//import com.nal.junitmockito.ServiceDependentCalculator;
//import org.junit.Before;
//import org.junit.Rule;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.MockitoAnnotations;
//import org.mockito.junit.MockitoJUnit;
//import org.mockito.junit.MockitoRule;
//import org.powermock.api.mockito.PowerMockito;
//import org.powermock.core.classloader.annotations.PrepareForTest;
//import org.powermock.modules.junit4.PowerMockRunner;
//import com.nal.junitmockito.util.Util;
//
//import static org.junit.Assert.assertEquals;
//
///**
// * Created by nishant on 4/11/19.
// */
//@RunWith(PowerMockRunner.class)
////@PrepareForTest(fullyQualifiedNames = "com.nal.junitmockito.util.*")
//public class ServiceDependentCalculatorTest2 {
//
//    CalculatorService calculatorService = PowerMockito.mock(CalculatorService.class);
//
//    @InjectMocks
//    ServiceDependentCalculator serviceDependentCalculator = null;
//
//
//
//
//
//    @Before
//    public void setUp() {
////        MockitoAnnotations.initMocks(Util.class);
//        serviceDependentCalculator = new ServiceDependentCalculator(calculatorService);
//    }
//
//    @Test
//    public void testMultiply() throws Exception {
////        String emailAddress = "dummy001@gmail.com";
////        PowerMockito.mockStatic(Util.class);
////        PowerMockito.when(Util.sendEmail(emailAddress)).thenReturn(true);
//
//        for (int k = 0; k < 4; k++) {
//            PowerMockito.when(calculatorService.add((3 * k), 3)).thenReturn((3 * k) + 3);
//        }
//        assertEquals(12, serviceDependentCalculator.multiply(3, 4));
//
//    }
//}