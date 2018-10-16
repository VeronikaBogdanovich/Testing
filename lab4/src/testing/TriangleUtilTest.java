package testing;

import com.veronika.entity.TriangleUtil;
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
    public void assertThatACanNotBeEqualToZero() {
        this.triangleUtil.canCreateTriangle(0, 1, 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void assertThatACanNotBeLessThanZero() {
        this.triangleUtil.canCreateTriangle(-1, 1, 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void assertThatBCanNotBeEqualToZero() {
        this.triangleUtil.canCreateTriangle(1, 0, 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void assertThatBCanNotBeLessThanZero() {
        this.triangleUtil.canCreateTriangle(1, -1, 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void assertThatCCanNotBeEqualToZero() {
        this.triangleUtil.canCreateTriangle(2, 1, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void assertThatCCanNotBeLessThanZero() {
        this.triangleUtil.canCreateTriangle(1, 1, -2);
    }

    @Test
    public void assertTrueWhenSidesAreValid() {
        Assert.assertTrue(this.triangleUtil.canCreateTriangle(3, 4, 6));
    }

    @Test
    public void assertFalseWhenSidesAreNotValid() {
        Assert.assertFalse(this.triangleUtil.canCreateTriangle(4, 3, 9));
    }

    @Test
    public void assertFalseWhenAPlusBEqualsC() {
        Assert.assertFalse(this.triangleUtil.canCreateTriangle(3, 4, 7));
    }

    @Test
    public void assertTrueWhenSidesAreEqualAndGreaterThanZero() {
        Assert.assertTrue(this.triangleUtil.canCreateTriangle(9, 9, 9));
    }

    @Test
    public void assertTrueWhenTriangleRight() {
        Assert.assertTrue(this.triangleUtil.canCreateTriangle(3, 4, 5));
    }

    @Test
    public void assertTrueWhenAEqulsBAndAPlusBMoreThanC() {
        Assert.assertTrue(this.triangleUtil.canCreateTriangle(3, 3, 5));
    }

    @Test
    public void assertFalseWhenAEqulsBAndAPlusBLessThanC() {
        Assert.assertFalse(this.triangleUtil.canCreateTriangle(2, 2, 5));
    }
}
