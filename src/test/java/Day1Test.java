import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class Day1Test {

    @Test
    public void calculateCurrentFrequency() {
        int currentFrequency = Day1.calculateCurrentFrequency(Arrays.asList("1", "2", "100"));

        assertThat(currentFrequency).isEqualTo(102);
    }

}
