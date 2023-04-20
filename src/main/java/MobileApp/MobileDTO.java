package MobileApp;

public class MobileDTO {

    private int mobileNo;
    private String modelName;
    private String Company;
    private int ram;
    private int camera;
    private double price;


    public MobileDTO(int mobileNo, String modelName, String company, int ram, int camera, double price) {
        this.mobileNo = mobileNo;
        this.modelName = modelName;
        Company = company;
        this.ram = ram;
        this.camera = camera;
        this.price = price;
    }

    public MobileDTO() {

    }


    public int getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(int mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getCompany() {
        return Company;
    }

    public void setCompany(String company) {
        Company = company;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getCamera() {
        return camera;
    }

    public void setCamera(int camera) {
        this.camera = camera;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "MobileDTO{" +
                "mobileNo=" + mobileNo +
                ", modelName='" + modelName + '\'' +
                ", Company='" + Company + '\'' +
                ", ram=" + ram +
                ", camera=" + camera +
                ", price=" + price +
                '}';
    }
}
