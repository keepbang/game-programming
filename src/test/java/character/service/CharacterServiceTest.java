package character.service;

import ability.domain.CharacterAbility;
import common.exception.WrongCharacterTypeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CharacterServiceTest {

    private CharacterService service = new CharacterService();

    @ParameterizedTest
    @ValueSource(strings = {
            "", "people", "elff"
    })
    @DisplayName("캐릭터 생성 실패")
    public void createCharacterFail(String type) {
        // given
        CharacterAbility ability = CharacterAbility.init(1, 100, 100, 10, 0.7, 10, 50);
        // when
        // then
        assertThatThrownBy(() -> service.createCharacter(type, ability))
                .isInstanceOf(WrongCharacterTypeException.class);
    }

}