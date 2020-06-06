package testNG;

import org.testng.Assert;
import org.testng.annotations.Test;
import appCode.*;

public class TestNGAssert {

    AppCode atest = new AppCode();

    @Test
    public void testSum(){
        int res = atest.sumInt(1,2);
        Assert.assertEquals(res, 3, "Sum mismatch");
        System.out.println("Base Test");
    }

    @Test
    public void test1(){
        System.out.println("Test1 method");
    }

    @Test
    public void test2(){
        System.out.println("Test2 method");
    }
}
