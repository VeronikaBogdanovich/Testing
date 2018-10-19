package testing;

import com.veronika.entity.TriangleUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TriangleUtilTest {

    private TriangleUtil triangleUtil;


    @Before
    public void init() {
        triangleUtil = new TriangleUtil();
    }

    @DataProvider
    public static Object[][] triangleZeroSides() {
        return new Object[][]{
                {0, 1, 2},
                {1, 0, 2},
                {1, 2, 0}
        };
    }

    @DataProvider
    public static Object[][] triangleNegativeSides() {
        return new Object[][]{
                {-1, 1, 2},
                {1, -1, 2},
                {1, 2, -1}
        };
    }

	@Test(dataProvider = "triangleZeroSides")
    public void canNotBiuldTriangleWhenAnySideEqualsToZero(int a, int b, int c) {
        TriangleUtil triangle = new TriangleUtil(a, b, c);

        boolean assertException = TriangleValidation.canBuildTriangle(triangle);
    }

    @Test(dataProvider = "triangleNegativeSides")
    public void canNotBiuldTriangleWhenAnyOfSidesLessThanZero(int a, int b, int c) {
        TriangleUtil triangle = new TriangleUtil(a, b, c);

        boolean assertException = TriangleValidation.canBuildTriangle(triangle);
    }

    @Test
    public void assertTrueWhenSidesAreValid() {
        Assert.assertTrue(triangleUtil.canCreateTriangle(3, 4, 6));
    }

    @Test
    public void assertFalseWhenSidesAreNotValid() {
        Assert.assertFalse(triangleUtil.canCreateTriangle(4, 3, 9));
    }

    @Test
    public void assertFalseWhenAPlusBEqualsC() {
        Assert.assertFalse(triangleUtil.canCreateTriangle(3, 4, 7));
    }

    @Test
    public void assertTrueWhenSidesAreEqualAndGreaterThanZero() {
        Assert.assertTrue(triangleUtil.canCreateTriangle(9, 9, 9));
    }

    @Test
    public void assertTrueWhenTriangleRight() {
        Assert.assertTrue(triangleUtil.canCreateTriangle(3, 4, 5));
    }

    @Test
    public void assertTrueWhenAEqulsBAndAPlusBMoreThanC() {
        Assert.assertTrue(triangleUtil.canCreateTriangle(3, 3, 5));
    }

    @Test
    public void assertFalseWhenAEqulsBAndAPlusBLessThanC() {
        Assert.assertFalse(triangleUtil.canCreateTriangle(2, 2, 5));
    }
}
