abstract class Transport {
    private String trackingId;
    private String destination;
    public Transport(String trackingId, String destination) {
        this.trackingId   = trackingId;
        this.destination  = destination;
    }

    public String getTrackingId()   { return trackingId; }
    public String getDestination() { return destination; }

    public abstract void dispatch();
}
interface GPS {
    String getCoordinates();

    default void pingServer() {
        System.out.println("Status: Online...");
    }
}

interface Autonomous{
    void selfnavigate();
}

abstract class DeliveryDrone extends Transport
        implements GPS, Autonomous {

    public DeliveryDrone(String trackingId) {
        super(trackingId, "Warehouse");
    }

    @Override
    public void dispatch() {
        System.out.println("Drone " + getTrackingId() + " taking off...");
    }

    @Override
    public String getCoordinates() {
        return "12.9716° N, 77.5946° E";
    }

    @Override
    public void selfNavigate() {
        System.out.println("Drone autopilot engaged.");
    }
}
class Truck extends Transport {
    public Truck(String trackingId) {
        super(trackingId, "Highway");
    }

    @Override
    public void dispatch() {
        System.out.println("Truck " + getTrackingId() + " departing...");
    }
}