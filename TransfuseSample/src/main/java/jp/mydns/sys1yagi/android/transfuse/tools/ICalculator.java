package jp.mydns.sys1yagi.android.transfuse.tools;

import org.androidtransfuse.annotations.ImplementedBy;

@ImplementedBy(CalculatorImpl.class)
public interface ICalculator {
    public int add(int a, int b);
}
