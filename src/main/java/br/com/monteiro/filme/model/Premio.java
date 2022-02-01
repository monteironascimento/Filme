package br.com.monteiro.filme.model;

import java.util.List;

public class Premio {

    private List<ProdutorMinView> min ;
    private List<ProdutorMaxView> max;

    public List<ProdutorMaxView> getMax() {
        return max;
    }
    public List<ProdutorMinView> getMin() {
        return min;
    }
    public void setMax(List<ProdutorMaxView> maxList) {
        this.max = maxList;
    }
    public void setMin(List<ProdutorMinView> minList) {
        this.min = minList;
    }
        
}
