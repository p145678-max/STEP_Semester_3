abstract class DeliveryNote {
    public DeliveryNote(){}
    public abstract String confirmDelivery();
    public String confirmDelivery(String signature){return confirmDelivery()+", signed by "+signature;}
}

class LetterNote extends DeliveryNote { private String trackingId; public LetterNote(String trackingId){this.trackingId=trackingId;} @Override public String confirmDelivery(){return "Letter "+trackingId+" delivered";} }

class Log { public static void logAll(DeliveryNote[] notes){for(DeliveryNote note:notes)System.out.println(note.confirmDelivery());} }

class ParcelNote extends DeliveryNote { private String trackingId; public ParcelNote(String trackingId){this.trackingId=trackingId;} @Override public String confirmDelivery(){return "Parcel "+trackingId+" delivered";} }

public class PackageDropOffLog {
    public static void main(String[] args) {
        DeliveryNote[] notes = { new LetterNote("LT-1"), new ParcelNote("PR-1") }; Log.logAll(notes);
    }
}