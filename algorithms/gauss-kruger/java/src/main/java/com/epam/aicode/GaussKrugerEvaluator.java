package com.epam.aicode;

public class GaussKrugerEvaluator {

    private static final double EQUATORIAL_RADIUS = 6378137.0; // in meters
    private static final double FLATTENING = 1.0 / 298.257223563;
    private static final double CENTRAL_MERIDIAN = Math.toRadians(15.0);
    private static final double SCALE_FACTOR = 0.9996;
    private static final double FALSE_EASTING = 500000.0;
    private static final double FALSE_NORTHING = 0.0;

    public static void main(String[] args) {
        double latitude = 52.5167;
        double longitude = 13.3833;

        double[] xy = toGaussKruger(latitude, longitude);
        System.out.println("Easting: " + xy[0] + " meters");
        System.out.println("Northing: " + xy[1] + " meters");

        double[] latlon = fromGaussKruger(xy[0], xy[1]);
        System.out.println("Latitude: " + latlon[0] + " degrees");
        System.out.println("Longitude: " + latlon[1] + " degrees");
    }

    public static double[] fromGaussKruger(double x, double y) {
        double lambda0 = CENTRAL_MERIDIAN;
        double f = FLATTENING;
        double a = EQUATORIAL_RADIUS;
        double k0 = SCALE_FACTOR;
        double FE = FALSE_EASTING;
        double FN = FALSE_NORTHING;

        double e2 = f * (2.0 - f);
        double n = a / Math.sqrt(1.0 - e2 * Math.sin(Math.toRadians(52.0)) * Math.sin(Math.toRadians(52.0)));
        double rho = Math.sqrt(Math.pow(x - FE, 2.0) + Math.pow(y - FN, 2.0)) / k0;
        double nu = rho / (1.0 - e2 / 4.0 - 3.0 * e2 * e2 / 64.0 - 5.0 * e2 * e2 * e2 / 256.0);
        double eta = y / (k0 * nu);
        double xi = (x - FE) / (k0 * nu);
        double xi_prim = xi - (Math.sin(2.0 * xi) / 2.0) * (Math.cosh(2.0 * eta) + Math.cos(2.0 * xi) * Math.sinh(2.0 * eta));
        double eta_prim = eta - (Math.cos(2.0 * xi) * Math.sinh(2.0 * eta) - Math.sin(2.0 * xi) * Math.cosh(2.0 * eta)) / 2.0;
        double phi = Math.asin(Math.sin(xi_prim) / Math.cosh(eta_prim));
        double delta_lambda = Math.atan(Math.sinh(eta_prim) / Math.cos(xi_prim));
        double lambda = lambda0 + delta_lambda;

        return new double[] {Math.toDegrees(phi), Math.toDegrees(lambda)};
    }
}