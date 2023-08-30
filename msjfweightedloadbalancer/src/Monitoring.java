public class Monitoring {
    public static boolean isSLAAdhered(int responseTime, int slaThreshold) {
        return responseTime <= slaThreshold;
    }
}
