import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

public class MainTest {

    @Disabled("tets is disabled")
    @Test
    @DisplayName("test time main")
    @Timeout(value = 20)
    void failsIfExecutionTimeExceeds22Milliseconds() {
            Main.main(null);
    }


}
