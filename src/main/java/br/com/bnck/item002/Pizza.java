package br.com.bnck.item002;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

/**
 * Criado utilizando IntelliJ IDEA.
 * Projeto: javaefetivo3edicao
 * Usuário: Thiago Bianeck (Bianeck)
 * Data: 23/03/2022
 * Hora: 11:45
 */
public abstract class Pizza {

    public enum Topping {HAM, MUSHROOM, ONION, PEPPER, SAUSAGE}
    final Set<Topping> toppings;

    abstract static class Builder<T extends Builder<T>> {
        EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);

        public T addTopping(Topping topping) {
            toppings.add(Objects.requireNonNull(topping));
            return self();
        }

        abstract Pizza build();

        // As subclasses devem sobrescrever esse método para retornar "essa classe protegida abstrata T;self()
        protected T self() {
            return null;
        }
    }

    Pizza(Builder<?> builder) {
        toppings = builder.toppings.clone();
    }
}
