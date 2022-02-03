package br.com.monteiro.filme.model;

import java.util.ArrayList;
import java.util.List;

public class PremioView {

    private List<Produtor> min = new ArrayList<Produtor>();
    private List<Produtor> max = new ArrayList<Produtor>();

    public List<Produtor> getMax() {
        return max;
    }
    public List<Produtor> getMin() {
        return min;
    }
    public void setMax(List<Produtor> maxList) {
        this.max = maxList;
    }
    public void setMin(List<Produtor> minList) {
        this.min = minList;
    }
        
}
