package blog.codingideas.algorithms.unionfind.practicequiz;

import blog.codingideas.algorithms.unionfind.QuickUnionWeighted;

public class QuickUnionWeightedWithTreesCountCheck extends QuickUnionWeighted {
    public QuickUnionWeightedWithTreesCountCheck(int numberOfElements) {
        super(numberOfElements);
    }

    public boolean structureHasSingleTree() {
        boolean hasSingleRoot = true;
        int root = rootOfElement(0);
        for (int i = 0; i < id.length; i++) {
            if (rootOfElement(i) != root) {
                hasSingleRoot = false;
            }
        }
        return hasSingleRoot;
    }
}
