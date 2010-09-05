/*
 * Copyright 2008-2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.test.more.classcode;
import java.lang.reflect.Method;
import org.junit.Test;
import org.more.core.classcode.AopBeforeListener;
import org.more.core.classcode.AopFilterChain;
import org.more.core.classcode.AopInvokeFilter;
import org.more.core.classcode.AopReturningListener;
import org.more.core.classcode.AopThrowingListener;
import org.more.core.classcode.ClassEngine;
/**
 *
 * @version 2010-8-25
 * @author ������ (zyc@byshell.org)
 */
public class AopTest {
    @Test
    public void test_1() throws Exception {
        ClassEngine ce = new ClassEngine(AopTest.class);
        ce.addListener(new Test_BeforeListener());
        ce.addListener(new Test_ReturningListener());
        ce.addListener(new Test_ThrowingListener());
        ce.addAopFilter(new Test_Filter(1));
        ce.addAopFilter(new Test_Filter(2));
        //
        AopTest obj = (AopTest) ce.newInstance(null);
        obj.print();
    };
    public void print() {
        System.out.println("print method");
    }
}
class Test_Filter implements AopInvokeFilter {
    private int i = 0;
    public Test_Filter(int i) {
        this.i = i;
    }
    public Object doFilter(Object target, Method method, Object[] args, AopFilterChain chain) throws Throwable {
        System.out.println(i);
        return chain.doInvokeFilter(target, method, args);
    }
}
class Test_BeforeListener implements AopBeforeListener {
    public void beforeInvoke(Object target, Method method, Object[] args) {
        System.out.println("beforeInvoke");
    }
}
class Test_ReturningListener implements AopReturningListener {
    public void returningInvoke(Object target, Method method, Object[] args, Object result) {
        System.out.println("returningListener");
    }
}
class Test_ThrowingListener implements AopThrowingListener {
    public void throwsException(Object target, Method method, Object[] args, Throwable e) {
        System.out.println("throwingListener");
    }
}