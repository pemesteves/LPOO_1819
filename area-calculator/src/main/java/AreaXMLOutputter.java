public class AreaXMLOutputter {
    SumProvider sumProvider;
    AreaXMLOutputter(SumProvider sumProvider){
        this.sumProvider = sumProvider;
    }

    String output(){
       return "<area>" + sumProvider.sum() + "</area>";
    }
}
