class Server {
    String name;
    int weight;
    int currentLoad;
    int responseTime;
    double energyConsumption;

    public Server(String name, int weight) {
        this.name = name;
        this.weight = weight;
        this.currentLoad = 0;
        this.responseTime = 0;
        this.energyConsumption = weight * 10.0; // Initial energy consumption estimation
    }
    public double estimateEnergyConsumption() {
        return weight * 10.0;
    }

    public void increaseLoad(int load) {
        currentLoad += load;
    }

    public int getCurrentLoad() {
        return currentLoad;
    }
    public boolean isSLAAdhered(int responseTime) {
        return responseTime <= 200;
    }

    public int calculateSlackTime() {
        return (weight - currentLoad);
    }
    public double calculateFitness() {
        // Calculate a combined fitness score based on slack time and energy efficiency
        return calculateSlackTime() / energyConsumption;
    }

    public void adjustWeight(int newWeight) {
        this.weight = newWeight;
    }

    public void updateResponseTime(int newResponseTime) {
        this.responseTime = newResponseTime;
    }
    
    public void updateEnergyConsumption(double newEnergyConsumption) {
        this.energyConsumption = newEnergyConsumption;
    }
}