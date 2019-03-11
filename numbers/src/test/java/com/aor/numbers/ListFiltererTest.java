package com.aor.numbers;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class ListFiltererTest {
    List<Integer> list;

    @Before
    public void initialize(){
        list = new ArrayList<>();
        list.add(-1);
        list.add(2);
        list.add(3);
    }

    @Test
    public void filter_with_positive(){
        IListFilter filter = new PositiveFilter();
        ListFilterer filterer = new ListFilterer(list);

        List<Integer> expected = new ArrayList<>();
        expected.add(2);
        expected.add(3);

        List<Integer> actual = filterer.filter(filter);

        assertEquals(expected, actual);
    }

    @Test
    public void filter_with_divisible(){
        IListFilter filter = new DivisibleByFilter(2);
        ListFilterer filterer = new ListFilterer(list);

        List<Integer> expected = new ArrayList<>();
        expected.add(2);

        List<Integer> actual = filterer.filter(filter);

        assertEquals(expected, actual);
    }
}
