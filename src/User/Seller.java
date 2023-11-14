package User;

public class Seller extends User {
    private String companyName;
    private String companyAddress;

    public Seller(String username, String password, String email, String phone, String companyName, String companyAddress) {
        super(username, password, email, phone);
        this.companyName = companyName;
        this.companyAddress = companyAddress;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    
    

    @Override
    public void viewProfile() {
        //TODO
    
    }
    
}
    

