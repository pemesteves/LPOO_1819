public class StringReplacer implements StringTransformer {

    private StringDrink drink;
    private char old_char;
    private char new_char;

    StringReplacer(StringDrink drink, char old_char, char new_char){
        this.drink = drink;
        this.old_char = old_char;
        this.new_char = new_char;
    }

    @Override
    public void execute() {
        String text = this.drink.getText();
        text = text.replace(old_char, new_char);
        this.drink.setText(text);
    }
}
