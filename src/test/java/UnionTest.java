import union.Union;
import org.junit.Assert;
import org.junit.Test;

public class UnionTest {

    @Test
    public void UnionMethods(){
        final int SIZE = 10;
        Union union = new Union(SIZE);
        //tests count() and Union constructor
        Assert.assertEquals(union.count(), SIZE);
        //point 1 to 2
        union.union(1,2);
        Assert.assertEquals(union.nodeDepth(1), 2);
        union.union(3,1);
        Assert.assertEquals(union.nodeDepth(3), 3);
        union.union(1,4);
        Assert.assertNotEquals(union.nodeDepth(1), 3);

        Union union2 = new Union(SIZE);

        int i = SIZE - 1;
        while(i > 0) {
            union2.union(i, i-1);
            i--;
        }
        //setting a string of nodes
        Assert.assertEquals(union2.nodeDepth(9), 10);

        //won't set since same tree
        Assert.assertFalse(union2.union(5,3));
    }
}
