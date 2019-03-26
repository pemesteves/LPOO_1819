import javax.naming.Name;

public class FileSystem {
    private String type;
    private Folder root;
    private NameFormatter nameFormatter;

    public FileSystem(String type) {
        this.type = type;
        this.root = null;
        this.nameFormatter = null;
    }


    public String getType() {
        return this.type;
    }

    public Folder getRoot() {
        if(this.root == null)
            this.root = new Folder();

        this.root.setNameFormatter(this.nameFormatter);

        return this.root;
    }

    public void setNameFormatter(NameFormatter nameFormatter){
        this.nameFormatter = nameFormatter;
        this.root.setNameFormatter(nameFormatter);
    }
}
