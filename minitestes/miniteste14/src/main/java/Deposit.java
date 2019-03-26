public class Deposit extends Movement{

    Deposit(ATM atm, Session session, Card card, int ID){
        this.atm = atm;
        this.session = session;
        this.card = card;
        this.ID = ID;
    }
}
