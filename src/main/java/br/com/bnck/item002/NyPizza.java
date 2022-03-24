package br.com.bnck.item002;

import java.util.Objects;

/**
 * Criado utilizando IntelliJ IDEA.
 * Projeto: javaefetivo3edicao
 * Usuário: Thiago Bianeck (Bianeck)
 * Data: 23/03/2022
 * Hora: 11:56
 */
public class NyPizza extends Pizza{
    public enum Size {SMALL, MEDIUM, LARGE};
    private final Size size;

    public static class Builder extends Pizza.Builder<Builder> {
        private final Size size;

        public Builder(Size size) {
            this.size = Objects.requireNonNull(size);
        }

        @Override
        public NyPizza build() {
            return new NyPizza(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    private NyPizza(Builder builder) {
        super(builder);
        size = builder.size;
    }
}
