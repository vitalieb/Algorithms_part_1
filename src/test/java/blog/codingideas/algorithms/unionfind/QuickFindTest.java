package blog.codingideas.algorithms.unionfind;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static blog.codingideas.algorithms.unionfind.UnionFindCommon.testUnionFindImplementation;

@RunWith(JUnit4.class)
public class QuickFindTest {

    @Test
    public void test_algorithmWorks() {

        testUnionFindImplementation(new QuickFind(10));

    }


}
