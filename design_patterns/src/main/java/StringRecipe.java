import java.util.List;

public class StringRecipe {

    private List<StringTransformer> transformerList;

    StringRecipe(List<StringTransformer> transformerList){
        this.transformerList = transformerList;
    }

    public void mix(){
        for(StringTransformer stringTransformer : transformerList){
            stringTransformer.execute();
        }
    }
}
