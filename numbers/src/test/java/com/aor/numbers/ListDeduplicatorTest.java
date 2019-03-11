package com.aor.numbers;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class ListDeduplicatorTest {
    private List<Integer> list;
    private List<Integer> expected;

    @Before
    public void initialize(){
        list = new ArrayList();
        list.add(3);
        list.add(2);
        list.add(6);
        list.add(1);
        list.add(4);
        list.add(5);
        list.add(7);

        expected = new ArrayList();
        expected.add(1);
        expected.add(2);
        expected.add(3);
        expected.add(4);
        expected.add(5);
        expected.add(6);
        expected.add(7);

    }

    @Test
    public void deduplicate() {
        IListSorter sorter = Mockito.mock(IListSorter.class);

        List<Integer> sorted = new ArrayList();
        sorted.add(1);
        sorted.add(2);
        sorted.add(3);
        sorted.add(4);
        sorted.add(5);
        sorted.add(6);
        sorted.add(7);

        Mockito.when(sorter.sort()).thenReturn(sorted);

        ListDeduplicator deduplicator = new ListDeduplicator(list, sorter);
        List<Integer> distinct = deduplicator.deduplicate();

        assertEquals(expected, distinct);
    }

    @Test
    public void deduplicate_with_equals(){
        IListSorter sorter = Mockito.mock(IListSorter.class);

        List<Integer> sorted = new ArrayList();
        sorted.add(1);
        sorted.add(2);
        sorted.add(4);

        Mockito.when(sorter.sort()).thenReturn(sorted);


        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(2);
        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        expected.add(4);

        ListDeduplicator deduplicator = new ListDeduplicator(list, sorter);
        List<Integer> distinct = deduplicator.deduplicate();

        assertEquals(expected, distinct);
    }
}