public class ATM {
    private final int id;
    private final String city;
    private final String bank;

    ATM(int ID, String city, String bank){
        id = ID;
        this.city = city;
        this.bank = bank;
    }

    public int getID() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public String getBank() {
        return bank;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;

        if(null == obj)
            return false;

        if(obj.getClass() != ATM.class)
            return false;

        ATM a = (ATM)obj;

        return this.id == a.getID() && this.city.equals(a.getCity()) && this.bank.equals(a.getBank());
    }
}
