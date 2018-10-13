package testing;

import com.veronika.Entity.TriangleUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TriangleUtilTest {

    private TriangleUtil triangleUtil;


    @Before
    public void init() {
        this.triangleUtil = new TriangleUtil();
    }

    @Test(expected = IllegalArgumentException.class)
    public void TriangleUtil_canCreateTriangle_AssertSidesCanNotBeEqualToZero() {
        this.triangleUtil.canCreateTriangle(0, 0, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void TriangleUtil_canCreateTriangle_AssertSidesCanNotBeLessThanZero() {
        this.triangleUtil.canCreateTriangle(-1, -1, -1);
    }

    @Test
    public void TriangleUtil_canCreateTriangle_AssertTrueWhenSidesAreValid() {
        Assert.assertTrue(this.triangleUtil.canCreateTriangle(3, 4, 6));
    }

    @Test
    public void TriangleUtil_canCreateTriangle_AssertFalseWhenSidesAreNotValid() {
        Assert.assertFalse(this.triangleUtil.canCreateTriangle(4, 3, 9));
    }

    @Test
    public void TriangleUtil_canCreateTriangle_AssertFalseWhenAPlusBEqualsC() {
        Assert.assertFalse(this.triangleUtil.canCreateTriangle(3, 4, 7));
    }

    @Test
    public void TriangleUtil_canCreateTriangle_AssertTrueWhenSidesAreEqualAndGreaterThanZero() {
        Assert.assertTrue(this.triangleUtil.canCreateTriangle(9, 9, 9));
    }

    @Test
    public void TriangleUtil_canCreateTriangle_AssertTrueWhenTriangleRight() {
        Assert.assertTrue(this.triangleUtil.canCreateTriangle(3, 4, 5));
    }

    @Test
    public void TriangleUtil_canCreateTriangle_AssertTrueWhenAEqulsBAndAPlusBMoreThanC() {
        Assert.assertTrue(this.triangleUtil.canCreateTriangle(3, 3, 5));
    }

    @Test
    public void TriangleUtil_canCreateTriangle_AssertFalseWhenAEqulsBAndAPlusBLessThanC() {
        Assert.assertFalse(this.triangleUtil.canCreateTriangle(2, 2, 5));
    }
}
