public class AreaStringOutputter {
    private SumProvider sumProvider;

    AreaStringOutputter(SumProvider sumProvider){
        this.sumProvider = sumProvider;
    }

    String output(){
        return "Sum of areas: " + this.sumProvider.sum();
    }
}
