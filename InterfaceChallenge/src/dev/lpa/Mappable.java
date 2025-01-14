package dev.lpa;

public interface Mappable {

    String JSON_PROPERTY = """
            "property": {%s}""";

    String getLabel();
    Geometry getShape();
    String getMarker();
}
