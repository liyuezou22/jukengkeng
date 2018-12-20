package entity;

import java.io.Serializable;

public class result implements Serializable {

    private Boolean flag;
    private String message;

    public result(Boolean flag, String message) {
        super();
        this.flag = flag;
        this.message = message;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
