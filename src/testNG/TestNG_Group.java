package testNG;

import org.testng.annotations.*;

public class TestNG_Group extends TestNG_Suite {

    @Test(groups = {"iphone", "FaceID"})
    public void testIponeX(){
        System.out.println("testIponeX Test");
    }

    @Test(groups = {"iphone", "FaceID"})
    public void testiPhone11(){
        System.out.println("testiPhone11 method");
    }

    @Test(groups = {"iphone", "TouchID"})
    public void testiPhone8Plus(){
        System.out.println("testiPhone8Plus method");
    }

    @Test(groups = {"iphone", "TouchID"})
    public void testiPhone7Plus(){
        System.out.println("testiPhone7Plus method");
    }

    @Test(groups = {"android", "S_Series"})
    public void testSamsungS20(){
        System.out.println("testSamsungS20 method");
    }

    @Test(groups = {"android", "N_Series"})
    public void testSamsungNote10(){
        System.out.println("testSamsungNote10 method");
    }

    @Test(groups = {"android", "A_Series"})
    public void testSamsungA20(){
        System.out.println("testSamsungA20 method");
    }

    @Test(groups = {"android", "FaceID"})
    public void testFaceID(){
        System.out.println("FaceID test method");
    }
}
