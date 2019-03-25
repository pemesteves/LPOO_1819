public class Withdrawal extends Movement{
    private double amount;

    Withdrawal(ATM atm, Session session, Card card, int ID){
        this.atm = atm;
        this.session = session;
        this.card = card;
        this.ID = ID;
        this.amount = 0;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Withdrawal at ATM "+this.atm.getID()+" ("+this.atm.getCity()+", "+this.atm.getBank()+") of "+this.amount+"0";
    }
}
