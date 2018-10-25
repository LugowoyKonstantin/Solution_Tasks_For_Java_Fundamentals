package com.lugowoy.tasks.calculatingNumberProductsOfPurchasedFromCertainSum;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

import static com.lugowoy.helper.other.DeepCloning.CLONER;

/**Created by Konstantin Lugowoy on 11-Feb-17.*/

public final class User implements Serializable, Cloneable {

    private BigDecimal availableSumOfMoney;

    public User() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(getAvailableSumOfMoney(), user.getAvailableSumOfMoney());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAvailableSumOfMoney());
    }

    @Override
    public String toString() {
        return "User[" +
                "availableSumOfMoney=" + this.availableSumOfMoney +
                ']';
    }

    @Override
    public User clone() {
        User user = new User();
        try {
            user = (User) super.clone();
            user.setAvailableSumOfMoney(CLONER.deepClone(this.getAvailableSumOfMoney()));
        } catch (CloneNotSupportedException ex) {
            new InternalError(ex.getMessage()).printStackTrace();
        }
        return user;
    }

    public BigDecimal getAvailableSumOfMoney() {
        return this.availableSumOfMoney;
    }

    public void setAvailableSumOfMoney(BigDecimal availableSumOfMoney) {
        try {
            if ((availableSumOfMoney != null) && (availableSumOfMoney.doubleValue() >= 0)) {
                this.availableSumOfMoney = availableSumOfMoney;
            } else {
                throw new IllegalArgumentException("The available sum of money passed by argument is incorrect.");
            }
        } catch (IllegalArgumentException ex) {
            System.err.println(ex.getMessage());
        }
    }

}
