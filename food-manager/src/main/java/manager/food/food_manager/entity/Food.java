package manager.food.food_manager.entity;

import manager.food.food_manager.util.ValidationUtil;

import java.util.Date;
import java.util.HashMap;

public class Food {
    private int id;
    private String name;
    private String description;
    private String thumbnail;
    private double price;
    private String daysell;
    private String datefix;
    private int category_id;
    private int status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDaysell() {
        return daysell;
    }

    public void setDaysell(String daysell) {
        this.daysell = daysell;
    }

    public String getDatefix() {
        return datefix;
    }

    public void setDatefix(String datefix) {
        this.datefix = datefix;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Food(int id, String name, String description, String thumbnail, double price, String daysell, String datefix, int category_id, int status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.thumbnail = thumbnail;
        this.price = price;
        this.daysell = daysell;
        this.datefix = datefix;
        this.category_id = category_id;
        this.status = status;
    }

    public Food(String name, String description, String thumbnail, double price, String daysell, String datefix, int category_id, int status) {
        this.name = name;
        this.description = description;
        this.thumbnail = thumbnail;
        this.price = price;
        this.daysell = daysell;
        this.datefix = datefix;
        this.category_id = category_id;
        this.status = status;
    }

    public Food() {
        this.name = "";
        this.description = "";
        this.thumbnail ="";
        this.price = 0;
        this.daysell = "";
        this.datefix = "";
        this.category_id = 0;
        this.status = 0;
    }

    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", price=" + price +
                ", daysell='" + daysell + '\'' +
                ", datefix='" + datefix + '\'' +
                ", category_id=" + category_id +
                ", status=" + status +
                '}';
    }
    public boolean isValid(){
        return getErrors().size()==0;
    }
    public HashMap<String,String> getErrors(){
        HashMap<String,String> errors = new HashMap<>();
        if(name ==null || name.length() ==0){
            errors.put("name","Vui l??ng nh???p t??n");
        }else if(name.length()<=7){
            errors.put("name","T??n ph???i 7 k?? t??? tr??? l??n");
        }
        if(description ==null||name.length()==0){
            errors.put("description","Vui l??ng nh???p m?? t???");
        }
        if(thumbnail==null || thumbnail.length()==0){
            errors.put("thumbnail","Vui l??ng nh???p ???nh");
        }else if(!ValidationUtil.checkUrl(thumbnail)){
            errors.put("thumbnail","???nh sai ?????nh d???ng vui l??ng nh???p v??o m???t link");
        }
        if(price==0){
            errors.put("price","Vui l??ng nh???p gi?? ti???n");
        }else if(price <0){
            errors.put("price","Gi?? ti???n ph???i l???n h??n 0");
        }
        if (daysell ==null|| daysell.length()==0){
            errors.put("daysell","Vui l??ng ch???n ng??y t???o m??n");
        }
        if(datefix==null||datefix.length()==0){
            errors.put("datefix","Vui l??ng ch???n ng??y ch???nh s???a");
        }

        return errors;
    }
}
