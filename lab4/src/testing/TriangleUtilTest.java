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

    @Test
    public void TriangleUtil_canCreateTriangle_AssertACanNotBeEqualToZero() {
        Assert.assertFalse(triangleUtil.canCreateTriangle(0, 1, 2));
    }

    @Test
    public void TriangleUtil_canCreateTriangle_AssertACanNotBeLessThanZero() {
        Assert.assertFalse(triangleUtil.canCreateTriangle(-1, 1, 2));
    }

    @Test
    public void TriangleUtil_canCreateTriangle_AssertBCanNotBeEqualToZero() {
        Assert.assertFalse(triangleUtil.canCreateTriangle(1, 0, 2));
    }

    @Test
    public void TriangleUtil_canCreateTriangle_AssertBCanNotBeLessThanZero() {
        Assert.assertFalse(triangleUtil.canCreateTriangle(1, -1, 2));
    }

    @Test
    public void TriangleUtil_canCreateTriangle_AssertCCanNotBeEqualToZero() {
        Assert.assertFalse(triangleUtil.canCreateTriangle(2, 1, 0));
    }

    @Test
    public void TriangleUtil_canCreateTriangle_AssertCCanNotBeLessThanZero() {
        Assert.assertFalse(triangleUtil.canCreateTriangle(1, 1, -2));
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