package character.domain;

import ability.domain.CharacterAbility;
import ability.domain.CommonAbility;
import action.Attack;
import common.exception.CannotMountWeaponException;
import common.exception.NotFoundSkillException;
import skill.domain.Skill;
import weapon.domain.Weapon;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Character extends CharacterAbility implements Attack {
    private List<Skill> skills = new ArrayList<>();
    private Weapon weapon;
    private CharacterType characterType;

    public Character(CharacterAbility ability, CharacterType type) {
        super(ability);
        skills.addAll(Skill.getSkill(CharacterType.ALL));
        skills.addAll(Skill.getSkill(type));
        this.characterType = type;
    }

    public boolean castSkill(Skill castedSkill) {
        Skill skill = skills.stream()
                .filter(castedSkill::equals)
                .findFirst()
                .orElseThrow(NotFoundSkillException::new);

        if (skill.isUltimate() && !isUltimateLevel()) {
            return false;
        }

        if (useMana(skill.getUseMana())) {
            skill.cast(this);
            return true;
        }

        return false;
    }

    public void mount(Weapon weapon) {
        if (!weapon.getCharacterType().equals(characterType)) {
            throw new CannotMountWeaponException();
        }
        this.weapon = weapon;
        weapon.mount(this);
    }

    public void unMount() {
        this.weapon.unMount(this);
        this.weapon = null;
    }

    /**
     * 캐릭터 레벨업
     */
    @Override
    public CharacterAbility levelUp() {
        super.levelUp();
        return this;
    }

    /**
     * 캐릭터 공격
     * - 다음 공격이 가능할 경우에만 공격 한다간
     * - target의 HP를 줄인다.
     * - 딜레이 시간을 계산해서 다음 공격 가능시간을 저장한다.
     * - target의 hp가 0이면 false를 반환한다.
     */
    @Override
    public boolean attack(CommonAbility target) {
        if (!nextAttack()) {
            return false;
        }
        target.downHp(currentPower());
        increaseByDelay();
        return !target.isDie();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Character character = (Character) o;
        return Objects.equals(skills, character.skills)
                && Objects.equals(weapon, character.weapon)
                && characterType == character.characterType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), skills, weapon, characterType);
    }
}
