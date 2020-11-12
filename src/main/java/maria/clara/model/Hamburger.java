package maria.clara.model;

public class Hamburger extends SavoryEdible {
    private boolean celiac;
    private boolean diabetic;
    private boolean wholemeal;

    public boolean isCeliac() {
        return celiac;
    }

    public void setCeliac(boolean celiac) {
        this.celiac = celiac;
    }

    public boolean isDiabetic() {
        return diabetic;
    }

    public void setDiabetic(boolean diabetic) {
        this.diabetic = diabetic;
    }

    public boolean isWholemeal() {
        return wholemeal;
    }

    public void setWholemeal(boolean wholemeal) {
        this.wholemeal = wholemeal;
    }

    public Hamburger(boolean celiac, boolean diabetic, boolean wholemeal, double price, String flavor) {
        this.celiac = celiac;
        this.diabetic = diabetic;
        this.wholemeal = wholemeal;
        this.price = price;
        this.flavor = flavor;
    }
}
