package com.itchain.samplemsa.samplemsa.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@Component
public class AggregateRepository<T extends Aggregate> {
    @Autowired
    @Qualifier("eventRepositoryImpl")
    private EventRepository eventRepository;

    public T findById(String id){
        List<Event> eventList = eventRepository.load(id);
        Class<T> mClass = (Class<T>) ClassUtils.getReclusiveGenericClass(getClass(), 0);
        if (mClass != null) {
            try {
                return mClass.getDeclaredConstructor(List.class).newInstance(eventList);
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public void save(T aggregate){
        aggregate.getEventList().forEach(event -> eventRepository.save(event));
    }
}
