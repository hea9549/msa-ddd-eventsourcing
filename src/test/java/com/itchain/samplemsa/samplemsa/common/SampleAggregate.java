package com.itchain.samplemsa.samplemsa.common;

public class SampleAggregate extends Aggregate {
    @Override
    public String getID() {
        return null;
    }

    public SampleAggregate(){
        super();
        apply(new SampleEvent());
    }

    public void startSecondEvent() {
        apply(new SecondEvent());
    }

    @OnEvent
    public void OnTestEvent(SampleEvent event){
        System.out.println("이벤트가 도착했습니다!");
    }

    @OnEvent
    public void OnSecondEvent(SecondEvent event){
        System.out.println("이벤트가 도착했습니다!22222");

    }
}
