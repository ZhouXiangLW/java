package com.cultivation.javaBasic.showYourIntelligence;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class StackFrameHelper {
    public static String getCurrentMethodName() {
        // TODO: please modify the following code to pass the test
        // <--start
        try {
            throw new Exception();
        } catch (Exception e)  {
            return e.getStackTrace()[1].getClassName() + "." + e.getStackTrace()[1].getMethodName();
        }
        // --end-->
    }
}
