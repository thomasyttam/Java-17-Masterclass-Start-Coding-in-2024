package dev.lpa;

import java.util.List;

public class Layer <T extends Mappable>{

    private List<T> layerElements;

    public Layer(List<T> layerElements) {
        this.layerElements = layerElements;
    }
}
