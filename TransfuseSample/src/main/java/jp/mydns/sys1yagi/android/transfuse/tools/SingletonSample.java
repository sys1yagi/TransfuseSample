package jp.mydns.sys1yagi.android.transfuse.tools;

import javax.inject.Singleton;


public class SingletonSample {

    @Singleton
    public static class SingletonCalculator {
        public int multi(int a, int b) {
            return a * b;
        }
    }

    public static class NonSingletonCalculator {
        public int multi(int a, int b) {
            return a * b;
        }
    }
}
