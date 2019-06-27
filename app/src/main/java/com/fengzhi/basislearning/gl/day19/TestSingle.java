package com.fengzhi.basislearning.gl.day19;

public class TestSingle {
    private static TestSingle instance;

    public static TestSingle getInstance() {
        if (instance == null) {
            synchronized (TestSingle.class) {
                if (instance == null) {
                    instance = new TestSingle();
                }
            }
        }
        return instance;
    }
}
