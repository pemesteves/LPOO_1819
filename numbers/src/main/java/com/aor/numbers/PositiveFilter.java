package com.aor.numbers;

public class PositiveFilter implements IListFilter {

    @Override
    public boolean accept(Integer number) {
        if(number.compareTo(0) > 0)
            return true;
        return false;
    }
}
