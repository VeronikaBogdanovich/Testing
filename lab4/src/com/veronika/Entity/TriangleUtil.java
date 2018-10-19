package com.veronika.entity;

public class TriangleUtil {

    public boolean canCreateTriangle(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            return false;
        }

        return a + b > c && b + c > a && a + c > b;
    }
}
