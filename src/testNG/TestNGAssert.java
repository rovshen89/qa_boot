package testNG;

import org.testng.Assert;
import org.testng.annotations.Test;
import appCode.*;
import org.testng.asserts.SoftAssert;

public class TestNGAssert {

    AppCode atest = new AppCode();

    @Test
    public void testSum(){
        int res;
        //SoftAssert class
        SoftAssert sa = new SoftAssert();

        res = atest.sumInt(1,2);
        //Assert.assertEquals(res, 3, "Sum mismatch");
        sa.assertEquals(res, 3, "Sum mismatch");
        System.out.println("First assertion complete");

        //Assert.assertEquals(res, 5, "Sum mismatch");
        sa.assertEquals(res, 5, "Sum mismatch");

        System.out.println("Second assertion complete");

        sa.assertAll("After all assertions");

    }

    @Test
    public void testString(){
        //Assert
        String res = atest.concatString("Rovshen", "Nurybayev");
        Assert.assertEquals(res, "Rovshen_Nurybayev", "String mismatch");
        System.out.println("Test String method");
    }

    @Test
    public void testArray(){
        int[] arrRes = {1,2,3,5};
        int[] arrAct = atest.getArray();
        Assert.assertEquals(arrAct, arrRes, "Array mismatch");
        System.out.println("Array method");
    }
}
