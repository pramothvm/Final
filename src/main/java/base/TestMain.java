package base;

//import org.junit.Test;
import org.junit.jupiter.api.Test;

public class TestMain {
    @Test
    public void testMeth(){
        int serviceProviderCode = (int)(Math.random() * (99 - 60) + 60);
        int threeDigitsNumber = (int)(Math.random() * (999 - 100) + 100);
        int fouDegitsNumber = (int)(Math.random() * (9999 - 1000) + 1000);

        String forMatedNumber = "0"+serviceProviderCode+" "+threeDigitsNumber+" "+fouDegitsNumber ;
        System.out.println(forMatedNumber);
    }
}
