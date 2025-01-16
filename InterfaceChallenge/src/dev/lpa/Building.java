package dev.lpa;

enum UsageType {ENTERTAINMENT, GOVERNMENT, RESIDENTIAL, SPORTS }

public class Building implements Mappable{

    private String name;
    private UsageType usage;

    public Building(String name, UsageType usage) {
        this.name = name;
        this.usage = usage;
    }

    @Override
    public String getLabel() {
        return name + " (" +usage +")";
    }

    @Override
    public Geometry getShape() {
        return Geometry.POINT;
    }

    @Override
    public String getMarker() {
        return "";
    }
}
