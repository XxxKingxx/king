public class Obstacle {
    private double distance;

    public Obstacle(double distance) {
        this.distance = distance;
    }

    public boolean isNear() {
        return distance < 1.6; // Distância de 1.6 metros
    }

    public double getDistance() {
        return distance;
    }
}