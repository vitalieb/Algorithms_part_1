package blog.codingideas.algorithms.unionfind;

import org.junit.Assert;

class UnionFindCommon {


    static void testUnionFindImplementation(UnionFind unionFind) {
        System.out.println("\n" + unionFind.getClass().getSimpleName() + ":");
        unionFind.displayIdArray();
        Assert.assertFalse(unionFind.connected(7, 2));
        unionFind.union(7, 2);  // 1
        unionFind.displayIdArray();
        Assert.assertTrue(unionFind.connected(7, 2));
        Assert.assertFalse(unionFind.connected(9, 2));
        unionFind.union(9, 7);  // 2
        unionFind.displayIdArray();
        Assert.assertTrue(unionFind.connected(9, 2));
        unionFind.union(8, 9);  // 3
        unionFind.displayIdArray();
        Assert.assertTrue(unionFind.connected(8, 7));
        unionFind.union(4, 3);  // 4
        unionFind.displayIdArray();
        Assert.assertFalse(unionFind.connected(4, 7));
        unionFind.union(4, 9);  // 5
        unionFind.displayIdArray();
        Assert.assertTrue(unionFind.connected(4, 8));
        Assert.assertTrue(unionFind.connected(4, 2));
    }

}
