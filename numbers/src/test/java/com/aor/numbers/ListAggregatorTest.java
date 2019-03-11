package com.aor.numbers;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ListAggregatorTest {

    List<Integer> list;

    @Before
    public void initialize(){
        list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(2);
        list.add(5);
    }

    @Test
    public void sum() {
        ListAggregator aggregator = new ListAggregator(list);

        int sum = aggregator.sum();

        assertEquals(14, sum);
    }

    @Test
    public void max() {
        ListAggregator aggregator = new ListAggregator(list);

        int max = aggregator.max();

        assertEquals(5, max);
    }

    @Test
    public void min() {
        ListAggregator aggregator = new ListAggregator(list);

        int min = aggregator.min();

        assertEquals(1, min);
    }

    @Test
    public void distinct() {
        IListDeduplicator deduplicator = Mockito.mock(IListDeduplicator.class);

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(5);

        Mockito.when(deduplicator.deduplicate()).thenReturn(list);

        ListAggregator aggregator = new ListAggregator(list);

        int distinct = aggregator.distinct(deduplicator);

        assertEquals(4, distinct);
    }

    @Test
    public void max_negative() {
        List<Integer> list = new ArrayList<>();
        list.add(-1);
        list.add(-4);
        list.add(-5);

        ListAggregator aggregator = new ListAggregator(list);

        int max = aggregator.max();

        assertEquals(-1, max);
    }

    @Test
    public void distinct_with_equals(){
        IListDeduplicator deduplicator = Mockito.mock(IListDeduplicator.class);

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(4);

        Mockito.when(deduplicator.deduplicate()).thenReturn(list);


        ListAggregator aggregator = new ListAggregator(list);
        int distinct = aggregator.distinct(deduplicator);

        assertEquals(3, distinct);
    }
}