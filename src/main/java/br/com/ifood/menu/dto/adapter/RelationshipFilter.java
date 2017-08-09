package br.com.ifood.menu.dto.adapter;

import br.com.ifood.menu.model.relationship.*;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Filter Relationship making restaurant relations priority.
 * @author Fabio Covolo Mazzo
 */
public class RelationshipFilter {


    /**
     * Filter HaveOption list giving priority to restaurant's relations.
     * @param haveOptionList
     * @return
     */
    public static List<HaveOption> filterHaveOption(List<HaveOption> haveOptionList) {
        List<HaveOption> filteredHaveOptionList = haveOptionList.stream().filter(haveOption -> {
            if(haveOption.getRestaurantCode() != null) {
                return true;
            }
            return !haveOptionList.stream().anyMatch(checkingHaveItem -> checkingHaveItem.getRestaurantCode() != null && Objects.equals(checkingHaveItem.getOption().getId(), haveOption.getOption().getId()));
        }).collect(Collectors.toList());
        return filteredHaveOptionList;
    }


    /**
     * Filter HaveOptionGroupSet
     * @param haveOptionGroupSet HaveOptionGroupSet
     * @return filtered HaveOptionGroupSet
     */
    public static Set<HaveOptionGroup> filterHaveOptionGroup(Set<HaveOptionGroup> haveOptionGroupSet) {
        Set<HaveOptionGroup> filteredHaveOptionGroupSet = haveOptionGroupSet.stream().filter(haveOptionGroup -> {
            if(haveOptionGroup.getRestaurantCode() != null) {
                return true;
            }
            return !haveOptionGroupSet.stream().anyMatch(checkingHaveItem -> checkingHaveItem.getRestaurantCode() != null && Objects.equals(checkingHaveItem.getOptionGroup().getId(), haveOptionGroup.getOptionGroup().getId()));
        }).collect(Collectors.toSet());
        return filteredHaveOptionGroupSet;
    }

    /**
     * Filter HaveComboItemSet
     * @param haveComboItemSet HaveComboItemSet
     * @return filtered HaveComboItemSet
     */
    public static Set<HaveComboItem> filterHaveComboItem(Set<HaveComboItem> haveComboItemSet) {
        Set<HaveComboItem> filteredHaveComboItemSet = haveComboItemSet.stream().filter(haveComboItem -> {
            if(haveComboItem.getRestaurantCode() != null) {
                return true;
            }
            return !haveComboItemSet.stream().anyMatch(checking -> checking.getRestaurantCode() != null && Objects.equals(checking.getItemCombo().getId(), haveComboItem.getItemCombo().getId()));
        }).collect(Collectors.toSet());
        return filteredHaveComboItemSet;
    }

    /**
     * Filter HaveComboOptionGroupSet
     * @param haveComboOptionGroupSet HaveComboOptionGroupSet
     * @return filtered HaveComboOptionGroupSet
     */
    public static Set<HaveComboOptionGroup> filterHaveComboOptionGroup(Set<HaveComboOptionGroup> haveComboOptionGroupSet) {
        Set<HaveComboOptionGroup> filteredHaveComboOptionGroupSet = haveComboOptionGroupSet.stream().filter(haveComboOptionGroup -> {
           if(haveComboOptionGroup.getRestaurantCode() != null) {
                return true;
            }
            return !haveComboOptionGroupSet.stream().anyMatch(checking -> checking.getRestaurantCode() != null && Objects.equals(checking.getOptionGroup().getId(), haveComboOptionGroup.getOptionGroup().getId()));
        }).collect(Collectors.toSet());
        return filteredHaveComboOptionGroupSet;
    }

    /**
     * Filter HaveItemSet
     * @param haveItemSet HaveItemSet
     * @return filterd
     */
    public static Set<HaveItem> filterHaveItem(Set<HaveItem> haveItemSet) {
        Set<HaveItem> filteredHaveItemSet = haveItemSet.stream().filter(haveItem -> {
           if(haveItem.getRestaurantCode() != null) {
                return true;
            }
            return !haveItemSet.stream().anyMatch(checkingHaveItem -> checkingHaveItem.getRestaurantCode() != null && Objects.equals(checkingHaveItem.getItem().getId(), haveItem.getItem().getId()));
        }).collect(Collectors.toSet());
        return filteredHaveItemSet;
    }

    /**
     * Filter HaveItemCombo
     * @param haveItemComboSet HaveItemComboSet
     * @return filtered HaveItemCombo
     */
    public static Set<HaveItemCombo> filterHaveItemCombo(Set<HaveItemCombo> haveItemComboSet) {
        Set<HaveItemCombo> filteredHaveItemCombo = haveItemComboSet.stream().filter(haveItemCombo -> {
            if(haveItemCombo.getRestaurantCode() != null) {
                return true;
            }
            return !haveItemComboSet.stream().anyMatch(checkingHaveItemCombo -> checkingHaveItemCombo.getRestaurantCode() != null && Objects.equals(checkingHaveItemCombo.getItemCombo().getId(), haveItemCombo.getItemCombo().getId()));
        }).collect(Collectors.toSet());
        return filteredHaveItemCombo;
    }


}
