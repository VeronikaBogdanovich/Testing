package testing;

import com.veronika.entity.TriangleUtil;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(DataProviderRunner.class)
public class TriangleUtilTest {

    @DataProvider
    public static Object[][] triangleZeroSizes() {
        return new Object[][]{
                {0, 4, 5},
                {3, 0, 5},
                {3, 4, 0}
        };
    }

    @DataProvider
    public static Object[][] triangleNegativeSizes() {
        return new Object[][]{
                {-3, 4, 5},
                {3, -4, 5},
                {3, 4, -5}
        };
    }

    @DataProvider
    public static Object[][] sidesAreNotValid() {
        return new Object[][]{
                {13, 4, 5},
                {3, 14, 5},
                {3, 4, 15}
        };
    }

    @DataProvider
    public static Object[][] sidesAreValid() {
        return new Object[][]{
                {3, 4, 6},
                {3, 6, 5},
                {6, 4, 5}
        };
    }


    @Before
    public void init() {
        triangleUtil = new TriangleUtil();
    }

    @Test
    @UseDataProvider("triangleZeroSizes")
    public void assertFalseWhenOneSideIsZero(double a, double b, double c) {
        Assert.assertFalse(triangleUtil.canCreateTriangle(a, b, c));
    }

    @Test
    @UseDataProvider("triangleNegativeSizes")
    public void assertFalseWhenOneSideIsNegative(double a, double b, double c) {
        Assert.assertFalse(triangleUtil.canCreateTriangle(a, b, c));
    }

    @Test
    @UseDataProvider("sidesAreNotValid")
    public void assertTrueWhenSidesAreValid(double a, double b, double c) {
        Assert.assertTrue(triangleUtil.canCreateTriangle(a, b, c));
    }

    @Test
    @UseDataProvider("sidesAreNotValid")
    public void assertFalseWhenSidesAreNotValid(double a, double b, double c) {
        Assert.assertFalse(triangleUtil.canCreateTriangle(a, b, c));
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