class Invoice implements Printable { private String invoiceNumber; public Invoice(String invoiceNumber){this.invoiceNumber=invoiceNumber;} public String printLabel(){return "Invoice label: "+invoiceNumber;} }

class PackageBox implements Printable { private String trackingId; public PackageBox(String trackingId){this.trackingId=trackingId;} public String printLabel(){return "Package label: "+trackingId;} }

interface Printable { String printLabel(); }

class Printer { public static void printAll(Printable[] items){for(Printable item:items)System.out.println(item.printLabel());} }

public class WarehouseLabelPrinter {
    public static void main(String[] args) {
        Printable[] items = { new PackageBox("TRK-88"), new Invoice("INV-21") }; Printer.printAll(items);
    }
}