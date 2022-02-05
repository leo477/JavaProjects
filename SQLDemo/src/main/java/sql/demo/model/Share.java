package sql.demo.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Share extends BaseModel {
    private String name;
    private BigDecimal startPrice;
    private int changeProbability;
    private int delta;

    public Share() {
    }

    public Share(long id, String name, int changeProbability, int delta) {
        super(id);
        this.name = name;
        this.changeProbability = changeProbability;
        this.delta = delta;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getChangeProbability() {
        return changeProbability;
    }

    public void setChangeProbability(int changeProbability) {
        this.changeProbability = changeProbability;
    }

    public int getDelta() {
        return delta;
    }

    public Share(long id, String name, BigDecimal startPrice, int changeProbability, int delta) {
        super(id);
        this.name = name;
        this.startPrice = startPrice;
        this.changeProbability = changeProbability;
        this.delta = delta;
    }

    public BigDecimal getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(BigDecimal startPrice) {
        this.startPrice = startPrice;
    }

    public void setDelta(int delta) {
        this.delta = delta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Share share = (Share) o;
        return changeProbability == share.changeProbability && delta == share.delta && Objects.equals(name, share.name) && Objects.equals(startPrice, share.startPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, startPrice, changeProbability, delta);
    }
}

