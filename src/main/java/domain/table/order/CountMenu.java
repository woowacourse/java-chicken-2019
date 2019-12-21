package domain.table.order;

import static util.ErrorMessage.MENU_COUNT_OVERFLOW;

public class CountMenu {

    public final static int MAX_MENU_COUNT = 99;

    private int count;

    public CountMenu(final int count) {
        validate(count);
        this.count = count;
    }

    private void validate(final int count) {
        if (count > 99)
            throw new IllegalArgumentException(MENU_COUNT_OVERFLOW);
    }

    protected int getCount() {
        return count;
    }

    protected void setCount(int count) {
        validate(count);
        this.count = count;
    }

    @Override
    public String toString() {
        return count + "";
    }
}
