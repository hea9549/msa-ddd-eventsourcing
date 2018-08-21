package com.itchain.samplemsa.samplemsa;

import org.junit.Test;

public class AggregateTest {

    @Test
    public void TestOnEvent(){
        SampleAggregate aggregate = new SampleAggregate();
        aggregate.startSecondEvent();
    }

    @Test
    public void errorTest(){
        asdf();
        System.out.println("오나요?");
    }

    public void asdf(){
        throw new RuntimeException();
    }
}
