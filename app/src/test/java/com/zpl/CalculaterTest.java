package com.zpl;

import com.zpl.test.Calculater;

import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CalculaterTest {
    Calculater calculater = new Calculater();

    @Test
    public void testAdd() {
        int a = 1;
        int b = 2;

        int result = calculater.add(a, b);

        Assert.assertEquals(result, 3); // 验证result==3，如果不正确，测试不通过
    }

    @org.junit.Test
    public void testAdd2() {
        calculater = mock(Calculater.class);

        calculater.add(1, 2);

        verify(calculater).add(1, 2); // 验证calculater.add(a, b)是否被调用过，且a==1 && b==2
        // 测试通过
    }
}
