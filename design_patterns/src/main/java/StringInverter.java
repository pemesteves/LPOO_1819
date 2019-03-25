public class StringInverter implements StringTransformer {

    private StringDrink drink;

    StringInverter(StringDrink drink){
        this.drink = drink;
    }

    @Override
    public void execute() {
        StringBuffer text = new StringBuffer(this.drink.getText());
        text.reverse();
        this.drink.setText(text.toString());
    }

    @Override
    public void undo() {
        execute();
    }
}
