package br.com.monteiro.filme.model;

import java.util.List;

public class Premio {

    private List<Produtor> min ;
    private List<Produtor> max;

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
