import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
class LoadBalancer {
    private List<Server> servers;
    private int currentIndex;

    public LoadBalancer() {
        servers = new ArrayList<>();
        currentIndex = 0;

        // Add servers with initial weights
        servers.add(new Server("Server1", 3));
        servers.add(new Server("Server2", 4));
        servers.add(new Server("Server3", 7));
    }

    public Server getNextServer() {
        // Implement MSJF (Minimum Slack Job First) algorithm
        Server selectedServer = servers.stream()
                .min(Comparator.comparingInt(Server::calculateSlackTime))
                .orElse(null);
        if (selectedServer != null) {
            selectedServer.increaseLoad(1); // Increase load for the selected server
            return selectedServer;
        }

        return null;
    }

    public void optimizeServerWeights() {
        // Periodically adjust server weights based on response times and energy consumption
        for (Server server : servers) {
            // Simulate periodic evaluation and weight adjustment
            int newResponseTime = (int) (Math.random() * 300);
            double newEnergyConsumption = server.estimateEnergyConsumption() * (1.0 - (newResponseTime / 300.0));
            
            server.updateResponseTime(newResponseTime);
            server.updateEnergyConsumption(newEnergyConsumption);
            
            // Adjust server weights based on response times and energy consumption
            int adjustedWeight = (int) (server.weight * (1.0 / (1.0 + (newResponseTime / 300.0))));
            server.adjustWeight(adjustedWeight);
        }
    }
}