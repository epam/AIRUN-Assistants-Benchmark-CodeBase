package com.epam.aicode.javacodeexplanation;


public final class GaussKrugerEvaluator {

    private GaussKrugerEvaluator() {
    }

    private static final double EQUATORIAL_RADIUS = 6378137.0; // in meters
    private static final double FLATTENING = 1.0 / 298.257223563;
    private static final double CENTRAL_MERIDIAN = Math.toRadians(15.0);
    private static final double SCALE_FACTOR = 0.9996;
    private static final double FALSE_EASTING = 500000.0;
    private static final double FALSE_NORTHING = 0.0;

    public static double[] toGaussKruger(double latitude, double longitude) {
        double phi = Math.toRadians(latitude);
        double lambda = Math.toRadians(longitude);
        double lambda0 = CENTRAL_MERIDIAN;
        double f = FLATTENING;
        double a = EQUATORIAL_RADIUS;
        double k0 = SCALE_FACTOR;
        double FE = FALSE_EASTING;
        double FN = FALSE_NORTHING;

        double e2 = f * (2.0 - f);
        double n = a / Math.sqrt(1.0 - e2 * Math.sin(phi) * Math.sin(phi));
        double rho = n * (1.0 - e2) / (1.0 - e2 * Math.sin(phi) * Math.sin(phi));
        double nu = n / Math.sqrt(1.0 - e2 * Math.sin(phi) * Math.sin(phi));
        double psi = nu / rho;
        double delta_lambda = lambda - lambda0;
        double xi_prim = Math.atan(Math.tan(phi) / Math.cos(delta_lambda));
        double eta_prim = Math.atan(Math.cos(phi) * Math.sin(delta_lambda) / Math.sqrt(1.0 - e2 * Math.sin(phi) * Math.sin(phi)));
        double x = k0 * rho * Math.sin(eta_prim);
        double y = k0 * (nu * xi_prim + (nu / 6.0) * Math.pow(Math.cos(phi), 3.0) * (psi - Math.pow(Math.tan(eta_prim), 2.0)) * Math.pow(Math.sin(xi_prim), 3.0));
        x += FE;
        y += FN;

        return new double[]{x, y};
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

        return new double[]{Math.toDegrees(phi), Math.toDegrees(lambda)};
    }
}
