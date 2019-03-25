public class StringCaseChanger implements StringTransformer {

    private StringDrink drink;

    StringCaseChanger(StringDrink drink){
        this.drink = drink;
    }

    @Override
    public void execute() {
        String text = drink.getText();
        String newText = "";
        for(int i = 0; i < text.length(); i++){
            if(Character.isLowerCase(text.charAt(i))) {
                newText += Character.toUpperCase(text.charAt(i));
            }
            else{
                newText += Character.toLowerCase(text.charAt(i));
            }
        }
        drink.setText(newText);
    }

    @Override
    public void undo() {
        execute();
    }
}
