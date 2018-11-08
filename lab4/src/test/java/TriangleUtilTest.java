import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(DataProviderRunner.class)
public class TriangleUtilTest {

    @DataProvider
    public static Object[][] triangleZeroSizes() {
        return new Object[][]{
                {0, 1, 2},
                {1, 0, 2},
                {3, 2, 0}
        };
    }

    @DataProvider
    public static Object[][] triangleNegativeSizes() {
        return new Object[][]{
                {-1, 2, 3},
                {1, -2, 3},
                {1, 2, -3}
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

    @Test
    @UseDataProvider("triangleZeroSizes")
    public void assertFalseWhenOneSideIsZero(double a, double b, double c) {
        Assert.assertFalse(TriangleUtil.canCreateTriangle(new TriangleUtil(a, b, c)));
    }

    @Test
    @UseDataProvider("triangleNegativeSizes")
    public void assertFalseWhenOneSideIsNegative(double a, double b, double c) {
        Assert.assertFalse(TriangleUtil.canCreateTriangle(new TriangleUtil(a, b, c)));
    }

    @Test
    @UseDataProvider("sidesAreNotValid")
    public void assertFalseWhenSidesAreValid(double a, double b, double c) {
        Assert.assertFalse(TriangleUtil.canCreateTriangle(new TriangleUtil(a, b, c)));
    }

    @Test
    @UseDataProvider("sidesAreNotValid")
    public void assertFalseWhenSidesAreNotValid(double a, double b, double c) {
        Assert.assertFalse(TriangleUtil.canCreateTriangle(new TriangleUtil(a, b, c)));
    }

    @Test
    public void assertFalseWhenAPlusBEqualsC() {
        Assert.assertFalse(TriangleUtil.canCreateTriangle(new TriangleUtil(3, 4, 7)));
    }

    @Test
    public void assertTrueWhenSidesAreEqualAndGreaterThanZero() {
        Assert.assertTrue(TriangleUtil.canCreateTriangle(new TriangleUtil(9, 9, 9)));
    }

    @Test
    public void assertTrueWhenTriangleRight() {
        Assert.assertTrue(TriangleUtil.canCreateTriangle(new TriangleUtil(3, 4, 5)));
    }

    @Test
    public void assertTrueWhenAEqualsBAndAPlusBMoreThanC() {
        Assert.assertTrue(TriangleUtil.canCreateTriangle(new TriangleUtil(3, 3, 5)));
    }

    @Test
    public void assertFalseWhenAEqulsBAndAPlusBLessThanC() {
        Assert.assertFalse(TriangleUtil.canCreateTriangle(new TriangleUtil(2, 2, 5)));
    }
}