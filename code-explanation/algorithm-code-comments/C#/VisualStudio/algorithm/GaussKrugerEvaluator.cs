namespace algorithm
{

    public class GaussKrugerEvaluator
    {
        private const double a = 6378137.0; 
        private const double f = 1 / 298.257223563; 
        private const double e2 = 2 * f - f * f;


        public double[] GaussKrugerToWGS84(double x, double y)
        {
            double lon0 = 15 * Math.PI / 180;
            double k0 = a / Math.Sqrt(1 - e2 * Math.Sin(lon0) * Math.Sin(lon0));

            double xi = x / k0;
            double eta = y / k0;

            double footpoint = lon0 + xi / Math.Cos(lon0);

            double rf = a * (1 - e2) / Math.Pow(1 - e2 * Math.Sin(footpoint) * Math.Sin(footpoint), 1.5);

            double lat = footpoint - (e2 * rf / k0) * eta * eta / 2;
            double lon = lon0 + eta / Math.Cos(footpoint);

            lat = lat * 180 / Math.PI;
            lon = lon * 180 / Math.PI;

            return new double[] { lat, lon };
        }
    }
}
