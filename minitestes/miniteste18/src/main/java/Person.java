import java.util.Objects;

public abstract class Person implements Comparable, User, Cloneable{
    protected int age;
    protected String name;

    public String getName(){
        return this.name;
    }

    public int getAge(){
        return this.age;
    }

    public abstract String toString();

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;

        if(null == obj)
            return false;

        Person p = (Person)obj;

        return this.name.equals(p.getName());
    }

    @Override
    public int compareTo(Object o) {
        if(this.equals(o))
            return 0;

        return this.name.compareTo((String)o);
    }

    @Override
    public String getUsername() {
        return name+age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
