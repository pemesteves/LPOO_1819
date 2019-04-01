import javax.naming.Name;
import java.util.ArrayList;
import java.util.List;

public class Folder extends Node{

    private String name;
    private Folder parent;
    private List<Node> child;
    private NameFormatter nameFormatter;

    Folder(){
        this(null, "");
    }

    Folder(Folder parent, String name){
        this.parent = parent;
        this.name = name;
        this.child = new ArrayList<>();
        if(this.parent != null)
            this.parent.add(this);

        this.nameFormatter = null;
    }


    public Folder getParent() {
        return this.parent;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public Node[] getChild(){
        Node[] childs = new Node[child.size()];
        int i = 0;
        for(Node node : child){
            childs[i] = node;
            i++;
        }

        return childs;
    }


    public void add(Node node){
        this.child.add(node);
    }

    public Node getChildByName(String name){
        for(Node node : child){
            if(node.getName().equals(name))
                return node;
        }

        return null;
    }

    public int getSize() {
        int size = 0;
        for(Node node : child){
            size += node.getSize();
        }
        return size;
    }

    public void setNameFormatter(NameFormatter nameFormatter){
        this.nameFormatter = nameFormatter;
        for(Node node : child){
            if(node.getClass() == Folder.class)
                ((Folder) node).setNameFormatter(nameFormatter);
        }
    }

    public String getPath(){
        if(this.parent == null)
            return this.name+this.nameFormatter.getSeparator();

        return this.parent.getPath()+this.name+this.nameFormatter.getSeparator();
    }


    public Folder clone(Folder parent, String name) throws DuplicateNameException {
        Folder f = new Folder(parent, name);

        for(Node node : child){
            Node n;

            if(node.getClass() == Folder.class){
                n = ((Folder) node).clone((Folder) node, node.getName());
            }
            else{
                n = new File(f, node.getName(), node.getSize());
            }

            f.add(n);
        }
        return f;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;

        if(null == obj)
            return false;

        if(obj.getClass() != Folder.class)
            return false;

        Folder f = (Folder)obj;

        if(this.name.equals(f.getName()))
            return false;

        if(this.child.size() != f.getChild().length)
            return false;

        for(Node node : this.child){
            if(f.getChildByName(node.getName()) == null)
                return false;
        }

        return true;
    }

    @Override
    public String toString() {
        String s = "("+this.name+",";
        for(Node node : child){
            s += child.toString();
        }

        return s+")";
    }
}
