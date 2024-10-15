package lotto.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import lotto.domain.LottoStatistics;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LottoStatisticsTest {
    @Test
    public void 로또_맞춘_갯수_증가() {
        LottoStatistics lottoStatistics = new LottoStatistics();
        lottoStatistics.incrementMatchCount(3, false);
        assertThat(lottoStatistics.getCountByMatchCount(3, false)).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 7})
    public void 로또_맞춘_갯수가_유효하지_않을_시_IllegalArgumentException_발생(int matchCount) {
        LottoStatistics lottoStatistics = new LottoStatistics();
        assertThatThrownBy(() -> lottoStatistics.incrementMatchCount(matchCount, false))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
