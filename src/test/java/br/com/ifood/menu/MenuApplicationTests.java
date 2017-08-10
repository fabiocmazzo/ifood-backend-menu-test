package br.com.ifood.menu;

import br.com.ifood.menu.dto.ItemComboDto;
import br.com.ifood.menu.dto.ItemGroupDto;
import br.com.ifood.menu.dto.MenuDto;
import br.com.ifood.menu.dto.adapter.MenuAdapter;
import br.com.ifood.menu.model.entity.Menu;
import org.assertj.core.api.BigDecimalAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.constraints.AssertTrue;
import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.Assert.assertTrue;

/**
 * Test MenuApplication IFood Test.
 * @author Fabio Covolo Mazzo
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MenuApplicationTests {

    /**
     * Test transformation of entity to Dto for REST Response with price comparasion.
     */
    @Test
    public void afterTransformationComboMustCostFiveDollars() {
        boolean valueIsEqual = false;
        Menu menu = MockEntityUtil.createComboWithDifferentePrice();
        MenuDto menuDto = MenuAdapter.adapt(menu);
        Optional<ItemGroupDto> itemGroupDtoOptional = menuDto.getItemGroupDtoList().stream().filter(itemGroupDto -> "Combos".equals(itemGroupDto.getLabel())).findAny();
        if (itemGroupDtoOptional.isPresent()) {
            if (itemGroupDtoOptional.get().getItemComboDtoList() != null) {
                Optional<ItemComboDto> optComboDto = itemGroupDtoOptional.get().getItemComboDtoList().stream().findAny();
                if(optComboDto.isPresent()) {
                    valueIsEqual = new BigDecimal("5").compareTo(optComboDto.get().getStartPrice()) == 0;
                }
            }

        }
        assertTrue(valueIsEqual);
    }

}
