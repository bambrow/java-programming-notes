package lombok_demo;

import lombok.Getter;
import lombok.SneakyThrows;

public class Cached {
    @Getter(lazy = true) private final long cached = expensive();
    // @Getter(lazy = true) will cache the value calculated and directly use it later on

    @SneakyThrows
    private long expensive() {
        Thread.sleep(5000);
        return System.currentTimeMillis();
    }
}
