public class User {

    private String name;

    User(String name){

        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;

        if(null == obj)
            return false;


        if(obj.getClass() != User.class)
            return false;

        User u = (User)obj;
        return this.name.equals(u.getName());
    }
}
