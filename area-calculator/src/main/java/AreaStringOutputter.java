public class AreaStringOutputter {
    private AreaAggregator areaAggre;

    AreaStringOutputter(AreaAggregator areaAggre){
        this.areaAggre = areaAggre;
    }

    String output(){
        return "Sum of areas: " + this.areaAggre.sum();
    }
}
