import java.util.ArrayList;
import java.util.List;

public class SmartStrategy implements OrderingStrategy {

    List<StringRecipe> recipeList;

    SmartStrategy(){
        recipeList = new ArrayList<>();
    }

    @Override
    public void wants(StringRecipe recipe, StringBar bar) {
        if(bar.isHappyHour())
            bar.order(recipe);
        else
            recipeList.add(recipe);
    }

    @Override
    public void happyHourStarted(StringBar bar) {
        for(StringRecipe recipe : recipeList)
            bar.order(recipe);
    }

    @Override
    public void happyHourEnded(StringBar bar) {

    }
}
