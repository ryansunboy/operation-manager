package com.hundsun.operation.manager.enums;

public enum FileOutEnum {

    BALANCE_CHECKING("_balance_checking_", 0),
    PRODUCT_PRICE("_product_price_", 0),
    TOTAL_CLEAR("_total_clear_", 0),
    TRADE_CONFIRM("_trade_confirm_", 0),
    DISTRIBUTOR_PROFIT_CURRENCY("_distributor_profit_currency_", 926),
    INCOME_INFO("_income_info_", 926),
    USER_PROFIT_CURRENCY("_user_profit_currency_", 926);

    private String name;

    private int type;

    FileOutEnum(String name, int type){
        this.name = name;
    }

    public static FileOutEnum match(String name, FileOutEnum outEnum){
        if (name != null){
            for (FileOutEnum item:FileOutEnum.values()){
                if (item.name.indexOf(name) != -1){
                    return item;
                }
            }
        }
        return outEnum;
    }
}
