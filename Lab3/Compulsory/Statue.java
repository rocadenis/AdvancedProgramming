package Lab3.Compulsory;

class Statue implements Visitable {
    private String name;

    public Statue(String name) {
        this.name = name;
    }

    @Override
    public void visit() {
        System.out.println("Visiting statue: " + name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
