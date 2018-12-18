package entity;

import java.io.Serializable;
import java.util.List;

/**
 * 分页实体类
 * total：总记录数
 * rows：所查询页数的记录数
 * */
public class pageResult implements Serializable {
    private long total;
    private List rows;

    public pageResult(long total, List rows) {
        super();
        this.total = total;
        this.rows = rows;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }
}
