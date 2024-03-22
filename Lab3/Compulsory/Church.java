package Lab3.Compulsory;

class Church implements Visitable, Payable {
    private String name;
    private double entranceFee;

    public Church(String name, double entranceFee) {
        this.name = name;
        this.entranceFee = entranceFee;
    }

    @Override
    public void visit() {
        System.out.println("Biserica vizitata: " + name);
    }

    @Override
    public double getEntranceFee() {
        return entranceFee;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public void setEntranceFee(double entranceFee) {
        this.entranceFee = entranceFee;
    }
}
