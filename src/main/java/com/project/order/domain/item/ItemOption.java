package com.project.order.domain.item;

import com.project.order.common.exception.InvalidParamException;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "item_options")
public class ItemOption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "item_option_group_id")
    private ItemOptionGroup itemOptionGroup;

    private Integer ordering;
    private String itemOptionName;
    private Long itemOptionPrice;

    public ItemOption(ItemOptionGroup itemOptionGroup, Integer ordering, String itemOptionName, Long itemOptionPrice) {
        if(itemOptionGroup == null) throw new InvalidParamException();
        if(ordering == null) throw new InvalidParamException();
        if(StringUtils.isBlank(itemOptionName)) throw new InvalidParamException();
        if(itemOptionPrice == null) throw new InvalidParamException();

        this.itemOptionGroup = itemOptionGroup;
        this.ordering = ordering;
        this.itemOptionName = itemOptionName;
        this.itemOptionPrice = itemOptionPrice;
    }
}
