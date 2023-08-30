public class Client {
    public static void main(String[] args) {
        LoadBalancer loadBalancer = new LoadBalancer();
        double totalEnergyConsumption = 0;

        // Simulate multiple requests and dynamic weight adjustments
        for (int i = 0; i < 10; i++) {
            // Adjust server weights periodically
            loadBalancer.optimizeServerWeights();

            Server server = loadBalancer.getNextServer();
            System.out.println("Request " + (i + 1) + " routed to: " + server.name);

            // Simulate server response time
            int responseTime = (int) (Math.random() * 300);

            // Check if SLA is adhered
            if (server.isSLAAdhered(responseTime)) {
                server.increaseLoad(1);
                System.out.println("SLA Adhered for Request " + (i + 1));
            } else {
                server.increaseLoad(2); // Penalty for SLA violation
                System.out.println("SLA Not Adhered for Request " + (i + 1));
            }

            totalEnergyConsumption += server.estimateEnergyConsumption();
        }

        System.out.println("Total Energy Consumption: " + totalEnergyConsumption);
    }
}