public class AreaXMLOutputter {
    AreaAggregator areaAggre;
    AreaXMLOutputter(AreaAggregator areaAggre){
        this.areaAggre = areaAggre;
    }

    String output(){
       return "<area>" + areaAggre.sum() + "</area>";
    }
}
