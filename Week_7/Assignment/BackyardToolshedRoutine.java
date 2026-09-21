class CuttingTool extends GardenTool {
    public CuttingTool() { super(); }
    @Override
    public String use() { return super.baseUse() + ", blade sharpened first"; }
}

abstract class GardenTool {
    public GardenTool() { }
    protected String baseUse() { return "Using the tool in the garden"; }
    public abstract String use();
}

class Pruner extends CuttingTool {
    public Pruner() { super(); }
    @Override
    public String use() { return super.use() + ", then trimming branches precisely"; }
}

public class BackyardToolshedRoutine {
    public static void main(String[] args) {
        System.out.println(new CuttingTool().use()); System.out.println(new Pruner().use());
    }
}