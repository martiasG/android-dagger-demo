package dtos;

/**
 * Created by vm on 8/21/17.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
class AddressDto {
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("state")
    @Expose
    private String state;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
