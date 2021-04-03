package srp;

public class AlturaTriangulo {
    public static double dameAltura(double l1,double l2,double base) {
        return Math.sqrt(l1 * l2 - ((base/2)* (base/2)));
    }
}
