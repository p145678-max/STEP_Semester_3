class DeliveryDrone extends Drone implements Trackable { private String id; public DeliveryDrone(String id){this.id=id;} public String fly(){return id+" flying";} public String getLocation(){return id+" at Sector 4";} }

abstract class Drone { public Drone(){} public abstract String fly(); }

class Fleet { public static String getLocationIfTrackable(Object o){if(o instanceof Trackable){Trackable t=(Trackable)o;return t.getLocation();}return "Tracking not available";} }

class GroundRobot implements Trackable { private String id; public GroundRobot(String id){this.id=id;} public String getLocation(){return id+" at Sector 4";} }

class ScoutDrone extends Drone { private String id; public ScoutDrone(String id){this.id=id;} public String fly(){return id+" scouting";} }

interface Trackable { String getLocation(); }

public class SkylineDeliveryFleet {
    public static void main(String[] args) {
        System.out.println(Fleet.getLocationIfTrackable(new DeliveryDrone("DR-1"))); System.out.println(Fleet.getLocationIfTrackable(new ScoutDrone("SC-1"))); System.out.println(Fleet.getLocationIfTrackable(new GroundRobot("GR-1")));
    }
}