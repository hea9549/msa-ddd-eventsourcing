package com.itchain.samplemsa.samplemsa;

import com.itchain.samplemsa.samplemsa.common.Event;
import lombok.*;

@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class SampleEvent implements Event {
    @NonNull
    private String ID;
    @Override
    public String getID() {
        return this.ID;
    }
}
