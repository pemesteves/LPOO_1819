import java.util.List;

public class StringTransformerGroup implements StringTransformer{

    private List<StringTransformer> transformerList;

    StringTransformerGroup(List<StringTransformer> transformerList){
        this.transformerList = transformerList;
    }

    public void execute(){
        for(StringTransformer transformer : transformerList){
            transformer.execute();
        }
    }

    @Override
    public void undo() {
        for(StringTransformer transformer : transformerList){
            transformer.undo();
        }
    }
}
