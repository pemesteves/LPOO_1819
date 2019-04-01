public class File extends Node {
    private Folder parent;
    private String name;
    private int size;

    File(Folder parent, String name) throws DuplicateNameException{
        this(parent, name, 0);
    }

    File(Folder parent, String name, int size) throws DuplicateNameException {
        if(parent != null && parent.getChildByName(name) != null)
            throw new DuplicateNameException();

        this.parent = parent;
        this.name = name;
        this.size = size;

        if(this.parent != null)
            this.parent.add(this);
    }

    @Override
    public Folder getParent() {
        return this.parent;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public int getSize() {
        return size;
    }

    public String getPath(){
        return this.parent.getPath()+this.name;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;

        if(null == obj)
            return false;

        if(obj.getClass() != File.class)
            return false;

        File f = (File)obj;

        return this.name.equals(f.getName()) && this.size == f.getSize();
    }

    @Override
    public String toString() {
        return "("+this.name+","+this.size+")";
    }
}
