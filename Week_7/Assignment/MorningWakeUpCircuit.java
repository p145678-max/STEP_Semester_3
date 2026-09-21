class AlarmClock implements Ringable { private String time; public AlarmClock(String time){this.time=time;} public String ring(){return "Alarm ringing for "+time;} }

class Circuit { public static void ringAll(Ringable[] devices){for(Ringable device:devices)System.out.println(device.ring());} }

class Doorbell implements Ringable { private String location; public Doorbell(String location){this.location=location;} public String ring(){return "Doorbell ringing at "+location;} }

interface Ringable { String ring(); }

public class MorningWakeUpCircuit {
    public static void main(String[] args) {
        Ringable[] devices = { new AlarmClock("7:00 AM"), new Doorbell("Front Door") }; Circuit.ringAll(devices);
    }
}